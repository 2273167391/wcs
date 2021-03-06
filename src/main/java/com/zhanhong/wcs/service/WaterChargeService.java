package com.zhanhong.wcs.service;

import java.util.List;

import com.zhanhong.wcs.view.cost.WcsCostWaterChargeV;

public interface WaterChargeService {
	/**
	 * 获取收费记录
	 * @param waterChargeV
	 * @return
	 */
	public List<WcsCostWaterChargeV> queryWaterChargeAll(WcsCostWaterChargeV waterChargeV);
	
	/**
	 * 收费
	 * @param waterChargeV
	 * @return
	 */
	public String waterCharge(WcsCostWaterChargeV waterChargeV);
	
	/**
	 * 获取未缴费记录
	 * @return
	 */
	public List<WcsCostWaterChargeV> queryNotWaterCharge();
}
