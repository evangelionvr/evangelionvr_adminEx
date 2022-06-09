package com.liaofan.JavaAdvanced.DesignModel.FactoryPattern;

/**
 * 圆圈类
 */
public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
