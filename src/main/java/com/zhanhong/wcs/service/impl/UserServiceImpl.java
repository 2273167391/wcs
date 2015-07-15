package com.zhanhong.wcs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhanhong.wcs.context.BaseCommon;
import com.zhanhong.wcs.entity.use.WcsUseUser;
import com.zhanhong.wcs.entity.use.WcsUseWaterMeter;
import com.zhanhong.wcs.mapper.BaseCommonMapper;
import com.zhanhong.wcs.mapper.UserMapper;
import com.zhanhong.wcs.mapper.WaterMeterMapper;
import com.zhanhong.wcs.mapper.view.UserVMapper;
import com.zhanhong.wcs.mapper.view.WaterMeterVMapper;
import com.zhanhong.wcs.service.UserService;
import com.zhanhong.wcs.tools.JsonMessageUtil;
import com.zhanhong.wcs.tools.StringUtil;
import com.zhanhong.wcs.view.use.WcsUseUserV;
import com.zhanhong.wcs.view.use.WcsUseWaterMeterV;

@Service
public class UserServiceImpl extends BaseCommon implements UserService{
	
	@Autowired
	private BaseCommonMapper baseCommonMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserVMapper userVMapper;
	
	@Autowired
	private WaterMeterVMapper waterMeterVMapper;
	
	@Autowired
	private WaterMeterMapper waterMeterMapper;

	@Override
	public String addUser(WcsUseUser user) {
		//根据用户查询用户
		WcsUseUser oldUser=userMapper.queryUserByName(user.getUserName());
		if(null!=oldUser){
			return JsonMessageUtil.errorMessaage("用户【"+user.getUserName()+"】已存在，保存失败！");
		}
		user.setUserCode(baseCommonMapper.getUserCode());
		user.setStatus("W002001");
		this.copyBean(user, true);
		return userMapper.addUser(user)>0?JsonMessageUtil.successMessage("保存成功！"):JsonMessageUtil.errorMessaage("保存失败！");
	}

	@Override
	public String updateUser(WcsUseUser user) {
		this.copyBean(user, false);
		return userMapper.updateUser(user)>0?JsonMessageUtil.successMessage("保存成功！"):JsonMessageUtil.errorMessaage("保存失败！");
	}

	@Override
	public WcsUseUser queryUserByName(String userName) {
		return userMapper.queryUserByName(userName);
	}

	@Override
	public List<WcsUseUserV> queryUserAll(WcsUseUserV userV) {
		if(StringUtil.isEmpty(userV.getUserCode())){
			userV.setUserCode("%"+userV.getUserCode()+"%");
		}
		
		if(StringUtil.isEmpty(userV.getUserName())){
			userV.setUserName("%"+userV.getUserName()+"%");
		}
		return userVMapper.queryUserAll(userV);
	}

	@Override
	public WcsUseUser queryUserById(int userId) {
		return userMapper.queryUserById(userId);
	}

	@Override
	public String deleteUser(int userId) {
		//根据用户ID获取用户水表
		List<WcsUseWaterMeterV> waterMeterV=waterMeterVMapper.queryMeterByUserId(userId);
		//注销用户时将用户水表状态修改
		for (WcsUseWaterMeterV wcsUseWaterMeterV : waterMeterV) {
			WcsUseWaterMeter wcsUseWaterMeter=new WcsUseWaterMeter();
			//如果水表为使用中，则修改为停用
			if("W006002".equals(wcsUseWaterMeterV.getMeterStatusCode())){
				this.copyBean(wcsUseWaterMeterV, wcsUseWaterMeter, false);
				wcsUseWaterMeter.setMeterStatus("W006003");
				waterMeterMapper.updateWaterMeter(wcsUseWaterMeter);
			//如果为安装中，直接删除
			}else if("W006001".equals(wcsUseWaterMeterV.getMeterStatusCode())){
				waterMeterMapper.deleteWaterMeter(wcsUseWaterMeterV.getWaterMeterId());
			}
		}
		WcsUseUser user=queryUserById(userId);
		this.copyBean(user, false);
		return userMapper.deleteUser(userId)>0?JsonMessageUtil.successMessage("注销成功！"):JsonMessageUtil.errorMessaage("注销失败！");
	}

}
