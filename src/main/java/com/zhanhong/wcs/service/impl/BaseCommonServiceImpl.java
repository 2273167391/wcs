package com.zhanhong.wcs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhanhong.wcs.mapper.BaseCommonMapper;
import com.zhanhong.wcs.service.BaseCommonService;
@Service
public class BaseCommonServiceImpl implements BaseCommonService{

	@Autowired
	private BaseCommonMapper baseCommonMapper;
	
	public String getEmployeeCode() {
		return baseCommonMapper.getEmployeeCode();
	}

	public List<Map<String, String>> queryWordBookByCode(String type) {
		return baseCommonMapper.queryWordBookByCode(type);
	}

	@Override
	public String getUserCode() {
		return baseCommonMapper.getUserCode();
	}

	@Override
	public String getWaterMeterCode() {
		return baseCommonMapper.getEmployeeCode();
	}

	@Override
	public String getRoleTypeCode() {
		return baseCommonMapper.getRoleTypeCode();
	}
}
