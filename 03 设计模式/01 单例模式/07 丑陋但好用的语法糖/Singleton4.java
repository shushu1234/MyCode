package com.liuyao.mode;

/**
 * Created By liuyao on 2017/12/6 18:18.
 * First, there are no bugs; then, it's simple and efficient.
 */

/**
 * 丑类但好用的语法糖，通过jsd反编译，得到的与饿汉模式相同，不过区别在于
 * 枚举的方式是公用的静态变量。
 */
public enum  Singleton4 {
    SINGLETON_4;
}
