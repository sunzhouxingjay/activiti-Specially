package org.activiti.engine.impl.db.cache;
/**
 * 做一个Oid与业务数据一一对应的HashMap
 * 给方便serviceTask取业务数据，并将返回的结果缓存到map里
 * 在给用户返回结果时，将业务数据一起返回并清空
 */

import java.util.concurrent.ConcurrentHashMap;

public class businessCache {
    //假定返回回来的结果是下一个任务所需要的
    private static ConcurrentHashMap<String,String> cachedBusinessData=new ConcurrentHashMap<>();

    public static void put(String oid,String businessData) {
        cachedBusinessData.put(oid,businessData);
    }

    public static String get(String oid) {
        return cachedBusinessData.get(oid);
    }

    public static String remove(String oid) {
        return cachedBusinessData.remove(oid);
    }
}
