package com.liaofan.JavaAdvanced.DesignModel.FactoryPattern;

/**
 * 厂方形的实现类
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
