package com.liuyao1;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created By liuyao on 2018/3/4 15:24.
 */
public class Shutdown {
    public static void main(String[] args) throws InterruptedException {
        Runner one=new Runner();
        Thread countThread=new Thread(one,"CountThread");
        countThread.start();
//        睡眠1秒，main线程对countThread进行中断，使countThread能感知中断而结束
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();
        Runner two=new Runner();
        countThread=new Thread(two,"CountThread");
        countThread.start();
//        睡眠1秒，main线程对Runner two进行取消，使countThread能感知on为false而结束
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }

    private static class Runner implements Runnable{
        private long i;
        private volatile boolean on=true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("Count i= "+i);
        }
        public void cancel(){
            on=false;
        }

    }
}
