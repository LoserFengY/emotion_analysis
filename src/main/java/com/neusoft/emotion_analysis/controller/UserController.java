package com.neusoft.emotion_analysis.controller;

import com.neusoft.emotion_analysis.entity.User;
import com.neusoft.emotion_analysis.service.UserService;
import com.neusoft.emotion_analysis.util.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {
    @Resource
    UserService userService;
    @RequestMapping("/deleteUser")
    public Result deleteUser(Integer id)
    {
        int r=userService.deleteUser(id);
        if(r>0)
        {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }
    @RequestMapping("updateUser")
    public Result updateUser(@RequestBody User user)
    {
        int r= userService.updateUser(user);
        if(r>0)
        {
            return Result.success("修改成功");

        }
        return Result.success("修改失败");
    }
    @RequestMapping("addUser")
    public Result addUser(@RequestBody User user)
    {
        int r= userService.addUser(user);
        if(r>0)
        {
            return Result.success("添加成功");
        }
        return Result.success("添加失败");
    }
    @RequestMapping ("findAllUser")
    public Result findAllUser()
    {
        List<User> allUser = userService.findAllUser();
        if(allUser!=null&&allUser.size()!=0)
        {
            return Result.success(allUser);
        }
        return Result.success("无用户");
    }

}
