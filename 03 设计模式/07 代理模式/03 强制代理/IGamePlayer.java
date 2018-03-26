package com.liuyao.force;

/**
 * Created By liuyao on 2018/3/26 17:30.
 */
public interface IGamePlayer {
    public void login(String username, String password);

    public void killBoss();

    public void upgrade();

    public IGamePlayer getProxy();
}
