package com.neusoft.emotion_analysis.service;

import com.neusoft.emotion_analysis.entity.User;

import java.util.List;

public interface UserService {
    public int deleteUser(Integer userId);
    public int updateUser(User user);
    public int addUser(User user);
    public User findUserByName(String userName);
    public List<User> findAllUser();

}
