package com.liaofan.JavaAdvanced.DesignModel.AbstractFactoryPattern;

import com.liaofan.JavaAdvanced.DesignModel.FactoryPattern.Shape;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
