package com.zhanhong.wcs.test.sys;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhanhong.wcs.entity.sys.WcsSysEmployee;
import com.zhanhong.wcs.mapper.EmployeeMapper;
import com.zhanhong.wcs.service.EmployeeService;
import com.zhanhong.wcs.test.basic.BasicTest;
import com.zhanhong.wcs.tools.MD5;

public class EmployeeTest extends BasicTest{
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Test
	public void testAddEmployee(){
		//创建员工
		WcsSysEmployee employee=new WcsSysEmployee();
		employee.setAccount("admin");
		employee.setTrueName("周成立");
		employee.setPassword(MD5.getPwdCode("admin", "admin"));
		employee.setSex("1");
		employee.setCreationBy(0);
		System.out.println(employeeService.addEmployee(employee));
	}
	
	@Test
	public void testQueryEmployeeByAccount(){
		WcsSysEmployee employee=employeeService.queryEmployeeByAccount("admin");
		System.out.println(employee);
	}
	
	@Test
	public void testUpdateEmployee(){
		WcsSysEmployee employee=employeeService.queryEmployeeByAccount("admin");
		employee.setPassword(MD5.getPwdCode(employee.getAccount(), "admin"));
		employee.setPasswordChangeDate(new Date());
		employee.setLastUpdateBy(employee.getEmpId());
		System.out.println(employeeService.updateEmployee(employee));
	}
	@Test
	public void test(){
		List<WcsSysEmployee> list=employeeMapper.queryNotRoleEmpByRoleId(1);
		System.out.println(list.size());
	}

}
