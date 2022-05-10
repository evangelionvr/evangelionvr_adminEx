package com.liaofan.adminex.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MyComHealthIndicator extends AbstractHealthIndicator {

    /**
     * 自定义健康检查
     *
     * @param builder
     * @throws Exception
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        Map<String, Object> details = new HashMap<String, Object>();
        if (1 == 1) {
            //builder.up();//健康
            builder.status(Status.UP);    //健康
            details.put("count", "1");    //放入总数
            details.put("msg", "健康");    //放入消息
        } else {
           builder.status(Status.OUT_OF_SERVICE);  //不健康
            details.put("err", "连接超时");   //放入错误信息
            details.put("ms", "不健康");
        }

        builder.withDetail("code",5000).withDetails(details);

    }

    @Override
    public Health getHealth(boolean includeDetails) {
        return super.getHealth(includeDetails);
    }
}
