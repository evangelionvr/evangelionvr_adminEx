package com.liaofan.adminex.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("user_mybatisplus_table")   //表名,如果不写默认为类名
public class User_mybatisplus {
    private String name;


    @TableField(value = "user_name",exist = false)   //可以不写exist,默认为true,表示字段存在
    private String userName;
    @TableField(value = "password",exist = false)  //用来控制是否显示字段,默认为true,表示显示字段,false表示不显示
    private String password;



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //以下是数据库字段
    private Long id;
    private String age;
    private String email;
}
