package com.liuyao.dynamictemplate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created By liuyao on 2018/3/26 21:03.
 */
public class DynamicProxy <T> {
    public static <T> T newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler handler){
        if (true){
            new BeforeAdvice().exec();
        }
        return (T) Proxy.newProxyInstance(loader,interfaces,handler);
    }
}
