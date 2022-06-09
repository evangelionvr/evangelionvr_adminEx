package com.liaofan.JavaAdvanced.DesignModel.AbstractFactoryPattern;

/**
 * 创建一个工厂创造器/生成器类，通过传递形状或颜色信息来获取工厂。
 */
public class FactoryProducer {
    public static AbstractFactory getFacotry(String choiceType) {
        if(choiceType.equalsIgnoreCase("shape")) {
            return new ShapeFactory();
        }

        if(choiceType.equalsIgnoreCase("color")) {
            return new ColorFactory();
        }

        return null;
    }
}
