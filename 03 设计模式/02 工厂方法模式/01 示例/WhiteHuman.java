package com.liuyao.people;

/**
 * Created By liuyao on 2017/12/7 19:26.
 * First, there are no bugs; then, it's simple and efficient.
 */
public class WhiteHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("White");
    }

    @Override
    public void talk() {
        System.out.println("whiteman");
    }
}
