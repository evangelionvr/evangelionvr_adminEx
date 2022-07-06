package com.liaofan.JavaAdvanced.DesignModel.BridgePattern.YES_BridgePatten.channel;

import com.liaofan.JavaAdvanced.DesignModel.BridgePattern.YES_BridgePatten.mode.IPayMode;

import java.math.BigDecimal;

/**
 * @author 廖钒
 * @ClassName zfbPay
 * @description: TODO
 * @datetime 2022年 06月 27日 17:25
 * @version: 1.0
 */
public class ZfbPay extends Pay{
    /**
     * 在构造函数中让用户自行选择支付方式
     *
     * @param iPayMode
     */
    public ZfbPay(IPayMode iPayMode) {
        super(iPayMode);
    }

    public String transfer(String uid, String tradeID, BigDecimal amount) {
        logger.info("模拟支付宝划账开始, uid:{} tradeID:{},amount:{}", uid, tradeID, amount);
        boolean secruity = iPayMode.secruity(uid);

        logger.info("模拟支付宝渠道支付风险","uid:{} tradeID:{},amount:{}", uid, tradeID, amount);

        if(!secruity) {
            logger.info("支付宝风控拦截","uid:{} tradeID:{},amount:{}", uid, tradeID, amount);
            return "0001";
        }

        logger.info("支付宝划账成功","uid:{} tradeID:{},amount:{}", uid, tradeID, amount);
        return "0000";
    }
}
