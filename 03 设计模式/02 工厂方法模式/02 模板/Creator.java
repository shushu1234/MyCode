package com.liuyao.product;

/**
 * Created By liuyao on 2018/3/7 20:54.
 */

/**
 * 抽象工厂类
 */
public abstract class Creator {
    /**
     * 创建一个产品对象，其输入参数类型可以自己设置
     * 通常为String Enum Class等，当然也可以为空
     * @param c
     * @param <T>
     * @return
     */
    public abstract <T extends Product> T createProduct(Class<T> c);
}
