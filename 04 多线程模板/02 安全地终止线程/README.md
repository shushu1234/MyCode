# 安全的终止线程 #
不建议使用`suspend()`暂停线程，在调用后，线程不会释放已经占有的资源(比如锁)，二是占有着资源进入睡眠状态，这样容易引发死锁问题，同样`stop()`在终结线程的时候不会保证资源正常释放，通常是没有给予线程完成资源释放工作的机会，所以`suspend(),stop(),resume()`不建议使用

而应该采用中断或者boolean变量来终止线程，线程循环检查中断状态标识或者boolean变量的值