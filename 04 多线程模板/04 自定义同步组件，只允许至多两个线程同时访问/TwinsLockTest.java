package com.liuyao;

import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * Created By liuyao on 2018/3/18 14:08.
 */
public class TwinsLockTest {
    @Test
    public void test(){
        final Lock lock=new TwinsLock();
        class Worker extends Thread{
            public void run(){
                while (true){
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

//        启动10个线程
        for (int i = 0; i < 10; i++) {
            Worker worker=new Worker();
//            全部设置为守护线程，当主线程结束的时候就自动结束
            worker.setDaemon(true);
            worker.start();
        }

//      每隔一秒就换行，程序在启动完10个线程之后再执行10秒
//        由于每次让两个线程共享，所以成对输出
        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            System.out.println();
        }
    }
}
