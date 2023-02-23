package com.neusoft.emotion_analysis.mapper;

import com.neusoft.emotion_analysis.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    public  int addMenu(Menu menu);
    public  int deleteMenu(int menuId);
    public int updateMenu(Menu menu);
    public List<Menu> findAllMenu();
}
