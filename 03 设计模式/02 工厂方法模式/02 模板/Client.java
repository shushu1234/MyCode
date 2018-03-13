package com.liuyao.product;

/**
 * Created By liuyao on 2018/3/7 20:58.
 */


/**
 * 场景类
 */
public class Client {
    public static void main(String[] args) {
        Creator creator=new ConcreteCreator();
        //传入类，生成相应的类出来
        Product product=creator.createProduct(ConcreteProduct1.class);

        /**
         * 继续业务逻辑处理
         */
    }
}
