package com.zhanhong.wcs.service;

public interface EmployeeRoleService {
	/**
	 * 添加职员角色关系
	 * @param map
	 * @return
	 */
	public String addEmployeeRole(int empId,int roleId);
	
	/**
	 * 删除职员角色关系
	 * @param empId
	 * @return
	 */
	public String deleteEmployeeRole(int empId,int roleId);
}
