package com.neusoft.emotion_analysis.mapper;

import com.neusoft.emotion_analysis.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> findall();
    public User findUserByName(String userName);
    public int deleteUser(Integer userId);
    public int updateUser(User user);
    public int addUser(User user);

}
