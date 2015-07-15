package com.zhanhong.wcs.test.sys;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhanhong.wcs.service.EmployeeRoleService;
import com.zhanhong.wcs.test.basic.BasicTest;

public class EmployeeRoleTest extends BasicTest{
	
	@Autowired
	private EmployeeRoleService employeeRoleService;
	
	@Test
	public void testAddEmployeeRole(){
		System.out.println(employeeRoleService.addEmployeeRole(2, 1));
	}
	
	@Test
	public void testDeleteEmployeeRole(){
		//System.out.println(employeeRoleService.deleteEmployeeRole(1));
	}
}
