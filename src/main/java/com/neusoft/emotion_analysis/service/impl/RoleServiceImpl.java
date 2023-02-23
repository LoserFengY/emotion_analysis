package com.neusoft.emotion_analysis.service.impl;

import com.neusoft.emotion_analysis.entity.Role;
import com.neusoft.emotion_analysis.mapper.RoleMapper;
import com.neusoft.emotion_analysis.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    RoleMapper mapper;
    @Override
    public int deleteRole(int id) {
        return mapper.deleteRole(id);
    }

    @Override
    public int updateRole(Role role) {
        return mapper.updateRole(role);
    }

    @Override
    public int addRole(Role role) {
        return mapper.addRole(role);
    }

    @Override
    public List<Role> findAllRole() {
        return mapper.findAllRole();
    }
}
