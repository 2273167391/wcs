package com.zhanhong.wcs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhanhong.wcs.context.BaseCommon;
import com.zhanhong.wcs.entity.sys.WcsSysMenus;
import com.zhanhong.wcs.mapper.MenusMapper;
import com.zhanhong.wcs.mapper.view.MenusVMapper;
import com.zhanhong.wcs.service.MenusService;
import com.zhanhong.wcs.tools.JsonMessageUtil;
import com.zhanhong.wcs.view.sys.WcsSysMenusV;

/**
 * 菜单服务实现类
 * @author Arvin_Li
 *
 */
@Service
public class MenusServiceImpl extends BaseCommon implements MenusService{
	
	@Autowired
	private MenusMapper menusMapper;
	
	@Autowired
	private MenusVMapper menusVMapper;

	@Override
	public String addMenus(WcsSysMenus menus) {
		WcsSysMenusV menusV=menusVMapper.queryMenusVById(menus.getMenuParentId());
		if(null!=menusV){
			menus.setMenuLevel(menusV.getMenuLevel()+1);
		}
		//判断菜单是否存在
		WcsSysMenus oldMenus=menusMapper.queryMenuByName(menus.getMenuName());
		if(null!=oldMenus){
			return JsonMessageUtil.errorMessaage("菜单【"+menus.getMenuName()+"】已存在，保存失败！");
		}
		this.copyBean(menus, true);
		return menusMapper.addMenus(menus)>0?JsonMessageUtil.successMessage("保存成功！"):JsonMessageUtil.errorMessaage("保存失败！");
	}

	@Override
	public String updateMenus(WcsSysMenus menus) {
		this.copyBean(menus, false);
		return menusMapper.updateMenus(menus)>0?JsonMessageUtil.successMessage("保存成功！"):JsonMessageUtil.errorMessaage("保存失败！");
	}

	@Override
	public String deleteMenus(int menuId) {
		//根据上级菜单ID查询菜单
		List<WcsSysMenus> menusList=menusMapper.queryMenuByParentId(menuId);
		if(menusList.size()>0){
			return JsonMessageUtil.errorMessaage("该菜单存在子菜单，删除失败！");
		}
		return menusMapper.deleteMenus(menuId)>0?JsonMessageUtil.successMessage("删除成功！"):JsonMessageUtil.errorMessaage("删除失败！");
	}

	@Override
	public List<WcsSysMenus> queryMenuByRoleId(int roleId) {
		return menusMapper.queryMenuByRoleId(roleId);
	}

	@Override
	public List<WcsSysMenus> queryAllMenu() {
		return menusMapper.queryAllMenu();
	}

	@Override
	public WcsSysMenusV queryMenusVById(int menuId) {
		return menusVMapper.queryMenusVById(menuId);
	}

}
