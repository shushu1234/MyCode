package com.liuyao.mode;


/**
 * Created By liuyao on 2017/12/6 17:07.
 * First, there are no bugs; then, it's simple and efficient.
 */

/**
 * 饱汉模式，核心是懒加载，好处是启动快，节约资源，一直到实例被第一次访问的时候，才初始化。
 * 坏处主要是线程不安全。if存在竟态条件
 */
public class Singleton1 {
    public static Singleton1 singleton1=null;
    private Singleton1(){

    }
    public static Singleton1 getInstance(){
        //if存在竟态条件，当两个线程同时执行道这里的时候就会出错
        if (singleton1==null){
            singleton1=new Singleton1();
        }
        return singleton1;
    }
}
