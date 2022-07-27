package com.liaofan.JavaAdvanced.DesignModel.AbstractFactoryPattern;

/**
 * 这是一个抽象工厂类
 * @author evangelionvr
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
