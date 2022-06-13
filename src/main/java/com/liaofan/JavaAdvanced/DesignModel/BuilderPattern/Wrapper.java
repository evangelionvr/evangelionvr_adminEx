package com.liaofan.JavaAdvanced.DesignModel.BuilderPattern;

/**
 * @author 廖钒
 * @ClassName Wrapper 纸包装类对象
 * @description: TODO
 * @datetime 2022年 06月 13日 18:17
 * @version: 1.0
 */
public class Wrapper implements Packing{
    //纸包装类,是Packing的一个实现类
    @Override
    public String pack() {
        return "Wrapper";
    }
}
