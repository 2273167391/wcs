package com.zhanhong.wcs.mapper;

import java.util.List;
import com.zhanhong.wcs.entity.sys.WcsSysRole;

public interface RoleMapper {
	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	public int addRole(WcsSysRole role);
	
	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	public int updateRole(WcsSysRole role);
	
	/**
	 * 删除角色Id
	 * @param roleId
	 * @return
	 */
	public int deleteRole(int roleId);
	
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
	 * 根据角色名获取角色
	 * @param roleName
	 * @return
	 */
	public WcsSysRole queryRoleByName(String roleName);
	
	
	/**
	 * 获取所有角色
	 * @return
	 */
	public List<WcsSysRole> queryRoleList();
	
}
