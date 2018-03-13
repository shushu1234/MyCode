package com.liuyao.mode;


/**
 * Created By liuyao on 2017/12/6 17:07.
 * First, there are no bugs; then, it's simple and efficient.
 */

/**
 * 饱汉模式变种2 DCL 2.0 在变种1_2上加上一个volatile
 */
public class Singleton1_3 {
    public static volatile Singleton1_3 singleton1_3=null;
    private Singleton1_3(){

    }
    public synchronized static Singleton1_3 getInstance(){
        if (singleton1_3==null){
            synchronized (Singleton1_3.class){
                if (singleton1_3==null){
                    singleton1_3=new Singleton1_3();
                }
            }
        }
        return singleton1_3;
    }
}
