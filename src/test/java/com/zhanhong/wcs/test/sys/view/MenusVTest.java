package com.zhanhong.wcs.test.sys.view;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhanhong.wcs.mapper.view.MenusVMapper;
import com.zhanhong.wcs.service.MenusService;
import com.zhanhong.wcs.test.basic.BasicTest;
import com.zhanhong.wcs.view.sys.WcsSysMenusV;

public class MenusVTest extends BasicTest{
	
	@Autowired
	private MenusService menusService;
	
	@Test
	public void queryMenusVById(){
		WcsSysMenusV menusV=menusService.queryMenusVById(2);
		System.out.println(menusV.getMenuName());
	}
}
