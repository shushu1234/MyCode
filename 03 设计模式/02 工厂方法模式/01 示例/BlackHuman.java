package com.liuyao.people;

/**
 * Created By liuyao on 2017/12/7 19:25.
 * First, there are no bugs; then, it's simple and efficient.
 */
public class BlackHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("Black");
    }

    @Override
    public void talk() {
        System.out.println("bluckman");
    }
}
