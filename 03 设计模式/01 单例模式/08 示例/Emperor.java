package com.liuyao.exten;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created By liuyao on 2017/12/6 16:39.
 * First, there are no bugs; then, it's simple and efficient.
 */
public class Emperor {
//    定义最多能产生的实例数量
    private static int  maxNumOfEmperor=2;
//    每个皇帝都有一个名字,使用ArrayList来容纳,每个对象的私有属性
    private static ArrayList<String> nameList=new ArrayList<String>();
//    定义一个列表，容纳所有的皇帝实例
    private static ArrayList<Emperor> emperorList=new ArrayList<Emperor>();
//    当前皇帝的序列号
    private static int countNumOfEmperor=0;

//    产生所有的对象
    static {
        for (int i = 0; i < maxNumOfEmperor; i++) {
            emperorList.add(new Emperor("皇"+(i+1)+"帝"));

        }
    }
    private Emperor(){

    }

//    传入一个皇帝名称,建立一个皇帝对象
    private Emperor(String name){
        nameList.add(name);
    }

//    随机获得一个皇帝对象
    public static Emperor getInstance(){
        Random random=new Random();
        countNumOfEmperor=random.nextInt(maxNumOfEmperor);
        return emperorList.get(countNumOfEmperor);
    }

//    皇帝发话了
    public static void say(){
        System.out.println(nameList.get(countNumOfEmperor));
    }
}
