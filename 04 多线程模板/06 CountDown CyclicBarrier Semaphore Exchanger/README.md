# CountDownLatch #
 
> CountDownLatch允许一个或多个线程等待其他线程完成操作 


### 构造方法 

`CountDownLatch c=new CountDownLatch(N);` 初始化为N个

### countDown方法： ###
调用countDown方法后N就会减一，一个线程的countDown方法happen-before另个线程的的await方法
### await方法 ###
使线程阻塞等待，N减为0时，才可以继续执行

# CyclicBarrier #


> 字面意思是可循环使用(cyclic)的屏障(barrier)

让一组线程到达一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续运行

### 构造方法 ###
`CyclicBarrier(int parties);`参数表示屏障拦截的线程数量，每个线程调用await方法告诉CyclicBarrier我已到达了屏障，然后当前线程被阻塞

 线程到达屏障时，先执行A  `static CyclicBarrier c=new CyclicBarrier(2,new A());`

CyclicBarrier适用于多线程计算数据，最后合并计算结果的场景。

# CountDownLatch和CyclicBarrier区别 #
CountDownLatch的计数器只能使用一次，而CyclicBarrier的计数器可以使用reset()方法重置，所以CyclicBarrier能处理更为复杂的业务场景。
例如：计算错误的时候，可以重置计数器，并让线程重新计算一次。

# Semaphore #
> Semaphore（信号量）是用来控制同时访问特定资源的线程数量，它通过协调各个线程，以保证合理的使用公共资源。

### 应用场景 ###
Semaphore可以用于流量控制，特别是公共资源有限的应用场景，比如数据库连接

acquire获取许可证

release释放许可证

# Exchanger #
> Exchanger(交换者)是一个用于线程间协作的工具类。Exchanger用于线程之间的数据交换，它提供一个同步点，在这个同步点，两个线程可以交换彼此的数据。
> 这两个线程通过exchange方法交换数据，如果第一个线程先执行exchange方法，它会一直等待第二个线程也执行exchange方法，当两个线程都到达同步点时，这两个线程就可以交换数据，将本线程生产出来的数据传递给对方。

