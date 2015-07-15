package com.zhanhong.wcs.mapper.view;

import java.util.List;

import com.zhanhong.wcs.view.sys.WcsSysRoleV;

public interface RoleVMapper {
	/**
	 * 获取所有角色
	 * @return
	 */
	public List<WcsSysRoleV> queryRoleVAll();
	
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
