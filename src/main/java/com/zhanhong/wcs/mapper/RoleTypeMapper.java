package com.zhanhong.wcs.mapper;

import java.util.List;

import com.zhanhong.wcs.entity.sys.WcsSysRoleType;

/**
 * 角色类型
 * @author Arvin_Li
 *
 */
public interface RoleTypeMapper {
	/**
	 * 添加角色类型
	 * @param roleType
	 * @return
	 */
	public int addRoleType(WcsSysRoleType roleType);
	
	/**
	 * 修改角色类型
	 * @param roleType
	 * @return
	 */
	public int updateRoleType(WcsSysRoleType roleType);
	
	/**
	 * 删除角色类型
	 * @param roleTypeId
	 * @return
	 */
	public int deleteRoleType(int roleTypeId);
	
	/**
	 * 根据角色类型名查询角色类型
	 * @param typeName
	 * @return
	 */
	public WcsSysRoleType queryRoleTypeByName(String roleType);
	/**
	 * 根据角色类型ID获取角色类型
	 * @param typeId
	 * @return
	 */
	public WcsSysRoleType queryRoleTypeById(int typeId);
	
	/**
	 * 获取所有角色类型
	 * @return
	 */
	public List<WcsSysRoleType> queryRoleTypeAll();
}
