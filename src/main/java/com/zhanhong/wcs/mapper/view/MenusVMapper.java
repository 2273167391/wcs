package com.zhanhong.wcs.mapper.view;

import com.zhanhong.wcs.view.sys.WcsSysMenusV;

public interface MenusVMapper {
	
	/**
	 * 根据菜单ID获取菜单信息
	 * @param menuId
	 * @return
	 */
	public WcsSysMenusV queryMenusVById(int menuId);
}
