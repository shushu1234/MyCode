package com.liuyao;

/**
 * Created By liuyao on 2018/3/13 21:12.
 */

/**
 * 抽象工厂类
 * 有N个产品家族，在抽象工厂类中就应该由N个创建方法
 */
public abstract class AbstractCreator {
    public abstract AbstractProductA createProductA();

    public abstract AbstractProductA createProductB();
}
