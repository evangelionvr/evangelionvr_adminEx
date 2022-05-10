package com.liaofan.adminex.controller;


import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SQLController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    Counter counter;


    public SQLController(MeterRegistry meterRegistry) {
        counter = meterRegistry.counter("sql.query");
    }

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDB() {
        counter.increment();   //计数器计数
        Integer i = jdbcTemplate.queryForObject("select count(*) from user",Integer.class);   //查询数据库
        return i.toString();     //返回结果
    }
}
