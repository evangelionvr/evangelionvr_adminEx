package com.liaofan.JavaBase.MultiThread;

/**
 * yield方法的使用(让步)
 * 暂停当前正在执行的线程对象，并执行其他线程。
 *
 * yield()应该做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其他线程获得运行机会。因此，使用yield()的目的是让相同优先级的线程之间能适当的轮转执行。但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。
 *
 * 结论：yield()从未导致线程转到等待/睡眠/阻塞状态。在大多数情况下，yield()将导致线程从运行状态转到可运行状态，但有可能没有效果。
 */
public class MultiThread_Core_Yield implements Runnable {
    /**
     * Created by zhu wei on 2017/6/2 0002.
     */

    // 定义一个全局变量
    private final String name;

    //构造方法_初始化对象属性
    //用于给线程名称赋值
    public MultiThread_Core_Yield(String name) {
        this.name = name;
    }

    /**
     * 暂停当前正在执行的线程对象，并执行其他线程。  *  * @param args  * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new MultiThread_Core_Yield("t1"));
        Thread t2 = new Thread(new MultiThread_Core_Yield("t2"));
        t1.start();
        t2.start();

    }

    @Override
    public void run() {
        //循环100次
        for (int i = 0; i < 100; i++) {
            //输出当前线程名称
            System.out.println(name + ":" + i);
            if ("t1".equals(name) && i == 5) {
                //如果当前线程名称为t1并且i=5，则让线程恢复至就绪状态(yield())
                System.out.println(name + ":" + i + ".....yield......");
                Thread.yield();
            }
        }
    }
}
