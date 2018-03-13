package com.liuyao.mode;


/**
 * Created By liuyao on 2017/12/6 17:07.
 * First, there are no bugs; then, it's simple and efficient.
 */

/**
 * Holder模式，希望利用饿汉模式中静态变量的方便和线程安全，又希望通过懒加载规避资源浪费，
 * Holder模式满足了这两点需求，核心仍是静态变量，足够方便和安全，通过静态的Holder类持有真正实例
 * 间接满足了懒加载。
 */
public class Singleton3 {
//    通过静态的内部类持有真正实例
    private static class SingletonHolder{
        private static final Singleton3 singleton3=new Singleton3();
        private SingletonHolder(){

        }
    }
    private Singleton3(){

    }


    public synchronized static Singleton3 getInstance(){
//        通过Holder来懒加载
        return SingletonHolder.singleton3;
    }

}
