package com.liuyao.people;

/**
 * Created By liuyao on 2017/12/7 19:28.
 * First, there are no bugs; then, it's simple and efficient.
 */
public class HumanFactory extends AbstractHumanFactory {
    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        Human human=null;
        try {
            human=(T)Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            System.out.println("人种创建错误");
        }

        return (T)human;
    }
}
