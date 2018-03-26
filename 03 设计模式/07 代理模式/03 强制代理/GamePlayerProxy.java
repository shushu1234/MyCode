package com.liuyao.force;

/**
 * Created By liuyao on 2018/3/26 17:36.
 */

/**
 * 代练者
 */
public class GamePlayerProxy implements IGamePlayer ,IProxy{
    private IGamePlayer gamePlayer=null;

//    通过构造函数传递要对谁进行代练
    public GamePlayerProxy(IGamePlayer gamePlayer) {
        this.gamePlayer=gamePlayer;
    }

    @Override
    public void login(String username, String password) {
        this.gamePlayer.login(username,password);
    }

    @Override
    public void killBoss() {
        this.gamePlayer.killBoss();
    }

    @Override
    public void upgrade() {
        this.gamePlayer.upgrade();
        this.count();
    }

    @Override
    public IGamePlayer getProxy() {
        return this;
    }

    @Override
    public void count() {
        System.out.println("Upgrade Cost 150");
    }
}
