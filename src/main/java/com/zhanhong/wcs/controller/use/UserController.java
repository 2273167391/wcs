package com.zhanhong.wcs.controller.use;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhanhong.wcs.entity.use.WcsUseUser;
import com.zhanhong.wcs.service.UserService;
import com.zhanhong.wcs.view.use.WcsUseUserV;

/**
 * 用户控制器
 */
@Controller
@RequestMapping(value="/use/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 获取用户
	 * @param userV
	 * @return
	 */
	@RequestMapping(value="/all")
	@ResponseBody
	public List<WcsUseUserV> queryUserAll(WcsUseUserV userV){
		return userService.queryUserAll(userV);
	}
	
	/**
	 * 保存用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public String saveUser(WcsUseUser user){
		if(null==user.getUserId()){
			return userService.addUser(user);
		}else{
			return userService.updateUser(user);
		}
	}
	
	@RequestMapping(value="/get/{userId}")
	@ResponseBody
	public WcsUseUser queryUserById(@PathVariable int userId){
		return userService.queryUserById(userId);
	}
	
	@RequestMapping(value="/delete/{userId}")
	@ResponseBody
	public String deleteUser(@PathVariable int userId){
		return userService.deleteUser(userId);
	}
}
