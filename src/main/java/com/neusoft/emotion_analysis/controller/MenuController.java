package com.neusoft.emotion_analysis.controller;

import com.neusoft.emotion_analysis.entity.Menu;
import com.neusoft.emotion_analysis.service.MenuService;
import com.neusoft.emotion_analysis.util.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MenuController {
    @Resource
    MenuService MenuService;
    @RequestMapping("deleteMenu")
    public Result deleteMenu(int MenuId)
    {
        int r=MenuService.deleteMenu(MenuId);
        if(r>0)
        {
            return Result.success("删除成功");
        }
        return Result.success("删除失败");
    }
    @RequestMapping("addMenu")
    public Result addMenu(@RequestBody Menu Menu)
    {
        int r= MenuService.addMenu(Menu);
        if(r>0)
        {
            return Result.success("添加成功");
        }
        return Result.success("添加失败");
    }
    @RequestMapping("updateMenu")
    public Result updateMenu(@RequestBody Menu Menu)
    {
        int r= MenuService.updateMenu(Menu);
        if(r>0)
        {
            return Result.success("修改成功");
        }
        return Result.success("修改失败");
    }
    @RequestMapping("findAllMenu")
    public Result findAllMenu()
    {
        List<Menu> arr=MenuService.findAllMenu();
        if(arr!=null&&arr.size()!=0)
        {
            return Result.success(arr);
        }
        return Result.success("无角色");
    }
}
