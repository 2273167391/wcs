package com.zhanhong.wcs.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhanhong.wcs.mapper.MenuRoleMapper;
import com.zhanhong.wcs.service.MenuRoleService;

@Service
public class MenuRoleServiceImpl implements MenuRoleService{
	
	@Autowired
	private MenuRoleMapper menuRoleMapper;

	@Override
	public void addMenuRole(String menusId, int roleId) {
		String[] menuId=menusId.split(",");
		//添加关系时先删除关系
		menuRoleMapper.deleteMenuRole(roleId);
		for(int i=0;i<menuId.length;i++){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("menuId", menuId[i]);
			map.put("roleId", roleId);
			//添加菜单角色关系
			menuRoleMapper.addMenuRole(map);
		}
	}

	@Override
	public String getMenuId(int roleId) {
		return menuRoleMapper.getMenuId(roleId);
	}

}
