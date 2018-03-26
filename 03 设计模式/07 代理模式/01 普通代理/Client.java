package com.liuyao.normal;

import java.util.Date;

/**
 * Created By liuyao on 2018/3/26 19:54.
 */
public class Client {
    public static void main(String[] args) {
        IGamePlayer proxy=new GamePlayerProxy("张三");
        System.out.println(new Date());
        proxy.login("zhangsan","password");
        proxy.killBoss();
        proxy.upgrade();
    }
}
