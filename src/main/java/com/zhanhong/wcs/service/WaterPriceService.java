package com.zhanhong.wcs.service;

import java.util.List;

import com.zhanhong.wcs.entity.sys.WcsSysWaterPrice;
import com.zhanhong.wcs.view.sys.WcsSysWaterPriceV;

public interface WaterPriceService {
	/**
	 * 添加水价
	 * @param waterPrice
	 * @return
	 */
	public String addWaterPrice(WcsSysWaterPrice waterPrice);
	
	/**
	 * 修改水价
	 * @param waterPrice
	 * @return
	 */
	public String updateWaterPrice(WcsSysWaterPrice waterPrice);
	
	/**
	 * 删除水价
	 * @param wpId
	 * @return
	 */
	public String deleteWaterPrice(int wpId);
	
	public List<WcsSysWaterPriceV> queryWaterPrice(WcsSysWaterPriceV waterPrice);
	
	/**
	 * 根据水价类型和用水量获取水价
	 * @param priceType
	 * @param price
	 * @return
	 */
	public WcsSysWaterPriceV queryWaterPriceVByPrice(String priceType,Double definiteNumber);
}
