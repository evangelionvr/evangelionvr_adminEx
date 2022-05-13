package com.liaofan.adminex;

import com.liaofan.Ptyhon.RunnerPythonBase;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author evangelion
 */
@ServletComponentScan(basePackages = "com.liaofan.adminex")  //指定原生servlet组件都放在哪里
@SpringBootApplication
@MapperScan("com.liaofan.adminex.Mapper")   //建议直接写,批量扫描
public class AdminExApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(AdminExApplication.class, args);
        ConfigurableEnvironment environment = run.getEnvironment();
        Map<String, Object> systemEnvironment = environment.getSystemEnvironment();
        Map<String, Object> systemProperties = environment.getSystemProperties();

        System.out.println("systemEnvironment:" + systemEnvironment);
        System.out.println("systemProperties:" + systemProperties);



    }


}
