package com.liuyao.normal;

/**
 * Created By liuyao on 2018/3/26 17:32.
 */
public class GamePlayer implements IGamePlayer {
    private String name="";

    public GamePlayer(IGamePlayer gamePlayer,String name) throws Exception {
        if (gamePlayer==null){
            throw new Exception("我不能创建角色");
        }else {
            this.name=name;
        }
    }

    @Override
    public void login(String username, String password) {
        System.out.println("username:"+username+"password:"+password);
    }

    @Override
    public void killBoss() {
        System.out.println("kill boss");
    }

    @Override
    public void upgrade() {
        System.out.println("Upgrade one");
    }
}
