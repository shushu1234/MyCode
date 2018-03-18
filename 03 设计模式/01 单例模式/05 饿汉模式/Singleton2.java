package com.liuyao.mode;


/**
 * Created By liuyao on 2017/12/6 17:07.
 * First, there are no bugs; then, it's simple and efficient.
 */

/**
 * 饿汉模式,好处是得益于类的加载机制天生线程安全，使用时没有延迟，坏处是可能造成资源浪费。
 * 单线程下，饿汉和包含性能差别不大，在多线程下，由于饱汉需要加锁和解锁，饿汉效果反而更好
 */
public class Singleton2 {
    public static final Singleton2 singleton2=new Singleton2();
    private Singleton2(){

    }
    public static Singleton2 getInstance(){
        return singleton2;
    }
}
