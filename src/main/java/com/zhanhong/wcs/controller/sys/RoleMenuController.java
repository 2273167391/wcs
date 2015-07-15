package com.zhanhong.wcs.controller.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhanhong.wcs.service.MenuRoleService;
import com.zhanhong.wcs.tools.JsonMessageUtil;

/**
 * 角色菜单控制器
 * @author Arvin_Li
 *
 */
@Controller
@RequestMapping(value="/sys/role_menu")
public class RoleMenuController {
	
	@Autowired
	private MenuRoleService menuRoleService;
	/**
	 * 根据角色ID获取菜单ID
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value="/{roleId}")
	@ResponseBody
	public String getMenuId(@PathVariable int roleId){
		return menuRoleService.getMenuId(roleId);
	}
	
	/**
	 * 保存菜单角色
	 * @param menuIds
	 * @return
	 */
	@RequestMapping(value="/save/{menuIds}/{roleId}")
	@ResponseBody
	public String saveRoleMenu(@PathVariable String menuIds,@PathVariable int roleId){
		try {
			menuRoleService.addMenuRole(menuIds, roleId);
			return JsonMessageUtil.successMessage("保存成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return JsonMessageUtil.errorMessaage("保存失败！");
		}
	}
}
