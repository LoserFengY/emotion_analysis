package com.neusoft.emotion_analysis.service;

import com.neusoft.emotion_analysis.entity.Menu;

import java.util.List;

public interface MenuService {
    public int deleteMenu(int id);
    public int updateMenu(Menu Menu);
    public int addMenu(Menu Menu);
    public List<Menu> findAllMenu();
}
