package com.zhanhong.wcs.entity.sys;

import org.apache.ibatis.type.Alias;

import com.zhanhong.wcs.entity.base.BaseWcs;

/**
 * 菜单角色实体类
 * @author Arvin_Li
 *
 */
@Alias(value="menuRole")
public class WcsSysMenuRole extends BaseWcs{
	private Integer mrId;//关系ID
	private Integer menuId;//菜单ID
	private Integer roleId;//角色ID
	public WcsSysMenuRole() {
		super();
	}
	public Integer getMrId() {
		return mrId;
	}
	public void setMrId(Integer mrId) {
		this.mrId = mrId;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
}
