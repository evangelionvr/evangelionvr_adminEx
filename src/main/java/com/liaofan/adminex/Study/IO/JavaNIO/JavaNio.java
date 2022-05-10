package com.liaofan.adminex.Study.IO.JavaNIO;


/**
 * NIO是一种基于通道和缓冲区的I/O方式，
 * 它可以使用Native函数库直接分配堆外内存（区别于JVM的运行时数据区），
 * 然后通过一个存储在java堆里面的DirectByteBuffer对象作为这块内存的直接引用进行操作。
 * 这样能在一些场景显著提高性能，因为避免了在Java堆和Native堆中来回复制数据。
 *
 */
public class JavaNio {
    public static void main(String[] args) {

    }


}
