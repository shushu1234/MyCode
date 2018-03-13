package com.liuyao.exten;

import com.liuyao.people.Human;

/**
 * Created By liuyao on 2018/3/13 20:23.
 */
public class HumanFactory {
    public static <T extends Human> T createHuman(Class<T> c){
        Human human=null;
        try {
            human=(Human)Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) human;
    }
}
