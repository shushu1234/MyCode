# 优先队列 #
当一棵二叉树的每个节点都大于等于他的两个子节点时，他被称为**堆有序**

## 堆的算法 ##
用长度为N+1的私有数组pq[]来表示一个大小为N的堆，我们不会用pqp[0]，堆元素放在pq[1]至pq[N]中

当某个节点的优先级上升（或是在堆底加入一个新的元素时）我们需要由下到上的恢复对的顺序，叫做**上浮（swim）**，方法：交换他和他的父节点来修复堆

	//上浮
	private void swim(int k){
	    // 如果父节点(k/2)值比当前节点小，交换
	    while(k > 1 && less(k/2,k)){
	        exch(k/2,k);
	        k=k/2;
	    }
	}

当某个节点的优先级下降（或是将根节点替换为一个较小元素的时候）我们需要由上至下恢复对的顺序，叫做**下沉（sink）**，方法：通过将他和它的两个子节点中的较大者交换来修复堆

	// 下沉
	private void sink(int k){
	    while(2*k <= N){
	        int j=2*k;
	        // 找到两个炸鸡店中较大的那个子节点
	        if(j<N && less(j,j+1)) j++;
	        // 如果当前节点不比两个子节点小，则停止
	        if(!less(k,j))break;
	        // 交换父节点与子节点
	        exch(k,j);
	        // 更新k的值
	        k=j;
	    }
	}

## 基于堆的优先队列 ##

	// 基于堆有优先队列
	public class MaxPQ<Key extends Comparable<Key>>{
	    private Key[] pq;
	    private int N=0;
	    public MaxPQ(int maxN){
	        pq=(Key[])new Comparable[maxN+1];
	    }
	    public boolean isEmpty(){
	        return N==0;
	    }
	    public int size(){
	        return N;
	    }
	    public void insert(Key v){
	        pq[++N]=v;
	        swim(N);
	    }
	    public Key delMax(){
	        // 取得最大值
	        Key max=pq[1];
	        // 将第一个元素和最后一个元素（最小的交换）
	        exch(1,N--);
	        // 将对吼一个元素置为null，让系统回收
	        pq[N+1]=null;
	        // 将交换到第一个位置的元素下沉，重新恢复
	        sink(1);
	        return max;
	    }
	
	}

**堆排序**
将所有元素插入一个查找最小元素的优先队列，然后再重复调用删除最小元素的操作来将他们按顺序删去，分为两个阶段：
1. 在堆的构造过程中，我们将原始数组重新组织安排进一个堆中
2. 然后下层排序，我们从堆中按递减顺序取出所有元素并得到排序结果
