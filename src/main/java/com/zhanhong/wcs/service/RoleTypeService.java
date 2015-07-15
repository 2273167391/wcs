package com.zhanhong.wcs.service;

import java.util.List;

import com.zhanhong.wcs.entity.sys.WcsSysRoleType;

/**
 * 角色类型服务接口
 * @author Arvin_Li
 *
 */
public interface RoleTypeService {
	/**
	 * 添加角色类型
	 * @param roleType
	 * @return
	 */
	public String addRoleType(WcsSysRoleType roleType);
	
	/**
	 * 修改角色类型
	 * @param roleType
	 * @return
	 */
	public String updateRoleType(WcsSysRoleType roleType);
	
	/**
	 * 删除角色类型
	 * @param roleTypeId
	 * @return
	 */
	public String deleteRoleType(int roleTypeId);
	
	/**
	 * 根据角色类型ID查询角色类型
	 * @param typeName
	 * @return
	 */
	public WcsSysRoleType queryRoleTypeById(int typeId);
	
	/**
	 * 获取所有角色类型
	 * @return
	 */
	public List<WcsSysRoleType> queryRoleTypeAll();
}
