package com.liaofan.adminex.controller;


import com.liaofan.adminex.bean.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${person.name}")
    private String name;

    public Person person;

    public Person helloController() {
        person = new Person();
        person.setName(name);
        return person;
    }
}
