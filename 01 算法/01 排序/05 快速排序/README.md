# 快速排序 #
快速排序适用于各种不同的输入数据且在一般应用中比其他排序算法快得多

优点：它是原地排序（只需要一个很小的辅助栈），且将长度为N的数组排序所需的时间和NlgN成正比
缺点：非常脆弱，在实现时尽量避免低劣的性能

	// 快速排序
	public class Quick{
	    public static void sort(Comparable[] a){
	        sort(a,0,a.length-1);
	    }
	    public static void sort(Comparable[] a,int lo,int hi){
	        if(hi <= lo)return;
	        int j=partition(a,lo,hi);
	        sort(a,lo,j-1);
	        sort(a,j+1,hi);
	    }
	    // 快速排序的切分
	    private static int partition(Comparable[] a,int lo,int hi){
	        // 将数组切分为a[lo...i-1],a[i],a[i+1...hi]
	        int i=lo,j=h+1;  //左右扫描指针
	        Comparable v=a[lo]; //切分元素
	        while(true){
	            // 扫描左右，检查扫描是否结束并交换元素
	            while(less(a[++i],v)) if(i==hi)break;
	            while(less(v,a[--j])) if(j==lo)break;
	            if(i>=j) break;  
	            exch(a,i,j);
	        }
	        exch(a,lo,j);  //将v=a[j]放入正确的位置
	        return j;   //a[lo...j-1] <= a[j] <= a[j+1...hi]
	    }
	}

**潜在缺点:**在切分不平衡的时候，这个程序可能极为低效。例如第一次从最小的元素切分，第二次，从第二小元素切分，如此这般，每次只会移除一个元素。

#### 算法改进 ####
基于以下两点：
1. 对于小数组，快速排序比插入排序慢
2. 因为递归，快速排序的sort()方法在小数组中也会调用自己

**因此，在排序小数组时应该切换到插入排序**
即：把sort中的语句

	if(hi <= lo) return;
替换成：

	if(hi <= lo+M){
		Insertion.sort(a,lo,hi);
		return;
	}
M一般在5~15之间比较满意

## 三路切分 ##

![](https://i.imgur.com/htDIGwe.png)

	public class Quick3way{
	    private static void sort(Comparable[] a,int lo,int hi){
	        if(hi <= lo) return;
	        int lt=lo,i=lo+1,gt=hi;
	        Comparable v=a[lo];
	        while(i <= gt){
	            int cmp=a[i].compareTo(v);
	            if(cmp < 0) exch(a,lt++,i++);
	            else if(cmp > 0) exch(a,i,gt--);
	            else i++;
	        }
	        sort(a,lo,lt-1);
	        sort(a,gt+1,hix);
	    }
	}

