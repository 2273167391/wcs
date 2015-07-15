package com.zhanhong.wcs.mapper;

import java.util.Map;

public interface MenuRoleMapper {
	/**
	 * 添加菜单角色关系
	 * @param map
	 * @return
	 */
	public int addMenuRole(Map<String, Object> map);
	
	/**
	 * 根据角色ID删除关系
	 * @param roleId
	 * @return
	 */
	public int deleteMenuRole(int roleId);
	
	/**
	 * 根据角色ID获取菜单ID
	 * @param roleId
	 * @return
	 */
	public String getMenuId(int roleId);
}
