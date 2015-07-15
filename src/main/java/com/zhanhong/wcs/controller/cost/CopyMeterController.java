package com.zhanhong.wcs.controller.cost;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhanhong.wcs.entity.cost.WcsCostCopyMeter;
import com.zhanhong.wcs.service.CopyMeterService;
import com.zhanhong.wcs.service.WaterPriceService;
import com.zhanhong.wcs.tools.JsonMessageUtil;
import com.zhanhong.wcs.view.cost.WcsCostCopyMeterV;
import com.zhanhong.wcs.view.sys.WcsSysWaterPriceV;

@Controller
@RequestMapping(value="/cost/meter")
public class CopyMeterController {
	
	@Autowired
	private CopyMeterService copyMeterService;
	@Autowired
	private WaterPriceService waterPriceService;
	
	@RequestMapping(value="/all")
	@ResponseBody
	public List<WcsCostCopyMeterV> queryCopyMeterAll(WcsCostCopyMeterV copyMeterV){
		return copyMeterService.queryCopyMeterAll(copyMeterV);
	}
	
	@RequestMapping(value="/save")
	@ResponseBody
	public String saveCopyMeter(WcsCostCopyMeter copyMeter,String waterPriceType){
		//获取水费价格
		WcsSysWaterPriceV waterPriceV=waterPriceService.queryWaterPriceVByPrice(waterPriceType, copyMeter.getDefiniteNumber());
		if(null==waterPriceV){
			return JsonMessageUtil.errorMessaage("选择的水价类别不存在水价，请先添加水费价格！");
		}
		copyMeter.setWpId(waterPriceV.getWpId());
		return copyMeterService.addCopyMeter(copyMeter);
	}
	
	/**
	 * 获取上个月的止数
	 * @param waterMeterId
	 * @param waterMeterCode
	 * @return
	 */
	@RequestMapping(value="/month_number/{waterMeterId}/{waterMeterCode}")
	@ResponseBody
	public Double getUpMonthNumber(@PathVariable int waterMeterId,@PathVariable String waterMeterCode){
		return copyMeterService.getUpMonthNumber(waterMeterId, waterMeterCode);
	}
	
	/**
	 * 删除抄表记录
	 * @param copyMeterId
	 * @return
	 */
	@RequestMapping(value="/delete/{copyMeterId}")
	@ResponseBody
	public String deleteCopyMeter(@PathVariable int copyMeterId){
		return copyMeterService.deleteCopyMeter(copyMeterId);
	}
}
