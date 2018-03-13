package com.liuyao.mode;


/**
 * Created By liuyao on 2017/12/6 17:07.
 * First, there are no bugs; then, it's simple and efficient.
 */

/**
 * 饿汉模式,好处是线程安全，使用时没有延迟，坏处是可能造成资源浪费。
 */
public class Singleton2 {
    public static final Singleton2 singleton2=new Singleton2();
    private Singleton2(){

    }
    public static Singleton2 getInstance(){
        return singleton2;
    }
}
