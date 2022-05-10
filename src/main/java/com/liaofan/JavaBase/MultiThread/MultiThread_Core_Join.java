package com.liaofan.JavaBase.MultiThread;


/**
 * Java多线程：
 * join()方法示列
 */
public class MultiThread_Core_Join extends Thread {

    public MultiThread_Core_Join(String joinName) {
        super(joinName);
    }


    //重写run方法
    @Override
    public void run() {
        //输出当前线程名称
        for(int i = 0; i < 100; i++) {
            System.out.println(getName() + "正在执行第" + i + "次");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new MultiThread_Core_Join("新线程").start();   //启动线程,主线程启动了名为“新线程”的线程,该线程将会和主线程并发执行

        for (int i = 0; i < 100; i++) {
            if(i == 20) {    //当主线程执行到第20次循环时,

                MultiThread_Core_Join jt = new MultiThread_Core_Join("被Join的线程");    //创建被join的线程

                jt.start();   //启动被join的线程,该线程不会和主线程并发执行, main线程会等待该线程执行完毕后再执行,在名为join的线程执行时,实际上只有两个子线程在执行,主线程处于阻塞状态



                //join方法有三种重载的方式
                //join()方法的重载方式一:等待被join的线程执行完毕后再执行
                //join(long mills):等待被join的线程执行完毕后再执行,如果被join的线程在指定时间内没有执行完毕,则不再等待
                //join(long millis, int nanos):等待被 Join 的线程的时间最长为 milli 毫秒加 nanos 毫微秒。
                jt.join();  //等待被join的线程执行完毕
            }

            System.out.println(Thread.currentThread().getName() + "正在执行第" + i + "次");
        }
    }


}
