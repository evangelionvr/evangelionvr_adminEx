package com.liaofan.JavaAdvanced.DesignModel.BridgePattern.CaiNiao;

/**
 * @author 廖钒
 * @ClassName BridgePatternDemo
 * @description: 桥接模式demo
 * @datetime 2022年 06月 27日 16:18
 * @version: 1.0
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        greenCircle.draw();
        redCircle.draw();
    }
}
