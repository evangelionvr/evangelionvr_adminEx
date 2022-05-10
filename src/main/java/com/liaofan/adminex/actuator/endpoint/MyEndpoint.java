package com.liaofan.adminex.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
@Endpoint(id = "myServiceEndPoint")
public class MyEndpoint {
    @ReadOperation
    public Map getDockInfo() {
        return Collections.singletonMap("dockerInfo", "dock started");
    }

    @WriteOperation
    public void stopDocker() {
        System.out.println("docker stoped.....");
    }
}
