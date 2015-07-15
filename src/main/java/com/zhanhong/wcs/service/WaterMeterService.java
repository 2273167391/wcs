package com.zhanhong.wcs.service;

import java.util.List;

import com.zhanhong.wcs.entity.use.WcsUseWaterMeter;
import com.zhanhong.wcs.view.use.WcsUseWaterMeterV;

public interface WaterMeterService {
	/**
	 * 添加用户水表
	 * @param waterMeter
	 * @return
	 */
	public String addWaterMeter(WcsUseWaterMeter waterMeter);
	
	/**
	 * 修改用户水表
	 * @param waterMeter
	 * @return
	 */
	public String updateWaterMeter(WcsUseWaterMeter waterMeter);
	
	/**
	 * 删除用户水表
	 * @param waterMeterId
	 * @return
	 */
	public String deleteWaterMeter(int waterMeterId);
	
	/**
	 * 根据编码查询用户水表
	 * @param waterMeterCode
	 * @return
	 */
	public WcsUseWaterMeter queryWaterMeterByCode(String waterMeterCode);
	
	public List<WcsUseWaterMeterV> queryWaterMeter(WcsUseWaterMeterV waterMeterV);
	
	public List<WcsUseWaterMeterV> queryMeterByUserId(int userId);
	
	/**
	 * 获取未安装的水表
	 * @return
	 */
	public List<WcsUseWaterMeterV> queryNotInstallWaterMeter();
	
	
}
