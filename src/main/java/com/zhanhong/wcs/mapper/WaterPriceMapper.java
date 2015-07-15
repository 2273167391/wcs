package com.zhanhong.wcs.mapper;

import com.zhanhong.wcs.entity.sys.WcsSysWaterPrice;

public interface WaterPriceMapper {
	/**
	 * 添加水价
	 * @param waterPrice
	 * @return
	 */
	public int addWaterPrice(WcsSysWaterPrice waterPrice);
	
	/**
	 * 修改水价
	 * @param waterPrice
	 * @return
	 */
	public int updateWaterPrice(WcsSysWaterPrice waterPrice);
	
	/**
	 * 删除水价
	 * @param wpId
	 * @return
	 */
	public int deleteWaterPrice(Integer wpId);
	
	/**
	 * 根据水价ID获取水价
	 * @param wpId
	 * @return
	 */
	public WcsSysWaterPrice queryWaterPriceById(Integer wpId);
	
	/**
	 * 获取水价记录数
	 * @param price
	 * @return
	 */
	public int isJudgePrice(WcsSysWaterPrice price);
}
