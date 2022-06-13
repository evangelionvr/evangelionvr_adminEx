package com.liaofan.JavaAdvanced.DesignModel.BuilderPattern;


/**
 * 食物类
 */
public interface Food {
    /**
     * 名字
     * @return
     */
    public String name();

    /**
     * 打包方式
     * @return
     */
    public Packing packing();

    /**
     * 价格
     * @return
     */
    public float price();
}
