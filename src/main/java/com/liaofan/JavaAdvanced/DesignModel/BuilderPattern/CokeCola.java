package com.liaofan.JavaAdvanced.DesignModel.BuilderPattern;

/**
 * @author 廖钒
 * @ClassName CokeCola
 * @description: TODO
 * @datetime 2022年 06月 13日 18:28
 * @version: 1.0
 */
public class CokeCola extends ColdDrink{
    @Override
    public String name() {
        return "CokeCola";
    }

    @Override
    public float price() {
        return 2.0f;
    }
}
