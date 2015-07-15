package com.zhanhong.wcs.service;

import java.util.List;

import com.zhanhong.wcs.entity.sys.WcsSysRole;
import com.zhanhong.wcs.view.sys.WcsSysRoleV;
/**
 * 角色服务接口
 * @author Arvin_Li
 *
 */
public interface RoleService {
	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	public String addRole(WcsSysRole role);
	
	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	public String updateRole(WcsSysRole role);
	
	/**
	 * 删除角色Id
	 * @param roleId
	 * @return
	 */
	public String deleteRole(int roleId);
	
	/**
	 * 根据职业ID查询角色
	 * @param empId
	 * @return
	 */
	public List<WcsSysRole> queryRoleByEmpId(int empId);
	
	/**
	 * 根据角色ID获取角色
	 * @param roleId
	 * @return
	 */
	public WcsSysRole queryRoleById(int roleId);
	
	/**
	 * 获取所有角色
	 * @return
	 */
	public List<WcsSysRoleV> queryRoleList();
	
	/**
	 * 根据角色类型ID获取角色
	 * @param roleTypeId
	 * @return
	 */
	public List<WcsSysRoleV> queryRoleByTypeId(int roleTypeId);
	
	/**
	 * 根据角色ID获取角色类型编码
	 * @param roleId
	 * @return
	 */
	public String getRoleTypeById(int roleId);
}
