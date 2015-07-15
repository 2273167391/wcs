package com.zhanhong.wcs.view.sys;

import org.apache.ibatis.type.Alias;

@Alias("roleV")
public class WcsSysRoleV {
	private Integer roleId=0;//角色ID
	private String roleName;//角色名称
	private Integer roleTypeId=0;//类型ID
	private String roleTypeCode;//类型编码
	private String roleTypeName;//类型名称
	private String description;//描述
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getRoleTypeId() {
		return roleTypeId;
	}
	public void setRoleTypeId(Integer roleTypeId) {
		this.roleTypeId = roleTypeId;
	}
	public String getRoleTypeCode() {
		return roleTypeCode;
	}
	public void setRoleTypeCode(String roleTypeCode) {
		this.roleTypeCode = roleTypeCode;
	}
	public String getRoleTypeName() {
		return roleTypeName;
	}
	public void setRoleTypeName(String roleTypeName) {
		this.roleTypeName = roleTypeName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
