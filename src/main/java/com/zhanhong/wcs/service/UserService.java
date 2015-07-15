package com.zhanhong.wcs.service;

import java.util.List;

import com.zhanhong.wcs.entity.use.WcsUseUser;
import com.zhanhong.wcs.view.use.WcsUseUserV;

public interface UserService {
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public String addUser(WcsUseUser user);
	
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	public String updateUser(WcsUseUser user);
	
	/**
	 * 根据用户名或编码查询用户
	 * @param userName
	 * @return
	 */
	public WcsUseUser queryUserByName(String user);
	
	/**
	 * 获取所有用户
	 * @param userV
	 * @return
	 */
	public List<WcsUseUserV> queryUserAll(WcsUseUserV userV);
	
	/**
	 * 根据用户ID获取用户
	 * @param userId
	 * @return
	 */
	public WcsUseUser queryUserById(int userId);
	
	/**
	 * 删除用户
	 * @param userId
	 * @return
	 */
	public String deleteUser(int userId);
}
