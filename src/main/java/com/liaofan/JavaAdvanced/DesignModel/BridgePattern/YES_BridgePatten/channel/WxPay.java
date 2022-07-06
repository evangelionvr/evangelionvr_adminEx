package com.liaofan.JavaAdvanced.DesignModel.BridgePattern.YES_BridgePatten.channel;

import com.liaofan.JavaAdvanced.DesignModel.BridgePattern.YES_BridgePatten.mode.IPayMode;

import java.math.BigDecimal;

/**
 * @author 廖钒
 * @ClassName WxPay
 * @description: TODO
 * @datetime 2022年 06月 27日 17:12
 * @version: 1.0
 */
public class WxPay extends Pay {
    /**
     * 在构造函数中让用户自行选择支付方式
     *
     * @param iPayMode
     */
    public WxPay(IPayMode iPayMode) {
        super(iPayMode);
    }

    public String transfer(String uid, String tradeID, BigDecimal amount) {
        logger.info("模拟微信划账开始, uid:{} tradeID:{},amount:{}", uid, tradeID, amount);
        boolean secruity = iPayMode.secruity(uid);

        logger.info("模拟微信渠道支付风险","uid:{} tradeID:{},amount:{}", uid, tradeID, amount);

        if(!secruity) {
            logger.info("微信风控拦截","uid:{} tradeID:{},amount:{}", uid, tradeID, amount);
            return "0001";
        }

        logger.info("微信划账成功","uid:{} tradeID:{},amount:{}", uid, tradeID, amount);
        return "0000";
    }
}
