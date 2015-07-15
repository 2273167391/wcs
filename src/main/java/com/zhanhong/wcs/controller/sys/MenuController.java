package com.zhanhong.wcs.controller.sys;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhanhong.wcs.entity.sys.WcsSysMenus;
import com.zhanhong.wcs.service.MenusService;
import com.zhanhong.wcs.tools.JsonMenuUtil;
import com.zhanhong.wcs.view.sys.WcsSysMenusV;

/**
 * 菜单控制器
 * @author Arvin_Li
 *
 */
@Controller
@RequestMapping(value="/sys/menu")
public class MenuController {
	
	@Autowired
	private MenusService menusService;
	
	
	@RequestMapping(value="/all")
	@ResponseBody
	public String queryMenuList(){
		String menus=JsonMenuUtil.getJsonMenu(menusService.queryAllMenu());
		menus=menus.replace("name", "text");
		return menus.substring(menus.indexOf("["));
	}
	
	/**
	 * 保存菜单
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public String saveMenu(WcsSysMenus menus){
		//判断是修改还是添加
		if(0==menus.getMenuId()){
			return menusService.addMenus(menus);
		}else{
			return menusService.updateMenus(menus);
		}
	}
	
	/**
	 * 根据菜单ID获取菜单信息
	 * @param menuId
	 * @return
	 */
	@RequestMapping(value="/{menuId}")
	@ResponseBody
	public WcsSysMenusV getMenusVById(@PathVariable int menuId){
		return menusService.queryMenusVById(menuId);
	}
	
	/**
	 * 删除菜单
	 * @return
	 */
	@RequestMapping(value="/delete/{menuId}")
	@ResponseBody
	public String deleteMenu(@PathVariable int menuId){
		return menusService.deleteMenus(menuId);
	}
}
