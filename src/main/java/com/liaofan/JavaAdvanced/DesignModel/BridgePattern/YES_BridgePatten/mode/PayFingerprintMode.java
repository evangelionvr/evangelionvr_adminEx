package com.liaofan.JavaAdvanced.DesignModel.BridgePattern.YES_BridgePatten.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 廖钒
 * @ClassName PayFingerprintMode
 * @description: TODO
 * @datetime 2022年 06月 27日 17:33
 * @version: 1.0
 */
public class PayFingerprintMode implements IPayMode {
    protected Logger logger = LoggerFactory.getLogger(PayFingerprintMode.class);

    @Override
    public boolean secruity(String uid) {
        logger.info("指纹支付,风险校验指纹信息");
        return false;
    }
}
