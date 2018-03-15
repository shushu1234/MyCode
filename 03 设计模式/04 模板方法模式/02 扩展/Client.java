package com.liuyao.extern;

/**
 * Created By liuyao on 2018/3/15 17:41.
 */
public class Client {
    public static void main(String[] args) {
        AbstractClass abstractClass1=new ConcreteClass1();
        AbstractClass abstractClass2=new ConcreteClass2();
        //调用模板方法
        abstractClass1.templateMethod();
        System.out.println("===========================");
        abstractClass2.templateMethod();
    }
}
