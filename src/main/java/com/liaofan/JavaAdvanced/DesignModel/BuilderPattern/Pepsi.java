package com.liaofan.JavaAdvanced.DesignModel.BuilderPattern;

/**
 * @author 廖钒
 * @ClassName Pepsi
 * @description: TODO
 * @datetime 2022年 06月 13日 18:28
 * @version: 1.0
 */
public class Pepsi extends ColdDrink{
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 5.0f;
    }
}
