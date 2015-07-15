package com.zhanhong.wcs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhanhong.wcs.context.BaseCommon;
import com.zhanhong.wcs.entity.sys.WcsSysStreet;
import com.zhanhong.wcs.mapper.BaseCommonMapper;
import com.zhanhong.wcs.mapper.StreetMapper;
import com.zhanhong.wcs.service.StreetService;
import com.zhanhong.wcs.tools.JsonMessageUtil;
import com.zhanhong.wcs.tools.StringUtil;

@Service
public class StreetServiceImpl extends BaseCommon implements StreetService{
	
	@Autowired
	private StreetMapper streetMapper;
	
	@Autowired
	private BaseCommonMapper baseCommonMapper;

	@Override
	public String addStreet(WcsSysStreet street) {
		street.setStreetCode(baseCommonMapper.getStreetCode());
		//根据名称获取街道
		WcsSysStreet oldStreet=streetMapper.queryStreetByName(street.getStreetName());
		if(null!=oldStreet){
			return JsonMessageUtil.errorMessaage("街道【"+street.getStreetName()+"】已存在，保存失败！");
		}
		this.copyBean(street, true);
		return streetMapper.addStreet(street)>0?JsonMessageUtil.successMessage("保存成功！"):JsonMessageUtil.errorMessaage("保存失败！");
	}

	@Override
	public String updateStreet(WcsSysStreet street) {
		//根据名称获取街道
		WcsSysStreet oldStreet=streetMapper.queryStreetByName(street.getStreetName());
		if(null!=oldStreet){
			return JsonMessageUtil.errorMessaage("街道【"+street.getStreetName()+"】已存在，保存失败！");
		}
		this.copyBean(street, false);
		return streetMapper.updateStreet(street)>0?JsonMessageUtil.successMessage("保存成功！"):JsonMessageUtil.errorMessaage("保存失败！");
	}

	@Override
	public String deleteStreet(int streetId) {
		return streetMapper.deleteStreet(streetId)>0?JsonMessageUtil.successMessage("删除成功！"):JsonMessageUtil.errorMessaage("删除失败！");
	}

	@Override
	public WcsSysStreet queryStreetByName(String streetName) {
		return streetMapper.queryStreetByName(streetName);
	}

	@Override
	public List<WcsSysStreet> queryStreetAll(WcsSysStreet street) {
		if(StringUtil.isEmpty(street.getStreetCode())){
			street.setStreetCode("upper(%"+street.getStreetCode()+"%)");
		}
		
		if(StringUtil.isEmpty(street.getStreetName())){
			street.setStreetName("upper(%"+street.getStreetName()+"%)");
		}
		return streetMapper.queryStreetAll(street);
	}

}
