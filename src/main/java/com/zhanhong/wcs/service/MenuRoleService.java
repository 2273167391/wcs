package com.zhanhong.wcs.service;

public interface MenuRoleService {
	/**
	 * 添加菜单角色关系
	 * @param map
	 * @return
	 */
	public void addMenuRole(String menusId,int roleId);
	
	/**
	 * 根据角色ID获取菜单ID
	 * @param roleId
	 * @return
	 */
	public String getMenuId(int roleId);
}
