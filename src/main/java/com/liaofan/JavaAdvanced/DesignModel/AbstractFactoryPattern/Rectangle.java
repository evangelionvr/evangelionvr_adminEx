package com.liaofan.JavaAdvanced.DesignModel.AbstractFactoryPattern;

import com.liaofan.JavaAdvanced.DesignModel.FactoryPattern.Shape;

/**
 * 厂方形的实现类
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
