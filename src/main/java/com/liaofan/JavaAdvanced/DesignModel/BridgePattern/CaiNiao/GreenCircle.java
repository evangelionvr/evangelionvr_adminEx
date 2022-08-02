package com.liaofan.JavaAdvanced.DesignModel.BridgePattern.CaiNiao;

/**
 * @author 廖钒
 * @ClassName GreenCircle
 * @description: 绿色方形
 * @datetime 2022年 06月 27日 16:12
 * @version: 1.0
 */
public class GreenCircle implements DrawAPI{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}
