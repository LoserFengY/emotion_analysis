package com.neusoft.emotion_analysis.controller;

import com.neusoft.emotion_analysis.entity.RoleMenu;
import com.neusoft.emotion_analysis.service.RoleMenuService;
import com.neusoft.emotion_analysis.util.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RoleMenuController {
    @Resource
    RoleMenuService roleMenuService;
    @RequestMapping("/addRoleMenu")
    public Result addRoleMenu(@RequestBody RoleMenu roleMenu)
    {
        int i = roleMenuService.addRoleMenu(roleMenu);
        if(i>0)
        {
            return Result.success("添加成功");
        }
        return Result.success("添加失败");
    }
    @RequestMapping("/deleteRoleMenu")
    public Result deleteRoleMenu(int roleMenuId)
    {
        int r=roleMenuService.deleteRoleMenu(roleMenuId);
        if(r>0)
        {
            return Result.success("删除成功");
        }
        return Result.success("删除失败");
    }
}
