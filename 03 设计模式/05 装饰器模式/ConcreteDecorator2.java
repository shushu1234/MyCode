package com.liuyao;

/**
 * Created By liuyao on 2018/3/24 20:21.
 */
public class ConcreteDecorator2 extends Decorator {
    //定义被修饰者
    public ConcreteDecorator2(Component _component) {
        super(_component);
    }

    //定义自己的修饰方法
    private void method1(){
        System.out.println("method2 修饰");
    }

    //重写父类的Operation方法
    public void operate(){
        this.method1();
        super.operate();
    }
}
