package com.zhanhong.wcs.mapper;

import java.util.List;

import com.zhanhong.wcs.entity.sys.WcsSysMenus;

public interface MenusMapper {
	/**
	 * 添加菜单
	 * @param menus
	 * @return
	 */
	public int addMenus(WcsSysMenus menus);
	
	/**
	 * 修改菜单
	 * @param menus
	 * @return
	 */
	public int updateMenus(WcsSysMenus menus);
	
	/**
	 * 删除菜单
	 * @param menuId
	 * @return
	 */
	public int deleteMenus(int menuId);
	
	/**
	 * 根据上级菜单ID查询菜单
	 * @param menuName
	 * @return
	 */
	public List<WcsSysMenus> queryMenuByParentId(int menuParentId);
	
	/**
	 * 根据角色ID获取菜单
	 * @param empId
	 * @return
	 */
	public List<WcsSysMenus> queryMenuByRoleId(int roleId);
	
	/**
	 * 获取所有菜单
	 * @return
	 */
	public List<WcsSysMenus> queryAllMenu();
	
	/**
	 * 根据菜单名称查询菜单
	 * @param menuName
	 * @return
	 */
	public WcsSysMenus queryMenuByName(String menuName);
}
