package com.zhanhong.wcs.controller.use;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhanhong.wcs.entity.use.WcsUseWaterMeter;
import com.zhanhong.wcs.service.WaterMeterService;
import com.zhanhong.wcs.view.use.WcsUseWaterMeterV;

@Controller
@RequestMapping(value="/use/water_mater")
public class WaterMeterController {
	
	@Autowired
	private WaterMeterService waterMeterService;
	
	@RequestMapping(value="/all")
	@ResponseBody
	public List<WcsUseWaterMeterV> queryWaterMeter(WcsUseWaterMeterV waterMeterV){
		return waterMeterService.queryWaterMeter(waterMeterV);
	}
	
	/**
	 * 获取使用中的水表
	 * @return
	 */
	@RequestMapping(value="/employ")
	@ResponseBody
	public List<WcsUseWaterMeterV> queryWaterMeter(){
		WcsUseWaterMeterV waterMeterV=new WcsUseWaterMeterV();
		waterMeterV.setMeterStatusCode("W006002");
		return waterMeterService.queryWaterMeter(waterMeterV);
	}
	
	@RequestMapping(value="/save")
	@ResponseBody
	public String saveWaterMeter(WcsUseWaterMeter waterMeter){
		if(null==waterMeter.getWaterMeterId()){
			return waterMeterService.addWaterMeter(waterMeter);
		}else{
			waterMeter.setMeterStatus("W006002");
			return waterMeterService.updateWaterMeter(waterMeter);
		}
	}
	
	/**
	 * 启用或停用水表
	 * @param waterMeterId
	 * @param meterStatus
	 * @return
	 */
	@RequestMapping(value="/{waterMeterCode}/{meterStatus}")
	@ResponseBody
	public String startOrEndMeter(@PathVariable String waterMeterCode,@PathVariable String meterStatus){
		WcsUseWaterMeter waterMeter=waterMeterService.queryWaterMeterByCode(waterMeterCode);
		waterMeter.setMeterStatus(meterStatus);
		return waterMeterService.updateWaterMeter(waterMeter);
	}
	
	@RequestMapping(value="/delete/{waterMeterId}")
	@ResponseBody
	public String deleteMeter(@PathVariable int waterMeterId){
		return waterMeterService.deleteWaterMeter(waterMeterId);
	}
	
	@RequestMapping(value="/{userId}")
	@ResponseBody
	public List<WcsUseWaterMeterV> queryMeterByUserId(@PathVariable int userId){
		return waterMeterService.queryMeterByUserId(userId);
	}
	
	/**
	 * 获取未安装的水表
	 * @return
	 */
	@RequestMapping(value="/not_install")
	@ResponseBody
	public List<WcsUseWaterMeterV> queryNotInstallWaterMeter(){
		return waterMeterService.queryNotInstallWaterMeter();
	}
	
}
