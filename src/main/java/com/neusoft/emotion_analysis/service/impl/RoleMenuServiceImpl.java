package com.neusoft.emotion_analysis.service.impl;

import com.neusoft.emotion_analysis.entity.RoleMenu;
import com.neusoft.emotion_analysis.mapper.RoleMenuMapper;
import com.neusoft.emotion_analysis.service.RoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {
    @Resource
    RoleMenuMapper roleMenuMapper;

    @Override
    public int addRoleMenu(RoleMenu roleMenu) {
        return roleMenuMapper.addRoleMenu(roleMenu);
    }

    @Override
    public int deleteRoleMenu(int roleMenuId) {
        return roleMenuMapper.deleteRoleMenu(roleMenuId);
    }
}
