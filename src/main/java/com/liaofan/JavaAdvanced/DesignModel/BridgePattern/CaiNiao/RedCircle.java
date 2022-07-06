package com.liaofan.JavaAdvanced.DesignModel.BridgePattern.CaiNiao;

/**
 * @author 廖钒
 * @ClassName RedCircle
 * @description: TODO
 * @datetime 2022年 06月 27日 16:12
 * @version: 1.0
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}
