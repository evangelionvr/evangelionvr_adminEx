package com.liaofan.JavaAdvanced.DesignModel.BridgePattern.NotBridgePattern;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

import java.math.BigDecimal;


/**
 * @author 廖钒
 * @ClassName PayController
 * @description: TODO
 * @datetime 2022年 06月 27日 16:46
 * @version: 1.0
 */


@Slf4j
public class PayController {
    private Logger logger = LoggerFactory.getLogger(PayController.class);

    public boolean doPay(String uid, String tradeID, BigDecimal amount, int channelType, int modeType) {
        if (1 == channelType) {
            logger.info("模拟微信划账开始, uid:{} tradeID:{},amount:{}", uid, tradeID, amount);
            if (1 == modeType) {
                logger.info("人脸风险识别");
            } else if (2 == modeType) {
                logger.info("密码风险识别");
            } else if (3 == modeType) {
                log.info("指纹风险识别");
            }
        } else if (2 == channelType) {
            logger.info("模拟支付宝划账开始,uid:{} tradeID:{},amount:{}", uid, tradeID, amount);
            if (1 == modeType) {
                logger.info("人脸风险识别");
            } else if (2 == modeType) {
                logger.info("密码风险识别");
            } else if (3 == modeType) {
                log.info("指纹风险识别");
            }
        }
        return true;
    }

    @Test
    public void test_pay() {
       PayController payController = new PayController();
        System.out.println("模拟微信");
        payController.doPay("微信_1111","1111111", new BigDecimal(100),1,1);

        System.out.println("模拟支付宝");
        payController.doPay("支付宝_231123","2222",new BigDecimal("22222"), 2,3);

    }
}
