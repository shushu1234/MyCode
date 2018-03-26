package com.liuyao.dynamictemplate;

import java.lang.reflect.InvocationHandler;

/**
 * Created By liuyao on 2018/3/26 21:21.
 */
public class SubjectDynamicProxy extends DynamicProxy{
    public static <T> T newProxyInstance(Subject subject){
//        获得ClassLoader
        ClassLoader classLoader=subject.getClass().getClassLoader();
//        获得接口数组
        Class<?>[] classes=subject.getClass().getInterfaces();
//        获得Handler
        InvocationHandler handler=new MyInvocationHandler(subject);
        return newProxyInstance(classLoader,classes,handler);
    }
}
