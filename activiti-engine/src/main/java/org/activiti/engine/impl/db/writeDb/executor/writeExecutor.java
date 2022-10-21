package org.activiti.engine.impl.db.writeDb.executor;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

public class writeExecutor {
    private static ThreadPoolExecutor writeExecutor=new ThreadPoolExecutor(1, 10, 60, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), 
    new CustomizableThreadFactory("writeToMysql--"), new ThreadPoolExecutor.CallerRunsPolicy());

    public static void write(Runnable runnable) {
        writeExecutor.execute(runnable);
    }
}
