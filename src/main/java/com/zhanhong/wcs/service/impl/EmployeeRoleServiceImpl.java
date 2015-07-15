package com.zhanhong.wcs.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhanhong.wcs.mapper.EmployeeRoleMapper;
import com.zhanhong.wcs.service.EmployeeRoleService;
import com.zhanhong.wcs.tools.JsonMessageUtil;

@Service
public class EmployeeRoleServiceImpl implements EmployeeRoleService{
	
	@Autowired
	private EmployeeRoleMapper employeeRoleMapper;
	@Override
	public String addEmployeeRole(int empId,int roleId) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("empId", empId);
		map.put("roleId", roleId);
		return employeeRoleMapper.addEmployeeRole(map)>0?JsonMessageUtil.successMessage("添加成功！"):JsonMessageUtil.errorMessaage("添加失败！");
	}

	@Override
	public String deleteEmployeeRole(int empId,int roleId) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("empId", empId);
		map.put("roleId", roleId);
		return employeeRoleMapper.deleteEmployeeRole(map)>0?JsonMessageUtil.successMessage("解除成功！"):JsonMessageUtil.errorMessaage("解除失败！");
	}

}
