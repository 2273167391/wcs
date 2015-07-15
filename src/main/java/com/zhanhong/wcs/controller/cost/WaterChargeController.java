package com.zhanhong.wcs.controller.cost;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zhanhong.wcs.service.WaterChargeService;
import com.zhanhong.wcs.view.cost.WcsCostWaterChargeV;

@Controller
@RequestMapping(value="/cost/water_charge")
public class WaterChargeController {
	
	@Autowired
	private WaterChargeService waterChargeService;
	
	@RequestMapping(value="/all")
	@ResponseBody
	public List<WcsCostWaterChargeV> queryWaterCharge(WcsCostWaterChargeV waterChargeV){
		return waterChargeService.queryWaterChargeAll(waterChargeV);
	}
	
	@RequestMapping(value="/save")
	@ResponseBody
	public String waterCharge(WcsCostWaterChargeV waterChargeV){
		return waterChargeService.waterCharge(waterChargeV);
	}
	
	/**
	 * 获取未缴费记录
	 * @return
	 */
	@RequestMapping(value="/not_charge")
	@ResponseBody
	public List<WcsCostWaterChargeV> queryNotWaterCharge(){
		return waterChargeService.queryNotWaterCharge();
	}
}
