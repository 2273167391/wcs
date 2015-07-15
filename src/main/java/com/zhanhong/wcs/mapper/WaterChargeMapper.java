package com.zhanhong.wcs.mapper;

import com.zhanhong.wcs.entity.cost.WcsCostWaterCharge;

public interface WaterChargeMapper {
	/**
	 * 添加收费记录行
	 * @param waterCharge
	 * @return
	 */
	public int addWaterCharge(WcsCostWaterCharge waterCharge);
	
	/**
	 * 更新收费记录行
	 * @param waterCharge
	 * @return
	 */
	public int updateWaterCharge(WcsCostWaterCharge waterCharge);
	
	/**
	 * 删除收费记录行
	 * @param waterChargeId
	 * @return
	 */
	public int deleteWaterCharge(int waterChargeId);
	
	/**
	 * 根据抄表记录删除收费记录行
	 * @param copyMeterId
	 * @return
	 */
	public int deleteWaterChargeByCopyMeterID(int copyMeterId);
	
	/**
	 * 根据收费编码查询收费记录
	 * @param chargeCode
	 * @return
	 */
	public WcsCostWaterCharge queryWaterChargeByCode(String chargeCode);
}
