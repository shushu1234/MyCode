package com.liuyao;

/**
 * Created By liuyao on 2018/3/24 20:24.
 */

/**
 * 场景类
 */
public class Client {
    public static void main(String[] args) {
        Component component=new ConcreteComponent();
        //第一次修饰
        component=new ConcreteDecorator1(component);
//        第二次修饰
        component=new ConcreteDecorator2(component);
//        修饰后台运行
        component.operate();
    }
}
