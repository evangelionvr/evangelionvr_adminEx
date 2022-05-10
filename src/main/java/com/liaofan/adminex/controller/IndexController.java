package com.liaofan.adminex.controller;

import com.liaofan.adminex.Mapper.CityMapper;
import com.liaofan.adminex.bean.Account;
import com.liaofan.adminex.bean.City;
import com.liaofan.adminex.bean.User;
import com.liaofan.adminex.service.AccountService;
import com.liaofan.adminex.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 主页控制层
 */
@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Resource
    AccountService accountService;

    @Resource
    CityService cityService;


    @ResponseBody
    @GetMapping("/getCity")
    public City getCityByID(@RequestParam("id") Long id) {
        return cityService.getCityById(id);
    }


    /**
     * 写入城市
     *
     * @param city
     */
    @ResponseBody
    @PostMapping("/insertCity")
    public void insertCity(City city) {
        //int i = cityService.insertCity(city);
    }

    @ResponseBody
    @GetMapping("/getAcct")
    public Account getByID(@RequestParam("id") Long id) {
        return accountService.getAccountMapper(id);
    }

    @ResponseBody
    @GetMapping("/sql_query")
    public String queryFromDB() {
        Integer i = jdbcTemplate.queryForObject("select count(*) from user", Integer.class);
        return i.toString();
    }


    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        //重定向到main
        if (!StringUtils.isEmpty(user.getUserName()) && "123456".equals(user.getPassword())) {
            session.setAttribute("loginUser", user);
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "账号密码错误");
            return "login";
        }


    }

    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("/main.html")
    public String mainPage(HttpSession httpSession, Model model) {

        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        String maincount = stringStringValueOperations.get("/main.html");
        String sql_count = stringStringValueOperations.get("/sql");

        model.addAttribute("maincount", maincount);
        model.addAttribute("sql_count", sql_count);


        Object loginUser = httpSession.getAttribute("loginUser");

        if (loginUser != null) {
            //是否登陆
            return "main";
        } else {
            model.addAttribute("msg", "请重新登录");
            return "login";
        }
    }
}
