package com.zhanhong.wcs.mapper;

import java.util.Map;

public interface EmployeeRoleMapper {
	/**
	 * 添加职员角色关系
	 * @param map
	 * @return
	 */
	public int addEmployeeRole(Map<String, Object> map);
	
	/**
	 * 删除职员角色关系
	 * @param empId
	 * @return
	 */
	public int deleteEmployeeRole(Map<String, Object> map);
	
	/**
	 * 根据职员ID查询是否有角色关联
	 * @param empId
	 * @return
	 */
	public int queryEmpRoleByEmpId(int empId);
	
}
