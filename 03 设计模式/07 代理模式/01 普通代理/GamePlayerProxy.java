package com.liuyao.normal;

/**
 * Created By liuyao on 2018/3/26 17:36.
 */

/**
 * 代练者
 */
public class GamePlayerProxy implements IGamePlayer {
    private IGamePlayer gamePlayer=null;

//    通过构造函数传递要对谁进行代练
    public GamePlayerProxy(String name) {
        try {
            gamePlayer=new GamePlayer(this,name);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    }
}
