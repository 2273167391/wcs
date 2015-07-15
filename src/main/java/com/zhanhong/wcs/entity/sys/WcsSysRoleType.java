package com.zhanhong.wcs.entity.sys;
import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.zhanhong.wcs.entity.base.BaseWcs;

/**
 * 角色类型实体类
 * @author Arvin_Li
 *
 */
@Alias(value="roleType")
@JsonIgnoreProperties(value={"version"})
@JsonSerialize(include=Inclusion.NON_NULL)
public class WcsSysRoleType extends BaseWcs{
	private Integer roleTypeId;//角色类型ID
	private String roleTypeCode;//角色编码
	private String roleTypeName;//角色类型名称
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
	
	public WcsSysRoleType() {
		super();
	}
	
}
