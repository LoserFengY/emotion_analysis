package com.neusoft.emotion_analysis.service.impl;

import com.neusoft.emotion_analysis.entity.LoginUser;
import com.neusoft.emotion_analysis.entity.User;
import com.neusoft.emotion_analysis.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //查询用户信息
        User user=userMapper.findUserByName(userName);
        if(Objects.isNull(user))
        {
            throw new RuntimeException("用户名或密码错误");
        }
        //TODO 查询权限信息
        List<String>power=new ArrayList<>(Arrays.asList("test","admin"));
        return new LoginUser(user,power);
    }
}
