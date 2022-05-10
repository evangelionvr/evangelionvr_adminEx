package com.liaofan.adminex.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;


/**
 * 表格控制层
 */
@Controller
@Slf4j
public class FormController {
    @GetMapping("/form_layouts")
    public String form_layoutss() {
        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("email")String email,
                         @RequestParam("username") String username,
                         @RequestParam("headImg") MultipartFile headImg,
                         @RequestParam("photos") MultipartFile [] photos
                         ) throws IOException {
        log.info("上传的信息： email=" + email + "userNAME:" + username + ",headImg:"
                + headImg.getSize()
                + ", photo:" + photos.length
        );

        if(!headImg.isEmpty()) {
            //保存在文件服务器
            String originalFilename = headImg.getOriginalFilename();
            headImg.transferTo(new File("D:\\" + "测试数据" + "\\" +  originalFilename));
        }

        if(photos.length > 0) {
            for (MultipartFile file_photo:photos) {
                String originalFilename_photo = file_photo.getOriginalFilename();
                //SpringBoot封装的文件传输
                file_photo.transferTo(new File("D:\\" + "测试数据" + "\\" + "photo" + "\\" + originalFilename_photo));
            }
        }
        return "main";

        //return "redirect:/uploadmain.html";
    }


    /**
     * post请求只能通过这种方式跳转?
     * @param httpSession
     * @param model
     * @return
     */
    @GetMapping("/uploadmain.html")
    public String mainPage(HttpSession httpSession, Model model) {

//        Object loginUser = httpSession.getAttribute("loginUser");

//        if(loginUser != null) {
            //是否登陆
            return "main";
//        } else {
//            model.addAttribute("msg","请重新登录");
//            return "login";
//        }


    }



}
