package com.liaofan.JavaAdvanced.DesignModel.BuilderPattern;

/**汉堡类
 * @author 廖钒
 * @ClassName Burger
 * @description: TODO
 * @datetime 2022年 06月 13日 18:19
 * @version: 1.0
 * 该类继承于套餐类,作为套餐的一个实现类
 */
public abstract class Burger implements Food {
    @Override
    /**
     * 1.因为汉堡的包装默认是纸,所以返回一个纸包装类对象
     * 2.同时,由于Wrapper是包装类(Packing)的一个实现,所以可以用接口Packing返回
     */
    public Packing packing() {
        return new Wrapper();
    }

    /**
     *  由于此时Burger是一个抽象类,仍旧还不是最终的实现类,故对价钱的变量进行抽象
     */
    @Override
    public abstract float price();
}
