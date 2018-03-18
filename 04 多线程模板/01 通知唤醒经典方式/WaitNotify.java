package com.liuyao1;

import com.liuyao.test.SleepUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created By liuyao on 2018/3/4 16:18.
 */
public class WaitNotify {
    static boolean flag=true;
    static Object lock=new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread=new Thread(new Wait(),"WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread=new Thread(new Notify(),"NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable{

        @Override
        public void run() {
//            加锁，拥有lock的monitor
            synchronized (lock){
//                当条件不满足的时候，继续wait，同时释放lock的锁
                while (flag){
                    try {
                        System.out.println(Thread.currentThread()+" flag is true.wait@ "+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread()+" flag is false.running@ "+ new SimpleDateFormat("HH:mm:ss").format(new Date()));

            }
        }
    }

    static class Notify implements Runnable{

        @Override
        public void run() {
//            加锁，拥有lock的monitor
            synchronized (lock){
//                获取lock的锁，然后进行通知，通知时不会释放lock的锁，
//                直到当前线程释放了lock后，WaitThread才能从wait方法中返回
                System.out.println(Thread.currentThread()+" hold lock.notify@ "+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag=false;
                SleepUtils.second(5);
            }
            synchronized (lock){
                System.out.println(Thread.currentThread()+" hold lock again.notify@ "+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(5);

            }
        }
    }
}
