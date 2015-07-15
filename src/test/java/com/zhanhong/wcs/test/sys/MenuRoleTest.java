package com.zhanhong.wcs.test.sys;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhanhong.wcs.service.MenuRoleService;
import com.zhanhong.wcs.test.basic.BasicTest;

public class MenuRoleTest extends BasicTest{
	
	@Autowired
	public MenuRoleService menuRoleService;
	
	@Test
	public void testAddMenuRole(){
		menuRoleService.addMenuRole("2,3,4,5,6,7,8,9,10,11,12,13,14", 1);
	}
}
