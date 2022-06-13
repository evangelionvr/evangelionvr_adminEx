package com.liaofan.JavaAdvanced.DesignModel.BuilderPattern;

/**
 * @author 廖钒
 * @ClassName Bottle 瓶装类
 * @description: TODO
 * @datetime 2022年 06月 13日 18:17
 * @version: 1.0
 */
public class Bottle implements Packing{
    @Override
    /**
     * 瓶装类,是包装类的一个实现.
     */
    public String pack() {
        return "Bottle";
    }
}
