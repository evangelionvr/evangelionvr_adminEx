package com.liaofan.JavaAdvanced.DesignModel.BridgePattern.YES_BridgePatten.channel;

import com.liaofan.JavaAdvanced.DesignModel.BridgePattern.YES_BridgePatten.mode.IPayMode;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author 廖钒
 * @ClassName Pay
 * @description: TODO
 * @datetime 2022年 06月 27日 17:07
 * @version: 1.0
 */
@Slf4j
public abstract class Pay {
    //定义日志
    protected Logger logger = LoggerFactory.getLogger(Pay.class);

    /**
     * 定义支付接口_桥接接口
     */
    protected IPayMode iPayMode;

    /**
     * 在构造函数中让用户自行选择支付方式
     * @param iPayMode
     */
    public Pay(IPayMode iPayMode) {
        this.iPayMode = iPayMode;
    }
}
