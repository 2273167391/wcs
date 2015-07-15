package com.zhanhong.wcs.mapper.view;

import java.util.List;
import java.util.Map;

import com.zhanhong.wcs.view.sys.WcsSysWaterPriceV;

public interface WaterPriceVMapper {
	public List<WcsSysWaterPriceV> queryWaterPriceV(WcsSysWaterPriceV waterPrice);
	public WcsSysWaterPriceV queryWaterPriceVByPrice(Map<String, Object> map);
}
