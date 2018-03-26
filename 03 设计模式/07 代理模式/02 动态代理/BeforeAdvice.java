package com.liuyao.dynamictemplate;

/**
 * Created By liuyao on 2018/3/26 21:07.
 */
public class BeforeAdvice implements IAdvice {
    @Override
    public void exec() {
        System.out.println("我是前置通知，我被执行了");
    }
}
