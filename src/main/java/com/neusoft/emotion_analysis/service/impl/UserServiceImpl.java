package com.neusoft.emotion_analysis.service.impl;

import com.neusoft.emotion_analysis.entity.User;
import com.neusoft.emotion_analysis.mapper.UserMapper;
import com.neusoft.emotion_analysis.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Mapper
    UserMapper userMapper;
    @Override
    public int deleteUser(Integer userId) {
        return userMapper.deleteUser(userId);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User findUserByName(String userName) {
        return userMapper.findUserByName(userName);
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findall();
    }
}
