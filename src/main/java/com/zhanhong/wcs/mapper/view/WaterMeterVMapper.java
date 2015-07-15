package com.zhanhong.wcs.mapper.view;

import java.util.List;
import com.zhanhong.wcs.view.use.WcsUseWaterMeterV;

public interface WaterMeterVMapper {
	public List<WcsUseWaterMeterV> queryWaterMeter(WcsUseWaterMeterV waterMeterV);
	public List<WcsUseWaterMeterV> queryMeterByUserId(int userId);
	/**
	 * 根据换表编码查询水表
	 * @param changeMeterCode
	 * @return
	 */
	public WcsUseWaterMeterV queryChargeMeter(String changeMeterCode);
	/**
	 * 根据水表ID查询用户水表
	 * @param waterMeterId
	 * @return
	 */
	public WcsUseWaterMeterV queryWaterMeterById(int waterMeterId);
	
	/**
	 * 获取未安装的水表
	 * @return
	 */
	public List<WcsUseWaterMeterV> queryNotInstallWaterMeter();
}
