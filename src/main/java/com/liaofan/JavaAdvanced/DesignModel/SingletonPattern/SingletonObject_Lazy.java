package com.liaofan.JavaAdvanced.DesignModel.SingletonPattern;

/**
 * 单例模式-懒汉式
 * 是否 Lazy 初始化：是
 *
 * 是否多线程安全：是
 *
 * 实现难度：易
 * 这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
 * getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）。
 */
public class SingletonObject_Lazy {
    private static SingletonObject_Lazy instance;

    /**
     * 构造方法
     */
    private SingletonObject_Lazy() {}

    public static synchronized SingletonObject_Lazy getInstance() {
        if(instance == null) {
            instance = new SingletonObject_Lazy();
        }

        return instance;
    }

    /**
     * 显示消息
     */
    public void showMessage() {
        System.out.println("hello word, Lazy");
    }
}
