package com.liuyao.dynamictemplate;

import java.lang.reflect.InvocationHandler;

/**
 * Created By liuyao on 2018/3/26 21:08.
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        InvocationHandler handler = new MyInvocationHandler(subject);
        Subject proxy = DynamicProxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), handler);
        proxy.doSomething("Finish");
    }
}
