package com.zhanhong.wcs.test.sys;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhanhong.wcs.entity.sys.WcsSysEmployee;
import com.zhanhong.wcs.entity.sys.WcsSysStreet;
import com.zhanhong.wcs.service.EmployeeService;
import com.zhanhong.wcs.service.StreetService;
import com.zhanhong.wcs.test.basic.BasicTest;

public class StreetTest extends BasicTest{
	
	@Autowired
	private StreetService streetService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void testAddStreet(){
		WcsSysEmployee emp=employeeService.queryEmployeeByAccount("admin");
		WcsSysStreet street=new WcsSysStreet();
		street.setStreetName("跃进南路");
		street.setVersion(1);
		street.setCreationBy(emp.getEmpId());
		street.setCreationDate(new Date());
		System.out.println(streetService.addStreet(street));
	}
	
	@Test
	public void testUpdateStreet(){
		WcsSysStreet street=streetService.queryStreetByName("跃进南路");
		street.setStreetName("跃进南路1");
		street.setLastUpdateBy(1);
		street.setLastUpdateDate(new Date());
		System.out.println(streetService.updateStreet(street));
	}
	
	@Test
	public void testDeleteStreet(){
		System.out.println(streetService.deleteStreet(2));
	}
}
