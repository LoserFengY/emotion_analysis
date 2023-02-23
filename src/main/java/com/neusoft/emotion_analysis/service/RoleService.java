package com.neusoft.emotion_analysis.service;

import com.neusoft.emotion_analysis.entity.Role;

import java.util.List;

public interface RoleService {
    public int deleteRole(int id);
    public int updateRole(Role role);
    public int addRole(Role role);
    public List<Role> findAllRole();
}
