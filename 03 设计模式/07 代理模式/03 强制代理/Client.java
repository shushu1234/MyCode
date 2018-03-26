package com.liuyao.force;

import java.util.Date;

/**
 * Created By liuyao on 2018/3/26 19:54.
 */
public class Client {
    public static void main(String[] args) throws Exception {
        IGamePlayer player=new GamePlayer("张三");
//        获得指定代理
        IGamePlayer proxy=player.getProxy();
        System.out.println(new Date());
        proxy.login("zhangsan","password");
        proxy.killBoss();
        proxy.upgrade();
    }
}
