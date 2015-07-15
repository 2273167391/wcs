package com.zhanhong.wcs.controller.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhanhong.wcs.context.ThreadContextHolder;
import com.zhanhong.wcs.entity.sys.WcsSysEmployee;
import com.zhanhong.wcs.entity.sys.WcsSysRole;
import com.zhanhong.wcs.service.EmployeeRoleService;
import com.zhanhong.wcs.service.EmployeeService;
import com.zhanhong.wcs.service.RoleService;
import com.zhanhong.wcs.tools.CommonParam;
import com.zhanhong.wcs.view.sys.WcsSysRoleV;

/**
 * 角色控制器
 * @author Arvin_Li
 *
 */

@Controller
@RequestMapping(value="/sys/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRoleService employeeRoleService;
	
	/**
	 * 查询所有角色
	 * @return
	 */
	
	@RequestMapping(value="/role_list")
	@ResponseBody
	public List<WcsSysRoleV> queryRoleList(){
		return roleService.queryRoleList();
	}
	
	/**
	 * 根据角色ID查询职员
	 * @return
	 */
	@RequestMapping(value="/employee/roleid/{roleId}")
	@ResponseBody
	public List<WcsSysEmployee> queryEmployeeByRoleId(@PathVariable("roleId") int roleId){
		return employeeService.queryEmployeeByRole(roleId);
	}
	
	/**
	 * 获取未分配角色的用户
	 * @return
	 */
	
	@RequestMapping(value="/not/emp/{roleId}")
	@ResponseBody
	public List<WcsSysEmployee> getNotRoleEmpByRoleId(@PathVariable int roleId){
		return employeeService.queryNotRoleEmpByRoleId(roleId);
	}
	
	/**
	 * 删除用户角色
	 * @param empId
	 * @return
	 */
	@RequestMapping(value="/remove/relation/{empId}/{roleId}")
	@ResponseBody
	public String removeEmpRoleRelation(@PathVariable int empId,@PathVariable int roleId){
		return employeeRoleService.deleteEmployeeRole(empId,roleId);
	}
	
	/**
	 * 添加用户角色
	 * @param empId
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value="/add/relation/{empId}/{roleId}")
	@ResponseBody
	public String addEmpRoleRelation(@PathVariable int empId,@PathVariable int roleId){
		return employeeRoleService.addEmployeeRole(empId, roleId);
	}
	
	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public String saveRole(WcsSysRole role){
		if(null==role.getRoleId()){
			return roleService.addRole(role);
		}
		return roleService.updateRole(role);
	}
	
	/**
	 * 删除角色
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value="/delete/{roleId}")
	@ResponseBody
	public String deleteRole(@PathVariable int roleId){
		return roleService.deleteRole(roleId);
	}
	
	/**
	 * 根据类型ID获取角色
	 * @param typeId
	 * @return
	 */
	@RequestMapping(value="/type/{typeId}")
	@ResponseBody
	public List<WcsSysRoleV> queryRoleVByTypeId(@PathVariable int typeId){
		return roleService.queryRoleByTypeId(typeId);
	}
	
	/**
	 * 获取当前角色类型
	 * @return
	 */
	@RequestMapping(value="/current/roletype")
	@ResponseBody
	public String getCurrentRoleType(){
		//获取当前登录用户角色
		WcsSysRole role=(WcsSysRole) ThreadContextHolder.getSessionContext().getAttribute(CommonParam.CURRENT_ROLE);
		return roleService.getRoleTypeById(role.getRoleId());
	}
}
