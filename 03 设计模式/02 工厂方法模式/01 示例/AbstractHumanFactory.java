package com.liuyao.people;

/**
 * Created By liuyao on 2017/12/7 19:27.
 */


public abstract class AbstractHumanFactory {

    /**
     * 采用了泛型，通过定义泛型对createHuman的输入参数产生两层限制
     * 1. 必须是Class类型
     * 2. 必须是Human的实现类
     * @param c
     * @param <T>  表示只要实现了Human接口的类都可以作为参数，起源于jdk1.5 它减少了对象之间的转换，约束其输入参数类型
     * @return
     */

    public abstract <T extends Human> T createHuman(Class<T> c);
}
