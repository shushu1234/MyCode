package com.liuyao.tempate;

/**
 * Created By liuyao on 2018/3/15 17:40.
 */
public class ConcreteClass1 extends AbstractClass {
    //实现基本方法
    @Override
    protected void doSomething() {
        System.out.println(this.toString());
    }

    @Override
    protected void doAnything() {

    }
}
