package com.neusoft.emotion_analysis.mapper;

import com.neusoft.emotion_analysis.entity.RoleMenu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMenuMapper {
    @Insert("insert into role_menu(role_id,menu_id) values(#{roleId},#{menuId})")
    public  int addRoleMenu(RoleMenu roleMenu);
    @Delete("delete from role_menu where role_menu_id=#{roleMenuId}")
    public int deleteRoleMenu(int roleMenuId);
}
