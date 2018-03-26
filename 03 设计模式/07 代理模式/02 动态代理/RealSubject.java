package com.liuyao.dynamictemplate;

/**
 * Created By liuyao on 2018/3/26 21:00.
 */

/**
 * 真实主题
 */
public class RealSubject implements Subject {
//    业务操作
    @Override
    public void doSomething(String str) {
        System.out.println("do Something!---->"+str);
    }
}
