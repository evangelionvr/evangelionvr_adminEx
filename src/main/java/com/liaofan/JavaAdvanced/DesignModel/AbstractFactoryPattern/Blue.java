package com.liaofan.JavaAdvanced.DesignModel.AbstractFactoryPattern;

public class Blue implements Color{
    @Override
    public void fill() {
        System.out.println("现在要填充蓝色");
    }
}
