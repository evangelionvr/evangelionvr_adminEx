package com.liaofan.JavaAdvanced.DesignModel.BuilderPattern;


/**
 * 食物条目类
 */
public interface Food {
    public String name();
    public Packing packing();
    public float price();
}
