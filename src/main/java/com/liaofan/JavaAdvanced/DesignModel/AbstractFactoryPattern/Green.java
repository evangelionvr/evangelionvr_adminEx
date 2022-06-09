package com.liaofan.JavaAdvanced.DesignModel.AbstractFactoryPattern;

public class Green implements Color{
    @Override
    public void fill() {
        System.out.println("现在要填充绿色");
    }
}
