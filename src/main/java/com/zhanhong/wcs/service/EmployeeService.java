package com.zhanhong.wcs.service;

import java.util.List;
import java.util.Map;

import com.zhanhong.wcs.entity.sys.WcsSysEmployee;
import com.zhanhong.wcs.view.sys.WcsSysEmployeeV;

/**
 * 职员服务接口
 * @author Arvin_Li
 *
 */
public interface EmployeeService {
	/**
	 * 添加职员信息
	 * @param employee
	 * @return
	 */
	public String addEmployee(WcsSysEmployee employee);
	/**
	 * 修改职员信息
	 * @param employee
	 * @return
	 */
	public String updateEmployee(WcsSysEmployee employee);
	
	/**
	 * 根据帐户名或编码查询信息
	 * @param user
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
	
	public List<WcsSysEmployeeV> queryEmployeeVAll(WcsSysEmployeeV employeeV);
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
	public String deleteEmployee(int empId);
	
	/**
	 * 修改密码
	 * @param map
	 * @return
	 */
	public String updateEmpPwd(Map<String, Object> map);
}
