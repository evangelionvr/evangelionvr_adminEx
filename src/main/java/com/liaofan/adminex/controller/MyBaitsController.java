package com.liaofan.adminex.controller;

import com.liaofan.adminex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MyBaitsController {

    @Autowired
    UserService userService;


    @GetMapping("/mybatis")
    public String getController_MyBatis() {
        int id = 1;
        userService.Sel(id).toString();
        return "";
    }
}
