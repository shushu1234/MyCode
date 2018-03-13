package com.liuyao.lazy;

import com.liuyao.product.ConcreteProduct1;
import com.liuyao.product.ConcreteProduct2;
import com.liuyao.product.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By liuyao on 2018/3/13 20:37.
 */
public class ProductFactory {
    private static final Map<String,Product> prMap=new HashMap<>();
    public static synchronized Product createProduct(String type){
        Product product=null;
        if (prMap.containsKey(type)){
            product=prMap.get(type);
        }else {
            if (type.equals("Product1")){
                product=new ConcreteProduct1();
            }else {
                product=new ConcreteProduct2();
            }
//            把对象放到缓存容器中，对象被消费完后，保持初始状态，等待再次被利用
            prMap.put(type,product);
        }
        return product;
    }
}
