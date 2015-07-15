package com.zhanhong.wcs.test.user;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhanhong.wcs.entity.use.WcsUseUser;
import com.zhanhong.wcs.service.UserService;
import com.zhanhong.wcs.test.basic.BasicTest;

public class UserTest extends BasicTest{
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testAddUser(){
		WcsUseUser user=new WcsUseUser();
		user.setUserName("张三");
		user.setMobileTelephone("110");
		user.setStatus("W005001");
		user.setUserType("W006001");
		user.setIdCard("555");
		user.setStreetId(1);
		user.setVersion(1);
		user.setCreationBy(1);
		user.setCreationDate(new Date());
		System.out.println(userService.addUser(user));
	}
	
	@Test
	public void testUpdateUser(){
		WcsUseUser user=userService.queryUserByName("USE0003");
		user.setUserName("李四");
		user.setRemarks("黑户");
		user.setLastUpdateBy(1);
		user.setLastUpdateDate(new Date());
		System.out.println(userService.updateUser(user));
	}
}
