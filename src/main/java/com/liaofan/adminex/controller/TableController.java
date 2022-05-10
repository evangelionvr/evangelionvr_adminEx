package com.liaofan.adminex.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liaofan.adminex.bean.User;
import com.liaofan.adminex.bean.User_mybatisplus;
import com.liaofan.adminex.service.User_mybatisPlus_Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
    /**
     *
     * @param a 不带请求参数或者参数类型不对, 400:Bad Request 一般都是浏览器的参数没有传递正确
     * @return
     */
    @GetMapping("/basic_table")
    public String basic_table(@RequestParam("a") int a) {
        int i = 10/0;
        return "table/basic_table";
    }



    @Autowired
    User_mybatisPlus_Service user_mybatisPlus_service;


    /**
     * 分页查询
     * @param pn
     * @param model
     * @return
     */
    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value="pn",defaultValue = "1") Integer pn, Model model) {

        //表格内容遍历

//        List<User> users = Arrays.asList(new User("张三", "123456"),
//                new User("李四", "123456"),
//                new User("王麻子", "123456"),
//                new User("张三", "123456")
//        );
//        model.addAttribute("users",users);

        //从数据库里面查出user信息

        List<User_mybatisplus> list = user_mybatisPlus_service.list();   //查出所有的user信息
//        model.addAttribute("users",list);

        /**
         * 分页查询， 利用mybatisplus做分页查询
         */
        Page<User_mybatisplus> page_mybatisplus = new Page<User_mybatisplus>(pn,5);  //每页10条数据
        IPage<User_mybatisplus> page = user_mybatisPlus_service.page(page_mybatisplus, null); //查询分页数据
        model.addAttribute("page",page); //将分页数据放入model
        model.addAttribute("pn",pn); //将当前页码放入model,为了删除按钮的页码跳转

        return "table/dynamic_table";
    }


    @GetMapping("/responsive_table")
    public String responsive_table() {

        return "table/responsive_table";
    }


    @GetMapping("/editable_table")
    public String editable_table() {
        return "table/editable_table";
    }


    /**
     * 删除用户
     * @param id
     * @param pn
     * @param redirectAttributes
     * @return
     */
    @GetMapping("/user/deleteUser/{id}")
    public String delete_user(@PathVariable("id") long id,    //获取删除的id
                              @RequestParam(value = "pn", defaultValue = "1") int pn,  //获取当前页码
                              RedirectAttributes redirectAttributes     //重定向属性
    ) {

        user_mybatisPlus_service.removeById(id);    //根据id删除user
        redirectAttributes.addAttribute("pn",pn);   //跳转到当前页码

        return "redirect:/dynamic_table";
    }
}
