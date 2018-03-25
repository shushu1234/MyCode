package com.liuyao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created By liuyao on 2018/3/25 22:29.
 */
public class SemaphoreTest {
//    设置总的线程数为30个
    private static final int THREAD_COUNT=30;

    private static ExecutorService threadPool= Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore s=new Semaphore(10);

    public static void main(String[] args) {
        for (int i=0; i < THREAD_COUNT;i++){
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
//                       只允许10个并发执行，acquire获取许可证
                        s.acquire();
                        System.out.println("save data");
                        TimeUnit.SECONDS.sleep(3);
//                        release释放许可证
                        s.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        threadPool.shutdown();
    }
}

