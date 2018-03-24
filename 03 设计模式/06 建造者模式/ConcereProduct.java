/**
 * Created By liuyao on 2018/3/24 20:52.
 */
/**
 * 具体建造者
 */
public class ConcereProduct extends Builder {
    private Product product=new Product();
//    设置产品零件
    @Override
    public void setPart() {
//        产品类内的逻辑处理
        System.out.println("setPart");
    }

//    组件一个产品
    @Override
    public Product buildProduct() {
        return product;
    }
}
