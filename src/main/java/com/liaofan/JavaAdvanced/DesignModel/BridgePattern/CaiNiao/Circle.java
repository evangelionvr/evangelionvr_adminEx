package com.liaofan.JavaAdvanced.DesignModel.BridgePattern.CaiNiao;

/**
 * @author 廖钒
 * @ClassName Circle
 * @description: TODO
 * @datetime 2022年 06月 27日 16:15
 * @version: 1.0
 */
public class Circle extends Shape{
    private int x, y, radius;

    /**
     * 构造方法_构造时获取接口
     *
     * @param drawAPI
     */
    protected Circle(int x, int y, int radius,DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius, x,y);
    }
}
