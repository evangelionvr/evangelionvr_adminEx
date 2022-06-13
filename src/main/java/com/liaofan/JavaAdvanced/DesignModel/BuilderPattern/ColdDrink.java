package com.liaofan.JavaAdvanced.DesignModel.BuilderPattern;

/**
 * @author 廖钒
 * @ClassName ColdDrink
 * @description: TODO
 * @datetime 2022年 06月 13日 18:21
 * @version: 1.0
 */
public abstract class ColdDrink implements Food {
    /**
     *
     * @return 对于所有的冷饮来说,包装肯定不可能用纸,所以该包装方法选择返回瓶装类对象来进行返回值
     */
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
