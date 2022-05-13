#  Java多线程
## 一 .线程概述

> 几乎所有的操作系统都支持同时运行多个任务，一个任务通常就是 个程序，每个运行中的程序就
>
> 个进程 个程序运行时，内部可能包含了多个顺序执行流，每个顺序执行流就是一个线程



### 1.1 线程和进程

> ​	几乎所有的操作系统都支持进程的概念，所有运行中的任务通常对应一个进程 Process),程序进入内存运行时，即变成一个个进程是处于运行过程中的程序 并且具有特定的独立功能，进程是系统进行资源分配和调度的 个独立单位
>
> 一般而言 ，进程包含如下 个特征
>
> 1. 独立性: 进程是系统中独立存在的实体，它可以拥有自己独立的资源，每个进程都拥有自己私有的地址空间 在没有经过进程本身允许的情况下，一个用户进程不可以直接访问其他进程的地址空间
>
> 2. 动态性:进程与程序的区别在于，程序只是个静态的指令集合，而进程是一个正在系统中活动的指令集合.在进程中加入了时间的概念 进程具有自己的生命周期和各种不同的状态，这些概念在程序中都是不具备的
>
> 3. 并发性: 多个进程可以在单个处理器上井发执行， 多个进程之间不会互相影响
>
>    

**注意:**

并友性( concurrency )和并行性 paral1 el 是两个概念， 并行指在同一时刻，有多条指令在多个处理器同时执行;   并发指同一时刻只能有一条指令执行， 多个进程指令被快速轮换执行，使得在宏观具有多个进程同时执行的效果



**进程是线程的容器**



### 1.1A 并发和并行的概念

#### 并行

将真正同时运行的能力叫做并行

#### 并发

单核cpu下，线程实际还是申行执行的。操作系统中有一个组件叫做任务调度器，将cpu的时间片(windows下时间片最小约为15毫秒)分给不同的线程使用，只是由于cpu在线程间(时间片很短)的切换非常快，人类感觉是同时运行的。总结为一句话就是:微观串行，宏观并行，

将这种线程轮流使用CPU的做法称为并发   concurrent



#### 总结

引用Rob Pike的一段描述:
●并发(concurrent) 是同时间应对(dealing with)多件事情的能力
■并行(parallel) 是同- -时间动手做(doing) 多件事情的能力



#### 例子

● 家庭主妇做饭、打扫卫生、给孩子喂奶，她-一个人轮流交替做这多件事，这时就是并发

●家庭主妇雇了个保姆，她们一起这些事，这时既有并发，也有并行(这时会产生竞争，例如锅只有一口，
-个人用锅时，另一个人就得等待)   ------------------------------------------------------------------------既有并发也有并行
●雇了3个保姆，一个专做饭、一个专打扫卫生、一个专喂奶，互不干扰，这时是并行



### 1.1B 异步调用

从方法调用的角度来讲，如果
■需要等待结果返回，才能继续运行就是同步
■不需要等待结果返回，就能继续运行就是异步

注意:同步在多线程中还有另外一层意思，是让多个线程步调一致



#### 同步

```java
package com.liaofan.JavaAdvanced.JUC;

import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;

@Slf4j
public class Sync {
    public static void main(String[] args) {
        //读取mp3文件
        FileReader fr = null;
        try {
            System.out.println("开始读取mp3文件" + System.currentTimeMillis());
            fr = new FileReader("F:\\CloudMusic\\梁静茹 - 呵护.mp3");
            char[] buf = new char[1024];
            int len = 0;
            while ((len = fr.read(buf)) != -1) {
                //System.out.println(new String(buf, 0, len));
            }
            System.out.println("读取mp3文件结束" + System.currentTimeMillis());
        } catch (Exception e) {
            log.error("读取文件失败", e);
        }


        log.debug("end");
    }
}

```



#### 异步

```java
```



### 1.1C应用

#### 应用之异步调用

从方法调用的角度来讲，如果

- 需要等待结果返回，才能继续运行就是同步
- 不需要等待结果返回，就能继续运行就是异步

注意:同步在多线程中还有另外-一层意思，是让多个线程步调一致

##### 1)设计

多线程可以让方法执行变为异步的(即不要巴巴干等着)比如说读取磁盘文件时，假设读取操作花费了5秒
钟，如果没有线程调度机制，这5秒调用者什么都做不了，其代码都得暂停...

##### 2)结论

●	比如在项目中，视频文件需要转换格式等操作比较费时，这时开一个新线程处理视频转换，避免阻塞主线
程
■	tomcat的异步servlet也是类似的目的，让用户线程处理耗时较长的操作，避免阻塞tomcat的工作线程
●	ui程序中，开线程进行其他操作，避免阻塞ui线程

#### 应用之提高效率

![image-20220513000135892](C:\Users\evangelion\AppData\Roaming\Typora\typora-user-images\image-20220513000135892.png)

##### 2) 结论

![image-20220513000242104](C:\Users\evangelion\AppData\Roaming\Typora\typora-user-images\image-20220513000242104.png)







### 1.2 线程的创建和启动

#### 1.2.1 继承Thread类创建线程

步骤:

1. 定义Thread的子类,并重写run方法
2. 创建Thread子类的实例,即创建线程对象
3. 调用线程对象的start()方法来启动线程

```java
package com.liaofan.JavaBase.MultiThread;


/**
 * Java多线程编程核心知识
 *
 * @author liaofan
 * @date 2018年12月18日
 * 线程是进程的组成部分，进程是操作系统的组成部分，操作系统是计算机系统的组成部分。
 *
 */


//1.继承Thread类
public class MultiThread_Core_Extends extends Thread {

    private final String threadName;

    public MultiThread_Core_Extends(String threadName) {
        this.threadName = threadName;
    }

    public int i;

    /**
     * 2.重写run方法
     * 此方法就是代码需要完成的任务
     */
    @Override
    public void run() {
        for (i = 0; i < 100; i++) {
            System.out.println(threadName + "_" + "中的i=" + i + "，当前线程名称：" + Thread.currentThread().getName());
            //System.out.println(Thread.currentThread().getName());   //获取当前线程名称
        }
    }

    public static void main(String[] args) {
        /**
         * 3.创建线程对象
         */
        MultiThread_Core_Extends t1 = new MultiThread_Core_Extends("线程1");

        /**
         * 调用start方法,启动
         */
        t1.start();

        MultiThread_Core_Extends t2 = new MultiThread_Core_Extends("线程2");
        t2.setPriority(Thread.MAX_PRIORITY);   //设置优先级
        t2.setDaemon(true);                    //设置守护线程


        System.out.println(Thread.currentThread().getName());   //获取当前线程名称

        t2.start();
    }

}

```



#### 1.2.2 实现 Runnable 接口创建线程类

实现 Runnable 接口来创建并启动多线程的步骤如下。

1.定义 Runnable 接口的实现类 并重写该接口的 runO 方法，该 runO方法的方法体同样是该线程

的线程执行体

2. 创建 Runnable 实现类的实例，并以此实例作为 Threa target 来创建 Thread 对象，该 Thread

对象才是真正的线程对象 代码如下所示

```java
package com.liaofan.JavaBase.MultiThread;


/**
 * 实现Runnable接口创建线程类
 */

/**
 * 1.定义实现Runnable接口的实现类,并重写run方法
 */
public class MultiThread_Core_Implenet implements Runnable {

    private final String threadName;


    public MultiThread_Core_Implenet(String threadName) {
        this.threadName = threadName;
    }

    /**
     * 2.重写run方法,该方法是线程执行的执行体
     */
    @Override
    public void run() {
        System.out.println(threadName + ":" + "MultiThread_Core_Implenet run");
    }

    public static void main(String[] args) {
        //3.创建该Runable实现类的实例,Runnable 象仅仅作 Thread 对象的 target,Runnable 实现类里包含的 runO 方法仅作为线程执行休 而实际的线程对象依然是 Thread 实例，只是该 Thread 线程负责执行其 target runO 方法
        MultiThread_Core_Implenet multiThread_core_implenet1 = new MultiThread_Core_Implenet("线程1");   // 创建线程对象
        //4.并以此实例作为参数创建线程
        Thread thread1 = new Thread(multiThread_core_implenet1, "线程1_+V=-QM-2_Vg=.......09-=-");   // 创建线程

        MultiThread_Core_Implenet multiThread_core_implenet2 = new MultiThread_Core_Implenet("线程2");   // 创建线程对象
        Thread thread2 = new Thread(multiThread_core_implenet2, "线程2_+V=-QM-1_Vg...1");   // 创建线程


        thread2.setPriority(Thread.MAX_PRIORITY);   // 设置线程优先级

        System.out.println(thread1.getName());
        System.out.println(thread2.getName());

        //5.通过调用start()方法来启动线程
        thread1.start();
        thread2.start();
    }
}


```

采用 Runnable 接口的方式创建的多个线程可以共享线程类的实例变量。这是因为在这种方式下，实现 Runnable 接口创建的多线程 程序所 建的 Runn ble 对象只是线程的 target ，而多个线程可共享同 target ，所以多个线程可以共享同一个线程类(实际上应该是线程的 target 类)的实例变量。





#### 1.2.3 使用 Callable Future 创建线程

这种方式有点看不懂

```java
package com.liaofan.JavaBase.MultiThread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MultiThread_Core_CallableFuture {
    public static void main(String[] args) {
        //创建一个Callable对象
        MultiThread_Core_CallableFuture task = new MultiThread_Core_CallableFuture();
        //先使用lamda表达式创建一个Callable对象
        //使用FutureTask类来包装Callable对象
        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {
            int i = 0;
            for (; i < 100; i++) {
                i++;
                System.out.println(Thread.currentThread().getName() + "的循环变量的值:" + i);
            }

            return i;

        });

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "的循环变量的值:" + i);

            if (i == 20) {
                new Thread(futureTask, "有返回值的线程").start();
            }

            try {
                System.out.println("子线程的返回值:" + futureTask.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }

    }
}

```



#### 1.2.4 创建线程的三种方式的对比

通过继承 Thread 类或实现 Runnabl Callab 接口都可以实现多线程，不过实现 Runnable 接口与实Callabl 接口的方式基本相同，只是 Callable接口里定义的方法有返回值，可以声明抛出异常而己此.可以将实现 Runnable 接口和实现 Callable 接口归为 种方式 这种方式与继承 hread 方式之间的主要差别如下

###### 采用实现 Runnable、Callab 接口的方式创建多线程的优缺点:

优点：

​	1. 线程类只是实现了 Runnable 接口或 Callabl 接口、可以继承其他类

​    2. 在这种方式下，多个线程可以共享同 target 对象，所以非常适合多个相同线程来处理同一份资源的情况，从而可以将 CPU 、代码和数据分开 ，形成清晰的模型，较好地体现了面向对象的思想。

缺点：

​		劣势是，编程稍稍复杂，如果需要访问当前线程，则必须使用 Thread.currentThread()方法

###### 采用继承 Thread 类的方式创建多线程的优缺点

优点:

​	优势是，编写简单，如果需要访问当前线程，则无须使用 Thread.currentThread()方法，直接使用this 即可获得当前线程

缺点:

​	劣势是，因为线程类己经继承了 Threa ，所以不能再继承其他父类。



###### 鉴于上面分析，因此一般推荐采用实现 Runnable 接口、 Callable 接口的方式来创建多线程。

### 1.3 线程的生命周期

当线程被创建井启动以后 ，它 既不是 启动就进入了执行状态，也不是一直处于执行状态，在线程的生命周期中，它要经过

新建 (New) 、

就绪 (Runnable) 、

运行 (Running) 、

阻塞 (Blocked)、

 死亡 （Dead）
五种状态 尤其是当线程启动以后，它不可能 一直"霸占"着 PU 自运行，所以 PU 需要在多条线程之间切换，于是线程状态也会多次在运行、就绪之间切换。



#### 1.3.1 新建和就绪

当程序使用 new 关键宇创建了 一个线程之后，该线程就处于新建状态，此时它和其他的 Java 对象一样 ，仅仅由 Java 虚拟机为其分配 并初始化其成员变量的值, 此时的线程对象没有表现出任何线程的动态特征，程序也不会执行线程的线程执行体。

当线程对象调用了 star()方法之后，该线程 处于就绪状态， Java 虚拟机会为其创建方法调用技和程计数器，处于这个状态中 的线程并没有开始运 只是表示该线程可以运行了 至于该线程何时开始运行 取决于 NM 里线程调度器的调度。



![image-20220506171655563](C:\Users\evangelion\AppData\Roaming\Typora\typora-user-images\image-20220506171655563.png)

![image-20220506172940997](C:\Users\evangelion\AppData\Roaming\Typora\typora-user-images\image-20220506172940997.png)

#### 1.3.2 运行和阻塞状态

#### 1.3.3 线程死亡(示列代码为:MultiThread_Core_StartOrDead)

线程会以如下 种方式结束，结束后就处于死亡状态

1. run(), call()方法执行完成，线程正常结束
2. 线程抛出一个未捕获的Exception或者Error
3. 直接调用该线程的stop()方法来结束该线程(不推荐使用,通常不推荐使用)

![image-20220507114657695](C:\Users\evangelion\AppData\Roaming\Typora\typora-user-images\image-20220507114657695.png)

![image-20220507114717034](C:\Users\evangelion\AppData\Roaming\Typora\typora-user-images\image-20220507114717034.png)



```java
package com.liaofan.JavaBase.MultiThread;


/**
 * 线程的启动和终止
 */
public class MultiThread_Core_StartOrDead extends Thread {
    private int i;

    @Override
    public void run() {
        for (i = 0; i < 100; i++) {
            System.out.println(getName() + i);
        }
    }

    public static void main(String[] args) {
        MultiThread_Core_StartOrDead sd = new MultiThread_Core_StartOrDead();   // 创建线程对象
        for (int i = 0; i < 300; i++) {  // 循环创建300个线程
            System.out.println(Thread.currentThread().getName() + " " + i); // 输出当前线程名称

            if(i == 20) {  // 当i=20时，创建一个新的线程
                //启动线程
                sd.start(); // 启动线程
                System.out.println(sd.isAlive()); // 输出线程是否存活
            }

            //当线程处于新建和死亡两种状态时,isAlive()方法返回false
            //当i>20时,该线程已经启动,如果isALive()方法返回true,则说明线程还在运行,否则说明线程已经终止
            if(i > 20 && !sd.isAlive()) {  // 当i>20时，并且线程不存活时，创建一个新的线程
                sd.start(); // 启动线程
            }
        }
    }
}

```



### 1.4 控制线程

Java 的线程支持提供了 些便捷的工具方法 通过这些便捷的工具方法可以很好地控制线程的执行

#### 1.4.1 join线程

Thread 提供了让一个线程等待另一个个线程完成的方法一一join()方法 当在某个程序执行流中调用其他线程的 join() 方法时，调用线程将被阻塞 直到被 join()方法加入的join线程执行完为止.

​	Join方法通常由使用线程的程序调用,以将大问题划分成很多小问题,每个小问题分配一个线程,当所有的小问题都得到处理后,再调用主线程来进一步操作.

代码示列

```java
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
                //join(long millis, int nanos):等待被 Jom 的线程的时间最长为 milli 毫秒加 nanos 毫微秒。
                jt.join();  //等待被join的线程执行完毕
            }

            System.out.println(Thread.currentThread().getName() + "正在执行第" + i + "次");
        }
    }


}

```



join的三种重载方式:

​				 join()方法的重载方式一:等待被join的线程执行完毕后再执行
​                join(long mills):等待被join的线程执行完毕后再执行,如果被join的线程在指定时间内没有执行完毕,则不再等待
​                join(long millis, int nanos):等待被 Jom 的线程的时间最长为 milli 毫秒加 nanos 毫微秒。



![image-20220507144936481](C:\Users\evangelion\AppData\Roaming\Typora\typora-user-images\image-20220507144936481.png)



#### 1.4.2 后台线程(守护线程)

​			有一种线程是后台运行的,他的任务是为其他的线程提供服务,这样的线程为"后台线程",又称为守护线程. JVM就是典型的后台线程.

​			后台线程有个特征 如果所有的前台线程都死亡 后台线程会自动死亡。

​		调用 Thread 对象的 setDemone() 方法可将指定线程设置成后台线程。下面程序将执行线程设置后台线程可以看到当所有的前台线程死亡时，后台线程随之死亡, 当整个虚 机中只剩下后台线程时，程序就没有继续运行的必要了,所以虚拟机也就退出

```java
package com.liaofan.JavaBase.MultiThread;

/**
 * 守护线程
 * 守护线程是指在主线程结束后，守护线程会自动结束。
 */
public class MultiThread_Core_DaemonThread extends Thread {
    @Override
    public void run() {
        System.out.println("守护线程开始执行");
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "正在执行" + i + ",是否为守护线程:" + Thread.currentThread().isDaemon());
        }
    }

    public static void main(String[] args) {
        MultiThread_Core_DaemonThread daemonThread = new MultiThread_Core_DaemonThread();
        daemonThread.setDaemon(true);   //设置守护线程
        daemonThread.start();   //启动守护线程


        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "正在执行" + i);
        }

        //----程序执行到此处,前台线程就结束了----
        //----守护线程也结束了----
    }
}

```



![image-20220507154008351](C:\Users\evangelion\AppData\Roaming\Typora\typora-user-images\image-20220507154008351.png)

#### 1.4.3 线程睡眠

##### Sleep

如果要让当前的线程暂停一段时间,并进入到阻塞阶段,则可以调用Thread的静态方法sleep来实现

两种重载方式:

> static void sleep(long millis):让当前线程暂停millis毫秒,并进入阻塞状态,该方法受到系统计时器和线程调度器的精度和准确度的影响
>
> static void sleep(long millis, int nacos) : 当前正在执行的线程暂停 millis 毫秒加 nanos 毫微秒并进入阻塞状态,该方法受到系统计时器和线程调度器的精度与准确度的影响(不推荐使用,还是一样的原因,毫微秒准确性的问题).

当当前线程调用Sleep()方法进入阻塞状态以后,在其睡眠时间段内,该线程不会获得执行的机会,即使系统中没有其他可执行的线程,处于sleep()的线程也不会执行,因此,sleep()方法常用来暂停程序的执行

下面程序调用 sleep() 方法来暂停主线程的执行，因为该程序只有 个主线程，当主线程进入睡眠后，系统没有可执行的线程，所以可以看到程序在sleep() 方法处暂停

```java
package com.liaofan.JavaBase.MultiThread;

import java.util.Date;

/**
 * 多线程的基础：sleep()
 */
public class MultiThread_Core_Sleep {
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 100; i++) {
            System.out.println("调用当前时间：" + new Date());
            Thread.sleep(1000);   //线程休眠
        }
    }
}

```



##### yield方法

yield翻译过来:本身是让步的意思

Thread.yield()方法作用是：**暂停当前正在执行的线程对象，并执行其他线程	****(可能没有效果)**

yield()应该做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其他线程获得运行机会。因此，使用yield()的目的是让相同优先级的线程之间能适当的轮转执行。但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。

结论：yield()从未导致线程转到等待/睡眠/阻塞状态。在大多数情况下，yield()将导致线程从运行状态转到可运行状态，但有可能没有效果。
暂停当前正在执行的线程对象，并执行其他线程。

```java
package com.liaofan.JavaBase.MultiThread;

/**
 * yield方法的使用(翻译过来之后,本身的意思是:让步)
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
                System.out.println(name + ":" + i + "......yield.............");
                Thread.yield();
            }
        }
    }
}

```



























