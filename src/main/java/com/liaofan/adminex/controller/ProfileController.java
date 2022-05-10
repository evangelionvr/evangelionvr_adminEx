package com.liaofan.adminex.controller;

import com.liaofan.adminex.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 配置文件
 * Created by liaofan on 17/3/1.
 */
@Controller
public class ProfileController {



    @Value("${profile.name:李四}")
    String profile = "profile";


    @Value("${person.name}")
    String name;

    @ResponseBody
    @GetMapping("/profile")
    public String hello() {
        String s = "测试: " + profile;
        return s;
    }


    @Autowired
    private Person person;

    @ResponseBody
    @GetMapping("/person")
    public Person person() {
        return person;
    }

    @Value("${JAVA_HOME}")
    private String message;

    @Value("${os.name}")
    private String os_information;


    @ResponseBody
    @GetMapping("message")
    public String getMessage() {

        return message + "...操作系统:Value:{#..Msg}...." + os_information;
    }
}
