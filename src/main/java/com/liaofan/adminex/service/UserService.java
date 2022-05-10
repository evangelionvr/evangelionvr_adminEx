package com.liaofan.adminex.service;

import com.liaofan.adminex.Mapper.UserMapper;
import com.liaofan.adminex.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;

    public User Sel(int id) {
        return userMapper.Sel(id);
    }
}
