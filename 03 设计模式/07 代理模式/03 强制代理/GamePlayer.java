package com.liuyao.force;

/**
 * Created By liuyao on 2018/3/26 17:32.
 */
public class GamePlayer implements IGamePlayer {
    private String name="";
    private IGamePlayer proxy=null;
    public GamePlayer(String name) throws Exception {

            this.name=name;

    }

    @Override
    public void login(String username, String password) {
        if (this.isProxy()){

            System.out.println("username:"+username+"password:"+password);
        }else {
            System.out.println("Please use proxy");
        }
    }

    @Override
    public void killBoss() {
        if (this.isProxy()){

            System.out.println("kill boss");
        }else {
            System.out.println("Please use proxy");
        }
    }

    @Override
    public void upgrade() {
        if (this.isProxy()){

            System.out.println("Upgrade one");
        }else {
            System.out.println("Please use proxy");
        }
    }

//    找到自己的代理
    @Override
    public IGamePlayer getProxy() {
        this.proxy=new GamePlayerProxy(this);
        return this.proxy;
    }

    private boolean isProxy(){
        if (this.proxy==null){
            return false;
        }else {
            return true;
        }
    }
}
