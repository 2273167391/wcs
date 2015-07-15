package com.zhanhong.wcs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhanhong.wcs.context.BaseCommon;
import com.zhanhong.wcs.entity.sys.WcsSysRoleType;
import com.zhanhong.wcs.mapper.BaseCommonMapper;
import com.zhanhong.wcs.mapper.RoleTypeMapper;
import com.zhanhong.wcs.mapper.view.RoleVMapper;
import com.zhanhong.wcs.service.RoleTypeService;
import com.zhanhong.wcs.tools.JsonMessageUtil;
import com.zhanhong.wcs.view.sys.WcsSysRoleV;

/**
 * 添加角色类型
 * @author Arvin_Li
 *
 */

@Service
public class RoleTypeServiceImpl extends BaseCommon implements RoleTypeService{
	
	@Autowired
	private RoleTypeMapper roleTypeMapper;
	@Autowired
	private BaseCommonMapper baseCommonMapper;
	
	@Autowired
	private RoleVMapper roleVMapper;

	@Override
	public String addRoleType(WcsSysRoleType roleType) {
		//判断角色类型是否存在
		WcsSysRoleType oldType=roleTypeMapper.queryRoleTypeByName(roleType.getRoleTypeName());
		if(null!=oldType){
			return JsonMessageUtil.errorMessaage("角色类型【"+roleType.getRoleTypeName()+"】已存在，保存失败！");
		}
		roleType.setRoleTypeCode(baseCommonMapper.getRoleTypeCode());
		this.copyBean(roleType, true);
		return roleTypeMapper.addRoleType(roleType)>0?JsonMessageUtil.successMessage("保存成功！"):JsonMessageUtil.errorMessaage("保存失败！");
	}

	@Override
	public String updateRoleType(WcsSysRoleType roleType) {
		//判断角色类型是否存在
		WcsSysRoleType oldType=roleTypeMapper.queryRoleTypeByName(roleType.getRoleTypeName());
		if(null!=oldType){
			return JsonMessageUtil.errorMessaage("角色类型【"+roleType.getRoleTypeName()+"】已存在，保存失败！");
		}
		this.copyBean(roleType, false);
		return roleTypeMapper.updateRoleType(roleType)>0?JsonMessageUtil.successMessage("保存成功！"):JsonMessageUtil.errorMessaage("保存失败！");
	}

	@Override
	public String deleteRoleType(int roleTypeId) {
		//获取该类型下是否存在角色
		List<WcsSysRoleV> list=roleVMapper.queryRoleByTypeId(roleTypeId);
		if(list.size()>0){
			return JsonMessageUtil.errorMessaage("该角色类型已经被角色使用，不能删除！");
		}
		return roleTypeMapper.deleteRoleType(roleTypeId)>0?JsonMessageUtil.successMessage("删除成功！"):JsonMessageUtil.errorMessaage("删除失败！");
	}

	@Override
	public List<WcsSysRoleType> queryRoleTypeAll() {
		return roleTypeMapper.queryRoleTypeAll();
	}

	@Override
	public WcsSysRoleType queryRoleTypeById(int typeId) {
		return roleTypeMapper.queryRoleTypeById(typeId);
	}

}
