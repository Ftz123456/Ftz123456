package com.example.springscuritybasic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ftz
 * 创建时间:6/12/2023 下午1:12
 * 描述: TODO
 */
@Controller
public class LoginController {
    //登录页面
    @GetMapping("/login")
    public String login(){
        return "login/login";
    }
}
