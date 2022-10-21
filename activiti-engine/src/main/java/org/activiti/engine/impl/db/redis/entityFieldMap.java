package org.activiti.engine.impl.db.redis;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class entityFieldMap {
    public final static String TASK="Task";
    public final static String EXECUTION="Execution";
    public final static String VARIABLE="Variable";
    public final static String PROCDEF="ProcessDefinition";
    public final static String DEPLOYMENT="Deployment";
    public final static String RESOURCE="Resource";
    public final static String EVENT="Event";
    public final static String Field_ExecutionId="executionId";
    public final static String Field_ProcessInstanceId="processInstanceId";
    public final static String Field_ParentTaskId="parentTaskId";
    public final static String Field_TaskId="taskId";
    public final static String Field_Name="name";
    public final static String Field_SuperExec="superExec";//这个可能要删除
    public final static String Field_ParentExecutionId="parentExecutionId";
    public final static String Field_DeploymentId="deploymentId";
    public final static String Field_Category="category";
    public final static String Field_Key="key";
    public final static String Field_TenantId="tenantId";
    public final static String Field_ResourceName="resourceName";
    public final static String Field_EventName="eventName";
    public final static String Field_EventType="eventType";
    public final static String compositeKey_EventType_EventName_ExecutionId=compositeKey(Field_EventType,Field_EventName,Field_ExecutionId);

    private static volatile Map<String,ConcurrentHashMap<String,Set<String>>> taskFieldMap=new HashMap<>();
    private static volatile Map<String,ConcurrentHashMap<String,Set<String>>> executionFieldMap=new HashMap<>();
    private static volatile Map<String,ConcurrentHashMap<String,Set<String>>> variableFieldMap=new HashMap<>();
    private static volatile Map<String,ConcurrentHashMap<String,Set<String>>> procdefFieldMap=new HashMap<>();
    private static volatile Map<String,ConcurrentHashMap<String,Set<String>>> deploymentFieldMap=new HashMap<>();
    private static volatile Map<String,ConcurrentHashMap<String,Set<String>>> resourceFieldMap=new HashMap<>();
    private static volatile Map<String,ConcurrentHashMap<String,Set<String>>> eventFieldMap=new HashMap<>();

    public static void initEntityFieldMap() {
        taskFieldMap.put(Field_ExecutionId,new ConcurrentHashMap<String,Set<String>>(200000));
        taskFieldMap.put(Field_ProcessInstanceId, new ConcurrentHashMap<String,Set<String>>(200000));
        taskFieldMap.put(Field_ParentTaskId,new ConcurrentHashMap<String,Set<String>>(200000));
        variableFieldMap.put(Field_ExecutionId,new ConcurrentHashMap<String,Set<String>>(200000));
        variableFieldMap.put(Field_TaskId,new ConcurrentHashMap<String,Set<String>>(200000));
        executionFieldMap.put(Field_ProcessInstanceId,new ConcurrentHashMap<String,Set<String>>(200000));
        executionFieldMap.put(Field_Name,new ConcurrentHashMap<String,Set<String>>(200000));
        executionFieldMap.put(Field_SuperExec,new ConcurrentHashMap<String,Set<String>>(200000));
        executionFieldMap.put(Field_ParentExecutionId,new ConcurrentHashMap<String,Set<String>>(200000));
        procdefFieldMap.put(Field_DeploymentId,new ConcurrentHashMap<String,Set<String>>(200000));
        deploymentFieldMap.put(Field_Name,new ConcurrentHashMap<String,Set<String>>(200000));
        resourceFieldMap.put(Field_DeploymentId,new ConcurrentHashMap<String,Set<String>>(200000));
        //eventFieldMap.put(Field_EventName,new ConcurrentHashMap<String,Set<String>>(200000));
        //eventFieldMap.put(Field_EventType,new ConcurrentHashMap<String,Set<String>>(200000));
        eventFieldMap.put(Field_ExecutionId,new ConcurrentHashMap<String,Set<String>>(200000));
        eventFieldMap.put(compositeKey_EventType_EventName_ExecutionId,new ConcurrentHashMap<String,Set<String>>(200000));
    }

    //组合键
    public static String compositeKey(String... keys) {
        StringBuilder stringBuilder=new StringBuilder();
        for (String key:keys) {
            stringBuilder.append(key).append(':');
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    public static void setEntityFieldMap(String entityType,String field,String fieldValue,String entityId) {
        switch (entityType) {
            case TASK:
                setTaskEntityFieldMap(field, fieldValue, entityId);
                break;
            case EXECUTION:
                setExecutionEntityFieldMap(field, fieldValue, entityId);
                break;
            case VARIABLE:
                setVariableEntityFieldMap(field, fieldValue, entityId);
                break;
            case PROCDEF:
                setProcdefEntityFieldMap(field, fieldValue, entityId);
                break;
            case DEPLOYMENT:
                setDeploymentEntityFieldMap(field, fieldValue, entityId);
                break;
            case RESOURCE:
                setResourceEntityFieldMap(field, fieldValue, entityId);
                break;
            case EVENT:
                setEventSubscriptionEntityFieldMap(field, fieldValue, entityId);
                break;
            default:
                return;
        }
    }

    private static void setTaskEntityFieldMap(String field,String fieldValue,String entityId) {
        // synchronized (taskFieldMap.get(field)) {
        //     if (!taskFieldMap.get(field).containsKey(fieldValue)) {
        //         taskFieldMap.get(field).put(fieldValue,new HashSet<>());
        //     }
        // }
        if (!taskFieldMap.get(field).containsKey(fieldValue)) {
            taskFieldMap.get(field).put(fieldValue,new HashSet<>());
        }
        taskFieldMap.get(field).get(fieldValue).add(entityId);
    }

    private static void setExecutionEntityFieldMap(String field,String fieldValue,String entityId) {
        // synchronized (executionFieldMap.get(field)) {
        //     if (!executionFieldMap.get(field).containsKey(fieldValue)) {
        //         executionFieldMap.get(field).put(fieldValue,new HashSet<>());
        //     }
        // }
        if (!executionFieldMap.get(field).containsKey(fieldValue)) {
            executionFieldMap.get(field).put(fieldValue,new HashSet<>());
        }
        executionFieldMap.get(field).get(fieldValue).add(entityId);
    }

    private static void setVariableEntityFieldMap(String field,String fieldValue,String entityId) {
        // synchronized (variableFieldMap.get(field)) {
        //     if (!variableFieldMap.get(field).containsKey(fieldValue)) {
        //         variableFieldMap.get(field).put(fieldValue,new HashSet<>());
        //     }
        // }
        if (!variableFieldMap.get(field).containsKey(fieldValue)) {
            variableFieldMap.get(field).put(fieldValue,new HashSet<>());
        }
        variableFieldMap.get(field).get(fieldValue).add(entityId);
    }

    private static void setProcdefEntityFieldMap(String field,String fieldValue,String entityId) {
        // synchronized (procdefFieldMap.get(field)) {
        //     if (!procdefFieldMap.get(field).containsKey(fieldValue)) {
        //         procdefFieldMap.get(field).put(fieldValue,new HashSet<>());
        //     }
        // }
        if (!procdefFieldMap.get(field).containsKey(fieldValue)) {
            procdefFieldMap.get(field).put(fieldValue,new HashSet<>());
        }
        procdefFieldMap.get(field).get(fieldValue).add(entityId);
    }

    private static void setDeploymentEntityFieldMap(String field,String fieldValue,String entityId) {
        // synchronized (deploymentFieldMap.get(field)) {
        //     if (!deploymentFieldMap.get(field).containsKey(fieldValue)) {
        //         deploymentFieldMap.get(field).put(fieldValue,new HashSet<>());
        //     }
        // }
        if (!deploymentFieldMap.get(field).containsKey(fieldValue)) {
            deploymentFieldMap.get(field).put(fieldValue,new HashSet<>());
        }
        deploymentFieldMap.get(field).get(fieldValue).add(entityId);
    }

    private static void setResourceEntityFieldMap(String field,String fieldValue,String entityId) {
        // synchronized (resourceFieldMap.get(field)) {
        //     if (!resourceFieldMap.get(field).containsKey(fieldValue)) {
        //         resourceFieldMap.get(field).put(fieldValue,new HashSet<>());
        //     }
        // }
        if (!resourceFieldMap.get(field).containsKey(fieldValue)) {
            resourceFieldMap.get(field).put(fieldValue,new HashSet<>());
        }
        resourceFieldMap.get(field).get(fieldValue).add(entityId);
    }

    private static void setEventSubscriptionEntityFieldMap(String field,String fieldValue,String entityId) {
        if (!eventFieldMap.get(field).containsKey(fieldValue)) {
            //eventFieldMap.get(field).put(fieldValue,Collections.synchronizedSet(new HashSet<>()));
            eventFieldMap.get(field).put(fieldValue,new HashSet<>());
        }
        eventFieldMap.get(field).get(fieldValue).add(entityId);
    }

    public static Set<String> getEntityIdByFieldValue(String entityType,String field,String fieldValue) {
        switch (entityType) {
            case TASK:
                return getTaskEntityIdByFieldValue(field,fieldValue);
            case EXECUTION:
                return getExecutionEntityIdByFieldValue(field,fieldValue);
            case VARIABLE:
                return getVariableEntityIdByFieldValue(field,fieldValue);
            case PROCDEF:
                return getProcdefEntityIdByFieldValue(field,fieldValue);
            case DEPLOYMENT:
                return getDeploymentEntityIdByFieldValue(field,fieldValue);
            case RESOURCE:
                return getResourceEntityIdByFieldValue(field,fieldValue);
            case EVENT:
                return getEventSubSrcEntityIdByFieldValue(field, fieldValue);
            default:
                return new HashSet<>();
        }
        
    }

    private static Set<String> getTaskEntityIdByFieldValue(String field,String fieldValue) {
        Set<String> res;
        if (!taskFieldMap.get(field).containsKey(fieldValue)) {
            res=new HashSet<>();
        } else {
            res=taskFieldMap.get(field).get(fieldValue);
        }
        return res;
    }

    private static Set<String> getExecutionEntityIdByFieldValue(String field,String fieldValue) {
        Set<String> res;
        if (!executionFieldMap.get(field).containsKey(fieldValue)) {
            res=new HashSet<>();
        } else {
            res=executionFieldMap.get(field).get(fieldValue);
        }
        return res;
    }

    private static Set<String> getVariableEntityIdByFieldValue(String field,String fieldValue) {
        Set<String> res;
        if (!variableFieldMap.get(field).containsKey(fieldValue)) {
            res= new HashSet<>();
        } else {
            res= variableFieldMap.get(field).get(fieldValue);
        }
        return res;
    }

    private static Set<String> getProcdefEntityIdByFieldValue(String field,String fieldValue) {
        Set<String> res;
        if (!procdefFieldMap.get(field).containsKey(fieldValue)) {
            res= new HashSet<>();
        } else {
            res= procdefFieldMap.get(field).get(fieldValue);
        }
        return res;
    }

    private static Set<String> getDeploymentEntityIdByFieldValue(String field,String fieldValue) {
        Set<String> res;
        if (!deploymentFieldMap.get(field).containsKey(fieldValue)) {
            res= new HashSet<>();
        } else {
            res= deploymentFieldMap.get(field).get(fieldValue);
        }
        return res;
    }

    private static Set<String> getResourceEntityIdByFieldValue(String field,String fieldValue) {
        Set<String> res;
        if (!resourceFieldMap.get(field).containsKey(fieldValue)) {
            res= new HashSet<>();
        } else {
            res= resourceFieldMap.get(field).get(fieldValue);
        }
        return res;
    }

    private static Set<String> getEventSubSrcEntityIdByFieldValue(String field,String fieldValue) {
        Set<String> res;
        if (!eventFieldMap.get(field).containsKey(fieldValue)) {
            res=new HashSet<>();
        } else {
            res=eventFieldMap.get(field).get(fieldValue);
        }
        return res;
    }

    public static void removeEntityFieldMap(String entityType,String field,String fieldValue,String entityId) {
        switch (entityType) {
            case TASK:
                removeTaskEntityFieldMap(field, fieldValue, entityId);
                break;
            case EXECUTION:
                removeExecutionEntityFieldMap(field, fieldValue, entityId);
                break;
            case VARIABLE:
                removeVariableEntityFieldMap(field, fieldValue, entityId);
                break;
            case PROCDEF:
                removeProcdefEntityFieldMap(field, fieldValue, entityId);
                break;
            case DEPLOYMENT:
                removeDeploymentEntityFieldMap(field, fieldValue, entityId);
                break;
            case RESOURCE:
                removeResourceEntityFieldMap(field, fieldValue, entityId);
                break;
            case EVENT:
                removeEventSubSrcEntityFieldMap(field, fieldValue, entityId);
                break;
            default:
                return;
        }
    }

    private static void removeTaskEntityFieldMap(String field,String fieldValue,String entityId) {
        taskFieldMap.get(field).get(fieldValue).remove(entityId);
        if (taskFieldMap.get(field).get(fieldValue).isEmpty()) {
            taskFieldMap.get(field).remove(fieldValue);
        }
        // synchronized (taskFieldMap.get(field)) {
        //     if (taskFieldMap.get(field).get(fieldValue).isEmpty()) {
        //         taskFieldMap.get(field).remove(fieldValue);
        //     }
        // }
    }

    private static void removeExecutionEntityFieldMap(String field,String fieldValue,String entityId) {
        executionFieldMap.get(field).get(fieldValue).remove(entityId);
        if (executionFieldMap.get(field).get(fieldValue).isEmpty()) {
            executionFieldMap.get(field).remove(fieldValue);
        }
        // synchronized (executionFieldMap.get(field)) {
        //     if (executionFieldMap.get(field).get(fieldValue).isEmpty()) {
        //         executionFieldMap.get(field).remove(fieldValue);
        //     }
        // }
    }

    private static void removeVariableEntityFieldMap(String field,String fieldValue,String entityId) {
        variableFieldMap.get(field).get(fieldValue).remove(entityId);
        if (variableFieldMap.get(field).get(fieldValue).isEmpty()) {
            variableFieldMap.get(field).remove(fieldValue);
        }
        // synchronized (variableFieldMap.get(field)) {
        //     if (variableFieldMap.get(field).get(fieldValue).isEmpty()) {
        //         variableFieldMap.get(field).remove(fieldValue);
        //     }
        // }
    }

    private static void removeProcdefEntityFieldMap(String field,String fieldValue,String entityId) {
        procdefFieldMap.get(field).get(fieldValue).remove(entityId);
        if (procdefFieldMap.get(field).get(fieldValue).isEmpty()) {
            procdefFieldMap.get(field).remove(fieldValue);
        }
        // synchronized (procdefFieldMap.get(field)) {
        //     if (procdefFieldMap.get(field).get(fieldValue).isEmpty()) {
        //         procdefFieldMap.get(field).remove(fieldValue);
        //     }
        // }
    }

    private static void removeDeploymentEntityFieldMap(String field,String fieldValue,String entityId) {
        deploymentFieldMap.get(field).get(fieldValue).remove(entityId);
        if (deploymentFieldMap.get(field).get(fieldValue).isEmpty()) {
            deploymentFieldMap.get(field).remove(fieldValue);
        }
        // synchronized (deploymentFieldMap.get(field)) {
        //     if (deploymentFieldMap.get(field).get(fieldValue).isEmpty()) {
        //         deploymentFieldMap.get(field).remove(fieldValue);
        //     }
        // }
    }

    private static void removeResourceEntityFieldMap(String field,String fieldValue,String entityId) {
        resourceFieldMap.get(field).get(fieldValue).remove(entityId);
        if (resourceFieldMap.get(field).get(fieldValue).isEmpty()) {
            resourceFieldMap.get(field).remove(fieldValue);
        }    
        // synchronized (resourceFieldMap.get(field)) {
        //     if (resourceFieldMap.get(field).get(fieldValue).isEmpty()) {
        //         resourceFieldMap.get(field).remove(fieldValue);
        //     }            
        // }
    }

    private static void removeEventSubSrcEntityFieldMap(String field,String fieldValue,String entityId) {
        eventFieldMap.get(field).get(fieldValue).remove(entityId);
        if (eventFieldMap.get(field).get(fieldValue).isEmpty()) {
            eventFieldMap.get(field).remove(fieldValue);
        }
    }
}
