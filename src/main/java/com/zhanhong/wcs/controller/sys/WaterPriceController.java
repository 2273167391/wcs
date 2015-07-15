package com.zhanhong.wcs.controller.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhanhong.wcs.entity.sys.WcsSysWaterPrice;
import com.zhanhong.wcs.service.WaterPriceService;
import com.zhanhong.wcs.view.sys.WcsSysWaterPriceV;

/**
 * 水费价格控制器
 * @author Arvin_Li
 *
 */
@Controller
@RequestMapping(value="/sys/price")
public class WaterPriceController {
	
	@Autowired
	private WaterPriceService waterPriceService;
	
	/**
	 * 获取水价
	 * @param waterPrice
	 * @return
	 */
	@RequestMapping(value="/all")
	@ResponseBody
	public List<WcsSysWaterPriceV> queryWaterPrice(WcsSysWaterPriceV waterPrice){
		return waterPriceService.queryWaterPrice(waterPrice);
	}
	
	/**
	 * 保存水价
	 * @param price
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public String savePrice(WcsSysWaterPrice price){
		if(null==price.getWpId()){
			return waterPriceService.addWaterPrice(price);
		}
		return waterPriceService.updateWaterPrice(price);
	}
	
	/**
	 * 删除水价
	 * @param wpId
	 * @return
	 */
	@RequestMapping(value="/delete/{wpId}")
	@ResponseBody
	public String deletePrice(@PathVariable int wpId){
		return waterPriceService.deleteWaterPrice(wpId);
	}
	
}
