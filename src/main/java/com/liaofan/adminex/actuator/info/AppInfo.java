package com.liaofan.adminex.actuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;


@Component
public class AppInfo implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("appName", "evangelionvr");
        builder.withDetail("version", "1.0.0");
        builder.withDetail("author", "liaofan");
        builder.withDetail("email", "evangelionvr@foxmail.com");
    }
}
