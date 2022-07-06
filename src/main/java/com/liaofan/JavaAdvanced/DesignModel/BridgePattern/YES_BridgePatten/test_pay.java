package com.liaofan.JavaAdvanced.DesignModel.BridgePattern.YES_BridgePatten;

import com.liaofan.JavaAdvanced.DesignModel.BridgePattern.YES_BridgePatten.channel.WxPay;
import com.liaofan.JavaAdvanced.DesignModel.BridgePattern.YES_BridgePatten.channel.ZfbPay;
import com.liaofan.JavaAdvanced.DesignModel.BridgePattern.YES_BridgePatten.mode.PayCypher;
import com.liaofan.JavaAdvanced.DesignModel.BridgePattern.YES_BridgePatten.mode.PayFaceMode;
import org.junit.Test;

import java.math.BigDecimal;


/**
 * @author 廖钒
 * @ClassName test
 * @description: TODO
 * @datetime 2022年 06月 27日 17:38
 * @version: 1.0
 */

public class test_pay {
    public static void main(String[] args) {
        System.out.println("模拟测试场景,微信支付,人脸方式");
        WxPay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("weChatPay_000001","000000001",new BigDecimal(10000));

        System.out.println("模拟测试场景,支付宝支付,指纹方式");
        ZfbPay zfbPay = new ZfbPay(new PayCypher());
        zfbPay.transfer("zfbPay_000001","000000002",new BigDecimal(200000));

    }
}
