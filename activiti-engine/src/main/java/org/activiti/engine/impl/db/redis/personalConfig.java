package org.activiti.engine.impl.db.redis;

import org.springframework.beans.factory.annotation.Value;

public class personalConfig {
    @Value(value ="${flushType.useBlockChain}")
    private static boolean useBlockChain;
    @Value(value ="${flushType.useRedis}")
    private static boolean useReidsCache=true;

    public static boolean isUseBlockChain() {
        return useBlockChain;
    }

    public static boolean isUseRedis() {
        return useReidsCache;
    }
}
