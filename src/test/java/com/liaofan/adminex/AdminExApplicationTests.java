package com.liaofan.adminex;

import com.liaofan.adminex.Mapper.UserMapperMybatisPlus;
import com.liaofan.adminex.bean.User;
import com.liaofan.adminex.bean.User_mybatisplus;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
@MapperScan("com.liaofan.adminex.Mapper")
class AdminExApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;


    @Test
    void contextLoads() {
        Integer i = jdbcTemplate.queryForObject("select count(*) from user", Integer.class);
        System.out.println(i);

        log.info("数据源类型:" + dataSource.getClass());
    }

    @Autowired
    UserMapperMybatisPlus userMapperMybatisPlus;

    @Test
    void TestMyBatisPlus() {
        User_mybatisplus user_mybatisplus = userMapperMybatisPlus.selectById(1);
        log.info("用户信息:{}",user_mybatisplus);
    }

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;


    //测试redis
    @Test
    void testRedis() {
//        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
//        stringStringValueOperations.set("name", "liaofan");
//
//        String name = stringStringValueOperations.get("name");
//        System.out.println(name);

//        System.out.println(redisConnectionFactory.getClass());

        //获取cpu核心数
        System.out.println(Runtime.getRuntime().availableProcessors());

        //获取内存总量
        System.out.println(Runtime.getRuntime().totalMemory());

        //获取可用内存
        System.out.println(Runtime.getRuntime().freeMemory());

        //获取硬盘总量
        System.out.println(Runtime.getRuntime().maxMemory());

        
    }

}
