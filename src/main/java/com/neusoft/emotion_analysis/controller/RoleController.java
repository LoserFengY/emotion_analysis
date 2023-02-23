package com.neusoft.emotion_analysis.controller;

import com.neusoft.emotion_analysis.entity.Role;
import com.neusoft.emotion_analysis.service.RoleService;
import com.neusoft.emotion_analysis.util.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RoleController {
    @Resource
    RoleService roleService;
    @RequestMapping("deleteRole")
    public Result deleteRole(int roleId)
    {
        int r=roleService.deleteRole(roleId);
        if(r>0)
        {
            return Result.success("删除成功");
        }
        return Result.success("删除失败");
    }
    @RequestMapping("addRole")
    public Result addRole(@RequestBody Role role)
    {
        int r= roleService.addRole(role);
        if(r>0)
        {
            return Result.success("添加成功");
        }
        return Result.success("添加失败");
    }
    @RequestMapping("updateRole")
    public Result updateRole(@RequestBody Role role)
    {
        int r= roleService.updateRole(role);
        if(r>0)
        {
            return Result.success("修改成功");
        }
        return Result.success("修改失败");
    }
    @RequestMapping("findAllRole")
    public Result findAllRole()
    {
        List<Role> arr=roleService.findAllRole();
        if(arr!=null&&arr.size()!=0)
        {
            return Result.success(arr);
        }
        return Result.success("无角色");
    }
}
