package com.liaofan.JavaAdvanced.DesignModel.SingletonPattern;

/**
 * @author 廖钒
 * @ClassName Singleton
 * @description: TODO
 * @datetime 2022年 06月 10日 16:28
 * @version: 1.0
 */
public class SingletonObject {
    //创建 SingleObject 的一个对象
    private static SingletonObject singletonObject = new SingletonObject();

    //让构造函数为 private，这样该类就不会被实例化
    private SingletonObject(){}

    //获取唯一可用的对象
    public static SingletonObject getInstance(){
        return singletonObject;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }

}
