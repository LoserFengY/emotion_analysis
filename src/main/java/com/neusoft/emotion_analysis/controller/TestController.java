package com.neusoft.emotion_analysis.controller;

import com.neusoft.emotion_analysis.entity.User;
import com.neusoft.emotion_analysis.mapper.UserMapper;
import com.neusoft.emotion_analysis.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {
    @Resource
    UserMapper mapper;
    @RequestMapping("hello")
    public Result<List<User>> hello()
    {
        return Result.success(mapper.findall());
    }
}
