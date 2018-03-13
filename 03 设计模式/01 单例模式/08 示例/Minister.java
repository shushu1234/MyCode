package com.liuyao.exten;

/**
 * Created By liuyao on 2017/12/6 16:45.
 * First, there are no bugs; then, it's simple and efficient.
 */
public class Minister {
    public static void main(String[] args) {
//        定义5个大臣
        int ministerNum=5;
        for (int i = 0; i < ministerNum; i++) {
//            随机访问那个皇帝
            Emperor emperor=Emperor.getInstance();
            System.out.print("第"+(i+1)+"个大臣参拜的是: ");
            emperor.say();
        }
    }
}
