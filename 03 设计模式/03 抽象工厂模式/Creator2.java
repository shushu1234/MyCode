package com.liuyao;

/**
 * Created By liuyao on 2018/3/13 21:15.
 */
/**
 * 等级2的实现类
 */
public class Creator2 extends AbstractCreator {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductA createProductB() {
        return new ProductB2();
    }
}
