package com.liuyao.dynamictemplate;


/**
 * Created By liuyao on 2018/3/26 21:24.
 */
public class Client2 {
    public static void main(String[] args) {
        Subject subject=new RealSubject();
        Subject proxy=SubjectDynamicProxy.newProxyInstance(subject);
        proxy.doSomething("Finish");
    }
}
