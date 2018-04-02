# 选择排序 #
1. 运行时间和输入无关，选择排序不善于利用数组的初始状态，故一个有序的数组或者主键全部相等的数组和一个元素随机排列的数组所用的时间是一样的。
2. 数据移动是最少的N次交换，每次交换两个元素的值，故选择排序用类N次交换，交换次数和大小和数组的大小是线性关系。
3. 每趟都可以让一个元素回到最后正确的位置

		//选择排序
		public class Selection{
		    // 将a按照升序排列
		    public void sort(Comparable[] a){
		        // 数组长度
		        int N=a.length;
		        for (int i = 0; i < N; i++) {
		            // 将a[i]和a[i...N]之间最小的交换
		            int min=i; //min为最小的索引
		            for (int j = i+1; j < N; j++) {
		                if(less(a[j],a[i])){
		                    min=j;
		                }
		            }
		            exch(a,i,min);
		        }
		    }
		}

