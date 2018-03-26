package com.liuyao.dynamictemplate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created By liuyao on 2018/3/26 21:01.
 */
public class MyInvocationHandler implements InvocationHandler {
//    被代理的对象
    private Object target=null;

//    通过构造函数传递一个对象
    public MyInvocationHandler(Object target) {
        this.target = target;
    }
//    代理方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this.target,args);
    }
}
