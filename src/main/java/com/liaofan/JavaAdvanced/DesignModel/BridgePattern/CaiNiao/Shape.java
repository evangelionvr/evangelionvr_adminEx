package com.liaofan.JavaAdvanced.DesignModel.BridgePattern.CaiNiao;

/**
 * @author 廖钒
 * @ClassName Shape
 * @description: TODO
 * @datetime 2022年 06月 27日 16:13
 * @version: 1.0
 */
public abstract class Shape {
    //定义一个drawAPI
    protected DrawAPI drawAPI;

    /**
     * 构造方法_构造时获取接口
     * @param drawAPI
     */
    protected Shape(DrawAPI drawAPI) {
        //获取传入的drawAPI接口,并赋值给DrawAPI变量
        this.drawAPI = drawAPI;
    }

    /**
     * 抽象方法,画
     */
    public abstract void draw();
}
