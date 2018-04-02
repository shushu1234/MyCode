# 归并排序 #
优点：任意长度为N的数组排序时间和NlogN成正比
缺点：它需要的额外空间和N成正比

在使用归并排序的时候，在处理小规模的子数组(比如长度小于15)一般可以将归并排序的运行时间缩短10%~15%


	/**
	 * 归并排序
	 */
	
	// 原地归并抽象方法
	public static void merge(Comparable[] a,int lo,int mid,int hi){
	    // 将a[lo...mid]和a[mid+1...hi]归并
	    int i=lo,j=mid+1;
	    Comparable[] aux;
	    // 将a[lo...hi]复制到aux[lo...hi]
	    for (int k = lo; k <=hi; k++) {
	        aux[k]=a[k];
	    }   
	    // 归并回a[lo...hi]
	    for (int k = lo; k <= hi; k++) {
	        if (i>mid) a[k]=aux[j++]; //左半边取尽，取右半边元素
	        else if(j > hi) a[k]=aux[i++]; //右半边取尽，取左半边元素
	        else if(less(aux[j],aux[i])) a[k]=aux[j++]; //右边小于左边，取左边元素
	        else a[k]=aux[i++]; //左边小于右边，取左边元素
	    }
	}
	
	// 自顶向下的归并排序
	public class Merge{
	    private static Comparable[] aux;
	    public static void sort(Comparable[] a){
	        aux=new Comparable[a.length];
	        sort(a,0,a.length-1);
	    }
	    private static void sort(Comparable[] a,int lo,int hi){
	        if(hi <= lo)return;
	        int mid=lo+(hi-lo)/2;
	        sort(a,lo,mid);  //将左半边排序
	        sort(a,mid+1,hi);  //将右半边排序
	        merge(a, lo, mid, hi);  //归并结果
	    }
	}
	
	// 自底向上的归并排序
	public class MergeBU{
	    private static Comparable[] aux;
	    public static void sort(Comparable[] a){
	        int N=a.length;
	        aux=new Comparable[a.length];
	        for (int sz = q; sz < N; sz+=sz) {  //sz为子数组大小
	            for (int lo = 0; lo < N-sz; lo+=sz+sz) {  //lo子数组索引
	                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1,N-1));
	            }
	        }
	    }
	}