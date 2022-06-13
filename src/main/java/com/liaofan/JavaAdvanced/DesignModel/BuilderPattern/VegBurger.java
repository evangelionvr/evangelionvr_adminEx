package com.liaofan.JavaAdvanced.DesignModel.BuilderPattern;

/**
 * @author 廖钒
 * @ClassName VegBurger
 * @description: TODO
 * @datetime 2022年 06月 13日 18:26
 * @version: 1.0
 *  使用继承抽象类的方式来对Burger进行扩写,由于包装的类型已经由抽象对象决定了.所以不再进行@Override,
 *  只对另外两个抽象方法进行Override
 */
public class VegBurger extends Burger{
    @Override
    public String name() {
        return "VegBurger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
