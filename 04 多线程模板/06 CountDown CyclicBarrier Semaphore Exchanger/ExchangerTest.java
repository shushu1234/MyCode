package com.liuyao;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created By liuyao on 2018/3/25 22:40.
 */
public class ExchangerTest {
    private static Exchanger<String> exgr=new Exchanger<String>();

    private static ExecutorService threadPool= Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A="银行流水A";
                    exgr.exchange(A);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B="银行流水A";
                    String A=exgr.exchange(B);
                    System.out.println("A和B录入的是否一致："+A.equals(B));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.shutdown();
    }

}
