package com.liuyao;

/**
 * Created By liuyao on 2018/3/13 21:14.
 */

/**
 * 等级1的实现类
 * 
 */
public class Creator1 extends AbstractCreator {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductA createProductB() {
        return new ProductB1();
    }
}
