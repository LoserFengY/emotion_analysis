package com.neusoft.emotion_analysis.controller;

import com.neusoft.emotion_analysis.entity.User;
import com.neusoft.emotion_analysis.service.impl.LoginServiceImpl;
import com.neusoft.emotion_analysis.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    LoginServiceImpl loginService;
    @PostMapping("/login")
    public Result login(@RequestBody User user)
    {
        return loginService.login(user);
    }

    @GetMapping("/lout")
    public Result logout(){
        return loginService.logout();
    }

}
