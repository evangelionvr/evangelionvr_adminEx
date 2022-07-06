package com.liaofan.JavaAdvanced.DesignModel.BridgePattern.YES_BridgePatten.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 廖钒
 * @ClassName PayCypher
 * @description: TODO
 * @datetime 2022年 06月 27日 17:36
 * @version: 1.0
 */
public class PayCypher implements IPayMode{
    protected Logger logger = LoggerFactory.getLogger(PayFaceMode.class);
    @Override
    public boolean secruity(String uid) {
        logger.info("密码支付,风险校验密码识别");
        return false;
    }
}
