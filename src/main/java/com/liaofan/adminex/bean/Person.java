package com.liaofan.adminex.bean;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Person {
    private String name;
    private String age;
}
