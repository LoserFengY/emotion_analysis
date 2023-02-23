package com.neusoft.emotion_analysis.service.impl;

import com.neusoft.emotion_analysis.entity.Menu;
import com.neusoft.emotion_analysis.mapper.MenuMapper;
import com.neusoft.emotion_analysis.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    MenuMapper mapper;
    @Override
    public int deleteMenu(int id) {
        return mapper.deleteMenu(id);
    }

    @Override
    public int updateMenu(Menu Menu) {
        return mapper.updateMenu(Menu);
    }

    @Override
    public int addMenu(Menu Menu) {
        return mapper.addMenu(Menu);
    }

    @Override
    public List<Menu> findAllMenu() {
        return mapper.findAllMenu();
    }
}
