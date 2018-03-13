package com.liuyao.mode;


/**
 * Created By liuyao on 2017/12/6 17:07.
 * First, there are no bugs; then, it's simple and efficient.
 */

/**
 * 饱汉模式变种2 DCL 1.0 在变种1的基础上又套了一次check，Double Check Lock DCL
 * 似乎达到了懒加载+线程安全，但是由于指令重排序，有可能得到是半个对象
 */
public class Singleton1_2 {
    public static Singleton1_2 singleton1_2=null;
    private Singleton1_2(){

    }
    public synchronized static Singleton1_2 getInstance(){
        if (singleton1_2==null){
            synchronized (Singleton1_2.class){
                if (singleton1_2==null){
                    singleton1_2=new Singleton1_2();
                }
            }
        }
        return singleton1_2;
    }
}
