package com.zhanhong.wcs.mapper;

import com.zhanhong.wcs.entity.use.WcsUseWaterMeter;

public interface WaterMeterMapper {
	/**
	 * 添加用户水表
	 * @param waterMeter
	 * @return
	 */
	public int addWaterMeter(WcsUseWaterMeter waterMeter);
	
	/**
	 * 删除用户水表
	 * @param waterMeterId
	 * @return
	 */
	public int deleteWaterMeter(int waterMeterId);
	
	/**
	 * 修改用户水表
	 * @param waterMeter
	 * @return
	 */
	public int updateWaterMeter(WcsUseWaterMeter waterMeter);
	/**
	 * 根据编码查询用户水表
	 * @param waterMeterCode
	 * @return
	 */
	public WcsUseWaterMeter queryWaterMeterByCode(String waterMeterCode);
	
	
}
