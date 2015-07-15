package com.zhanhong.wcs.service;

import java.util.List;

import com.zhanhong.wcs.entity.sys.WcsSysMenus;
import com.zhanhong.wcs.view.sys.WcsSysMenusV;
/**
 * 菜单服务接口
 * @author Arvin_Li
 *
 */
public interface MenusService {
	/**
	 * 添加菜单
	 * @param menus
	 * @return
	 */
	public String addMenus(WcsSysMenus menus);
	
	/**
	 * 修改菜单
	 * @param menus
	 * @return
	 */
	public String updateMenus(WcsSysMenus menus);
	
	/**
	 * 删除菜单
	 * @param menuId
	 * @return
	 */
	public String deleteMenus(int menuId);
	
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
	 * 根据菜单ID获取菜单信息
	 * @param menuId
	 * @return
	 */
	public WcsSysMenusV queryMenusVById(int menuId);
}
