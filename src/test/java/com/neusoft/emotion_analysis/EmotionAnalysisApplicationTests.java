package com.neusoft.emotion_analysis;

import com.neusoft.emotion_analysis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@SpringBootTest
class EmotionAnalysisApplicationTests {
    @Resource
    PasswordEncoder passwordEncoder;
    @Resource
    UserMapper userMapper;
    @Resource
    AuthenticationManager authenticationManager;
    @Test
    void contextLoads() {
        System.out.println(authenticationManager==null);
    }

}
