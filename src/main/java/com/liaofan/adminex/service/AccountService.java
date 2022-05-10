package com.liaofan.adminex.service;


import com.liaofan.adminex.Mapper.AccountMapper;
import com.liaofan.adminex.bean.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 账号服务
 */
@Service
public class AccountService {

    @Resource
    AccountMapper accountMapper;   //账号数据库操作

    //查询账号
    public Account getAccountMapper(Long id) {
        return accountMapper.getAccount(id);
    }

}
