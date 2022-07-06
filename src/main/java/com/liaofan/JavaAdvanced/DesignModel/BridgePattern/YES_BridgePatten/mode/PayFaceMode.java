package com.liaofan.JavaAdvanced.DesignModel.BridgePattern.YES_BridgePatten.mode;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 廖钒
 * @ClassName PayFaceMode
 * @description: TODO
 * @datetime 2022年 06月 27日 17:27
 * @version: 1.0
 */
@Slf4j
public class PayFaceMode implements IPayMode {
        protected Logger logger = LoggerFactory.getLogger(PayFaceMode.class);

    @Override
    public boolean secruity(String uid) {
        logger.info("人脸支付,风险校验脸部识别");
        return true;
    }
}
