package com.liuyao.people;

/**
 * Created By liuyao on 2017/12/7 19:31.
 * First, there are no bugs; then, it's simple and efficient.
 */
public class NvWa {
    public static void main(String[] args) {
        AbstractHumanFactory yinYangLu=new HumanFactory();
        Human blackMan=yinYangLu.createHuman(BlackHuman.class);
        blackMan.getColor();
        blackMan.talk();

        Human whiteMan=yinYangLu.createHuman(WhiteHuman.class);
        whiteMan.getColor();
        whiteMan.talk();

        Human yellowMan=yinYangLu.createHuman(YellowHuman.class);
        yellowMan.getColor();
        yellowMan.talk();
    }
}
