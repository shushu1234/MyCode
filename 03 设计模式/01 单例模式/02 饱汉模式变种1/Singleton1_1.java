package com.liuyao.mode;


/**
 * Created By liuyao on 2017/12/6 17:07.
 * First, there are no bugs; then, it's simple and efficient.
 */

/**
 * 饱汉模式变种1，添加Synchronized修饰，则线程安全，坏处是并发性能差
 */
public class Singleton1_1 {
    public static Singleton1_1 singleton1_1=null;
    private Singleton1_1(){

    }
    public synchronized static Singleton1_1 getInstance(){
        if (singleton1_1==null){
            singleton1_1=new Singleton1_1();
        }
        return singleton1_1;
    }
}
