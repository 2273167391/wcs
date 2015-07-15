package com.zhanhong.wcs.view.sys;

import org.apache.ibatis.type.Alias;

@Alias("menusV")
public class WcsSysMenusV {
	private Integer menuId=0;//菜单ID
	private String menuName;//菜单名称
	private Integer menuParentId=0;//父级菜单ID
	private String menuParentName;//父级菜单
	private String menuUrl;//URL
	private Integer menuLevel=0;//级别
	private String remarks;//备注
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public Integer getMenuParentId() {
		return menuParentId;
	}
	public void setMenuParentId(Integer menuParentId) {
		this.menuParentId = menuParentId;
	}
	public String getMenuParentName() {
		return menuParentName;
	}
	public void setMenuParentName(String menuParentName) {
		this.menuParentName = menuParentName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public Integer getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
