package org.activiti.engine.impl.db.cache;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.activiti.engine.impl.db.redis.useRedis;
import org.activiti.engine.impl.db.redisEntity.*;
import org.activiti.engine.impl.persistence.entity.DeploymentEntityImpl;
import org.activiti.engine.impl.persistence.entity.Entity;
import org.activiti.engine.impl.persistence.entity.TaskEntityImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;


public class cachedFlushObjects {
    /*
     * 以Oid作为key
     */
    private static volatile ConcurrentHashMap<String,Map<Class<? extends Entity>, Map<String, Entity>>> cachedInsert=new ConcurrentHashMap<>(200000);
    private static volatile ConcurrentHashMap<String,Map<Class<? extends Entity>, Map<String, Entity>>> cachedDelete=new ConcurrentHashMap<>(200000);
    private static volatile ConcurrentHashMap<String,List<Entity>> cachedUpdate=new ConcurrentHashMap<>(200000);
    //private static volatile Map<String,HashMap<String,String>> currentTaskId=new HashMap<>();//这个也准备改到activiti上一层
    private static volatile ConcurrentHashMap<String,cachedResponse> cachedResponse=new ConcurrentHashMap<>(200000);
    private static Logger logger=LoggerFactory.getLogger(cachedFlushObjects.class);

    public static String flushCachedObjectsToRedis(String[] Oids) {
        List<Map<Class<? extends Entity>, Map<String, Entity>>> insertedList=new LinkedList<>();
        List<Map<Class<? extends Entity>, Map<String, Entity>>> deletedList=new LinkedList<>();
        List<Entity> updatedObjects=new ArrayList<>();
        // synchronized (cachedInsert) {
        //     for (String Oid:Oids) {
        //         insertedList.add(cachedInsert.remove(Oid));
        //     }
        // }
        // synchronized (cachedUpdate) {
        //     for (String Oid:Oids) {
        //         updatedObjects.addAll(cachedUpdate.remove(Oid));
        //     }
        // }
        // synchronized (cachedDelete) {
        //     for (String Oid:Oids) {
        //         deletedList.add(cachedDelete.remove(Oid));
        //     }
        // }


        //添加需要写入redis的内容
        // for (String Oid:Oids) {
        //     //加入
        //     //需要价格判定，不判定，Oid不存在会加入空的hashMap
        //     synchronized (cachedInsert) {
        //         insertedList.add(cachedInsert.remove(Oid));
        //     }
        //     synchronized (cachedUpdate) {
        //         updatedObjects.addAll(cachedUpdate.remove(Oid));
        //     }
        //     synchronized (cachedDelete) {
        //         deletedList.add(cachedDelete.remove(Oid));
        //     }
        // }

        for (String Oid:Oids) {
            //加入
            //需要价格判定，不判定，Oid不存在会加入空的hashMap
            insertedList.add(cachedInsert.remove(Oid));
            updatedObjects.addAll(cachedUpdate.remove(Oid));
            deletedList.add(cachedDelete.remove(Oid));
        }

        useRedis.insertListToRedis(insertedList);
        useRedis.updateToRedis(updatedObjects);
        useRedis.deleteListToRedis(deletedList);

        return "success";
    }

    //欲执行的结果先存入cache,等待链上数据写入后，执行写库操作----注意深拷贝，浅拷贝，Map为深拷贝,List的addAll
    public static void storeInsertToCache(Map<Class<? extends Entity>, Map<String, Entity>> insertedObjects,String Oid) {
        if (!cachedInsert.containsKey(Oid)) {
            cachedInsert.put(Oid,new HashMap<Class<? extends Entity>, Map<String, Entity>>());
            cachedInsert.get(Oid).putAll(insertedObjects);
        } else {
            for (Class<? extends Entity> clazz:insertedObjects.keySet()) {
                if (!cachedInsert.get(Oid).containsKey(clazz)) {
                    cachedInsert.get(Oid).put(clazz,new HashMap<String,Entity>());
                }
                cachedInsert.get(Oid).get(clazz).putAll(insertedObjects.get(clazz));
            }
        }
    }

    public static void storeUpdateToCache(List<Entity> updatedObjects,String Oid) {
        if (!cachedUpdate.containsKey(Oid)) {
            cachedUpdate.put(Oid,new LinkedList<Entity>());
        }
        cachedUpdate.get(Oid).addAll(updatedObjects);
    }

    public static void storeDeleteToCache(Map<Class<? extends Entity>, Map<String, Entity>> deletedObjects,String Oid) {
        if (!cachedDelete.containsKey(Oid)) {
            // synchronized (cachedDelete) {
            //     cachedDelete.put(Oid,new HashMap<Class<? extends Entity>, Map<String, Entity>>());
            // }
            cachedDelete.put(Oid,new HashMap<Class<? extends Entity>, Map<String, Entity>>());
            cachedDelete.get(Oid).putAll(deletedObjects);
        } else {
            for (Class<? extends Entity> clazz:deletedObjects.keySet()) {
                if (!cachedDelete.get(Oid).containsKey(clazz)) {
                    cachedDelete.get(Oid).put(clazz,new HashMap<String,Entity>());
                }
                cachedDelete.get(Oid).get(clazz).putAll(deletedObjects.get(clazz));
            }
        }
    }

    public static void storeDataToCache(Map<Class<? extends Entity>, Map<String, Entity>> insertedObjects,List<Entity> updatedObjects,
    Map<Class<? extends Entity>, Map<String, Entity>> deletedObjects,String Oid,String businessData) {
        //处理数据获得cachedResponse结构体
        cachedResponse response=new cachedResponse();
        response.setOid(Oid);
        response.setBusinessData(businessData);
        if (insertedObjects.isEmpty()&&updatedObjects.isEmpty()&&updatedObjects.isEmpty()) {
            logger.info("this operation has no data to change");
            System.out.println("no entity to update");
            //return;//均为空，没有需要插入或者删除的实体
        }

        if (insertedObjects.containsKey(DeploymentEntityImpl.class)) {
            response.setDeploy(true);
            //一次insert只有一个deployment
            for (Entity entity:insertedObjects.get(DeploymentEntityImpl.class).values()) {
                response.setDeploymentName(((DeploymentEntityImpl)entity).getName());
            }
        } 
        //设置fromTask与toTask
        Map<String,String> fromTasks=new HashMap<>();
        if (deletedObjects.containsKey(TaskEntityImpl.class)) {
            for (Entity entity:deletedObjects.get(TaskEntityImpl.class).values()) {
                TaskEntityImpl fromTask=(TaskEntityImpl)entity;
                fromTasks.put(fromTask.getName(),fromTask.getId());
            }
        }
        response.setFromTask(fromTasks);
        Map<String,String> toTasks=new HashMap<>();
        if (insertedObjects.containsKey(TaskEntityImpl.class)) {
            for (Entity entity:insertedObjects.get(TaskEntityImpl.class).values()) {
                TaskEntityImpl toTask=(TaskEntityImpl)entity;
                toTasks.put(toTask.getName(),toTask.getId());
            }
        }
        response.setToTasks(toTasks);


        //将数据存入cache
        storeInsertToCache(insertedObjects, Oid);
        storeUpdateToCache(updatedObjects, Oid);
        storeDeleteToCache(deletedObjects, Oid);
        cachedResponse.put(Oid,response);
    }

    //删除并返回
    public static cachedResponse getWorkflowResponse(String Oid) {
        cachedResponse response;
        // synchronized (cachedResponse) {
        //     response=cachedResponse.remove(Oid);
        // }
        response=cachedResponse.remove(Oid);
        return response;
    }


}
