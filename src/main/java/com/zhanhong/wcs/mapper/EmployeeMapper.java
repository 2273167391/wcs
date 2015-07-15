package com.zhanhong.wcs.mapper;

import java.util.List;
import java.util.Map;

import com.zhanhong.wcs.entity.sys.WcsSysEmployee;

public interface EmployeeMapper {
	/**
	 * 添加职员
	 * @param employee 职员对象
	 * @return
	 */
	public int addEmployee(WcsSysEmployee employee);
	
	/**
	 * 更新职员信息
	 * @param employee
	 * @return
	 */
	public int updateEmployee(WcsSysEmployee employee);
	
	/**
	 * 根据帐户名或编码查询信息
	 * @param user 帐户名或编码
	 * @return
	 */
	public WcsSysEmployee queryEmployeeByAccount(String user);
	
	/**
	 * 根据角色ID查询职员信息
	 * @param roleId
	 * @return
	 */
	public List<WcsSysEmployee> queryEmployeeByRole(int roleId);
	
	/**
	 * 获取未分配角色的职员信息
	 * @param roleId
	 * @return
	 */
	public List<WcsSysEmployee> queryNotRoleEmpByRoleId(int roleId);
	
	/**
	 * 根据角色类型获取职员信息
	 * @param roleType
	 * @return
	 */
	public List<WcsSysEmployee> queryEmployeeByRoleType(String roleType);
	
	/**
	 * 删除职员信息
	 * @param empId
	 * @return
	 */
	public int deleteEmployee(int empId);
	
	/**
	 * 修改密码
	 * @param map
	 * @return
	 */
	public int updateEmpPwd(Map<String, Object> map);
}
