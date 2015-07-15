package com.zhanhong.wcs.entity.sys;

import org.apache.ibatis.type.Alias;

import com.zhanhong.wcs.entity.base.BaseWcs;

/**
 * 职员角色关系表
 * @author Arvin_Li
 *
 */
@Alias(value="employeeRole")
public class WcsSysEmployeeRole extends BaseWcs{
	private Integer erId;//关系ID
	private Integer empId;//职员ID
	private Integer roleId;//角色ID
	public WcsSysEmployeeRole() {
		super();
	}
	public Integer getErId() {
		return erId;
	}
	public void setErId(Integer erId) {
		this.erId = erId;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	
}
