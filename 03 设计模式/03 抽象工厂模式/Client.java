package com.liuyao;

/**
 * Created By liuyao on 2018/3/13 21:16.
 */

/**
 * 场景类
 */
public class Client {
    public static void main(String[] args) {
        AbstractCreator creator1=new Creator1();
        AbstractCreator creator2=new Creator2();
        AbstractProductA a1=creator1.createProductA();
        a1.doSomething();
        AbstractProductA b1=creator1.createProductB();
        b1.doSomething();
        AbstractProductA a2=creator2.createProductA();
        a2.doSomething();
        AbstractProductA b2=creator2.createProductB();
        b2.doSomething();
    }
}
