package com.liuyao;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created By liuyao on 2018/3/25 21:28.
 */
public class CyclicBarrierTest2 {
//    线程到达屏障时，先执行A
    static CyclicBarrier c=new CyclicBarrier(2,new A());

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(3);
            }
        }).start();

        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println(2);
    }

    static class A implements Runnable{

        @Override
        public void run() {
            System.out.println("A");
        }
    }

}
