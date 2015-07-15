package com.zhanhong.wcs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhanhong.wcs.context.BaseCommon;
import com.zhanhong.wcs.entity.sys.WcsSysEmployee;
import com.zhanhong.wcs.entity.sys.WcsSysRole;
import com.zhanhong.wcs.mapper.EmployeeMapper;
import com.zhanhong.wcs.mapper.RoleMapper;
import com.zhanhong.wcs.mapper.view.RoleVMapper;
import com.zhanhong.wcs.service.RoleService;
import com.zhanhong.wcs.tools.JsonMessageUtil;
import com.zhanhong.wcs.view.sys.WcsSysRoleV;

/**
 * 角色服务实现类
 * @author Arvin_Li
 *
 */
@Service
public class RoleServiceImpl extends BaseCommon implements RoleService{
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private RoleVMapper roleVMapper;
	
	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public String addRole(WcsSysRole role) {
		//获取角色->判断角色是否存在
		WcsSysRole oldRole=roleMapper.queryRoleByName(role.getRoleName());
		if(null!=oldRole){
			return JsonMessageUtil.errorMessaage("角色【"+role.getRoleName()+"】已存在，保存失败！");
		}
		this.copyBean(role, true);
		return roleMapper.addRole(role)>0?JsonMessageUtil.successMessage("保存成功！"):JsonMessageUtil.errorMessaage("保存失败！");
	}

	@Override
	public String updateRole(WcsSysRole role) {
		this.copyBean(role, false);
		return roleMapper.updateRole(role)>0?JsonMessageUtil.successMessage("保存成功！"):JsonMessageUtil.errorMessaage("保存失败！");
	}

	@Override
	public String deleteRole(int roleId) {
		//根据角色查询用户
		List<WcsSysEmployee> empList=employeeMapper.queryEmployeeByRole(roleId);
		//判断该角色下是否存在用户
		if(empList.size()>0){
			return JsonMessageUtil.errorMessaage("该角色有关联用户，请先解除关联用户再删除！");
		}
		return roleMapper.deleteRole(roleId)>0?JsonMessageUtil.successMessage("删除成功！"):JsonMessageUtil.errorMessaage("删除失败！");
	}

	@Override
	public List<WcsSysRole> queryRoleByEmpId(int empId) {
		return roleMapper.queryRoleByEmpId(empId);
	}

	@Override
	public WcsSysRole queryRoleById(int roleId) {
		return roleMapper.queryRoleById(roleId);
	}

	@Override
	public List<WcsSysRoleV> queryRoleList() {
		return roleVMapper.queryRoleVAll();
	}

	@Override
	public List<WcsSysRoleV> queryRoleByTypeId(int roleTypeId) {
		return roleVMapper.queryRoleByTypeId(roleTypeId);
	}

	@Override
	public String getRoleTypeById(int roleId) {
		return roleVMapper.getRoleTypeById(roleId);
	}

}
