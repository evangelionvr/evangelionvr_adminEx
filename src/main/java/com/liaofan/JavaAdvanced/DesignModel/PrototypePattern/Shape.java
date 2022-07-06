package com.liaofan.JavaAdvanced.DesignModel.PrototypePattern;

import lombok.Data;

/**
 * @author 廖钒
 * @ClassName Shape
 * @description: TODO
 * @datetime 2022年 06月 16日 14:01
 * @version: 1.0
 * 创建一个实现了 *Cloneable* 接口的抽象类。
 */
@Data
public abstract class Shape implements Cloneable {
    private String id;
    private String type;

    abstract void draw();

    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
