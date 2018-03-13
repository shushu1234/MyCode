package com.liuyao.exten;

import com.liuyao.people.BlackHuman;
import com.liuyao.people.Human;
import com.liuyao.people.WhiteHuman;

/**
 * Created By liuyao on 2018/3/13 20:25.
 */
public class NvWa {
    public static void main(String[] args) {
        Human whiteHuman=HumanFactory.createHuman(WhiteHuman.class);
        whiteHuman.talk();

        BlackHuman blackHuman=HumanFactory.createHuman(BlackHuman.class);
        blackHuman.getColor();
    }
}
