package com.liuyao;

/**
 * Created By liuyao on 2018/3/24 20:16.
 */
public class ConcreteComponent extends Component {
//    具体实现
    @Override
    public void operate() {
        System.out.println("do something");
    }
}
