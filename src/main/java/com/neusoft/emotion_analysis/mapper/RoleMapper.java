package com.neusoft.emotion_analysis.mapper;

import com.neusoft.emotion_analysis.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RoleMapper {
    public int addRole(Role role);
    public int updateRole(Role role);
    public int deleteRole(int  roleId);
    public List<Role> findAllRole();

}
