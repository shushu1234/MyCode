package com.liuyao;

import java.util.concurrent.CountDownLatch;

/**
 * Created By liuyao on 2018/3/19 20:00.
 */
public class CountDownLatchTest {
//    CountDownLatch允许一个或多个线程等待其他线程完成操作 初始化为N个
    static CountDownLatch c=new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
//                调用countDown方法后N就会减一，一个线程的countDown方法happen-before
//                另个线程的的await方法
                c.countDown();
                System.out.println(6);
                c.countDown();
            }
        }).start();
//        使线程阻塞等待，N减为0时，才可以继续执行
        c.await();
        System.out.println(3);
    }
}
