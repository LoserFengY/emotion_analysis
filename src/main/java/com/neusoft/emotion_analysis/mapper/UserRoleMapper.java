package com.neusoft.emotion_analysis.mapper;

import com.neusoft.emotion_analysis.entity.UserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMapper {
    @Insert("insert into user_role(role_id,user_id) values(#{roleId},#{userId})")
    public  int addUserRole(UserRole userRole);
    @Delete("delete from user_role where user_role_id=#{UserRoleId}")
    public int deleteUserRole(int UserRoleId);
}