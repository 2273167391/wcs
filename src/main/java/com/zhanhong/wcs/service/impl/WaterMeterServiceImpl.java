package com.zhanhong.wcs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhanhong.wcs.context.BaseCommon;
import com.zhanhong.wcs.entity.use.WcsUseWaterMeter;
import com.zhanhong.wcs.mapper.WaterMeterMapper;
import com.zhanhong.wcs.mapper.view.WaterMeterVMapper;
import com.zhanhong.wcs.service.BaseCommonService;
import com.zhanhong.wcs.service.WaterMeterService;
import com.zhanhong.wcs.tools.JsonMessageUtil;
import com.zhanhong.wcs.tools.StringUtil;
import com.zhanhong.wcs.view.use.WcsUseWaterMeterV;

@Service
public class WaterMeterServiceImpl extends BaseCommon implements WaterMeterService{
	
	@Autowired
	private BaseCommonService baseCommonService;
	
	@Autowired
	private WaterMeterMapper waterMeterMapper;
	
	@Autowired
	private WaterMeterVMapper waterMeterVMapper;

	@Override
	public String addWaterMeter(WcsUseWaterMeter waterMeter) {
		//如果换表编码不为空
		if(StringUtil.isEmpty(waterMeter.getChangeMeterCode())){
			//查询换表编码是否已经换表
			WcsUseWaterMeterV changeMeter=waterMeterVMapper.queryChargeMeter(waterMeter.getChangeMeterCode());
			if(null!=changeMeter){
				return JsonMessageUtil.errorMessaage("水表编码【"+waterMeter.getChangeMeterCode()+"】已经是换表，保存失败！");
			}
			//根据编码查询水表是否存在
			WcsUseWaterMeter oldWaterMeter=waterMeterMapper.queryWaterMeterByCode(waterMeter.getChangeMeterCode());
			if(null==oldWaterMeter){
				return JsonMessageUtil.errorMessaage("需要换表的编码【"+waterMeter.getChangeMeterCode()+"】不存在，保存失败！");
			}
			oldWaterMeter.setMeterStatus("W006003");
			this.copyBean(oldWaterMeter, false);
			waterMeterMapper.updateWaterMeter(oldWaterMeter);
		}
		waterMeter.setWaterMeterCode(baseCommonService.getWaterMeterCode());//设置水表编码
		waterMeter.setMeterStatus("W006001");//默认为安装中
	    this.copyBean(waterMeter, true);
		return waterMeterMapper.addWaterMeter(waterMeter)>0?JsonMessageUtil.successMessage("保存成功！"):JsonMessageUtil.errorMessaage("保存失败！");
	}

	@Override
	public String updateWaterMeter(WcsUseWaterMeter waterMeter) {
		this.copyBean(waterMeter, false);
		return waterMeterMapper.updateWaterMeter(waterMeter)>0?JsonMessageUtil.successMessage("保存成功！"):JsonMessageUtil.errorMessaage("保存失败！");
	}

	@Override
	public String deleteWaterMeter(int waterMeterId) {
		return waterMeterMapper.deleteWaterMeter(waterMeterId)>0?JsonMessageUtil.successMessage("删除成功！"):JsonMessageUtil.errorMessaage("删除失败！");
	}

	@Override
	public WcsUseWaterMeter queryWaterMeterByCode(String waterMeterCode) {
		return waterMeterMapper.queryWaterMeterByCode(waterMeterCode);
	}

	@Override
	public List<WcsUseWaterMeterV> queryWaterMeter(WcsUseWaterMeterV waterMeterV) {
		return waterMeterVMapper.queryWaterMeter(waterMeterV);
	}

	@Override
	public List<WcsUseWaterMeterV> queryMeterByUserId(int userId) {
		return waterMeterVMapper.queryMeterByUserId(userId);
	}

	@Override
	public List<WcsUseWaterMeterV> queryNotInstallWaterMeter() {
		return waterMeterVMapper.queryNotInstallWaterMeter();
	}

}
