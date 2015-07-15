package com.zhanhong.wcs.mapper;

import com.zhanhong.wcs.entity.use.WcsUseUser;

public interface UserMapper {
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public int addUser(WcsUseUser user);
	
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	public int updateUser(WcsUseUser user);
	
	/**
	 * 根据用户名或编码查询用户
	 * @param userName
	 * @return
	 */
	public WcsUseUser queryUserByName(String user);
	
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
	public int deleteUser(int userId);
}
