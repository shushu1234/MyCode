/**
 * Created By liuyao on 2018/3/24 20:53.
 */

/**
 * 导演类
 */
public class Director {
    private Builder builder=new ConcereProduct();
//    构建不同的产品
    public Product getAProduct(){
        builder.setPart();
//        设置不同的产品零件，产生不同的产品
        return builder.buildProduct();
    }
}
