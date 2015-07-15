package com.zhanhong.wcs.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhanhong.wcs.context.BaseCommon;
import com.zhanhong.wcs.entity.sys.WcsSysWaterPrice;
import com.zhanhong.wcs.mapper.WaterPriceMapper;
import com.zhanhong.wcs.mapper.view.WaterPriceVMapper;
import com.zhanhong.wcs.service.WaterPriceService;
import com.zhanhong.wcs.tools.JsonMessageUtil;
import com.zhanhong.wcs.view.sys.WcsSysWaterPriceV;

@Service
public class WaterPriceServiceImpl extends BaseCommon implements WaterPriceService{
	
	@Autowired
	private WaterPriceMapper waterPriceMapper;
	@Autowired
	private WaterPriceVMapper waterPriceVMapper;
	@Override
	public String addWaterPrice(WcsSysWaterPrice waterPrice) {
		//判断阶梯起量与阶梯止量是否相等
		if(waterPrice.getLadderStartMeasure()>=waterPrice.getLadderEndMeasure()){
			return JsonMessageUtil.errorMessaage("阶梯起量不能大于等于阶梯止量，保存失败！");
		}
		
		//判断水价是否存在
		if(waterPriceMapper.isJudgePrice(waterPrice)>0){
			return JsonMessageUtil.errorMessaage("水费价格记录已存在，保存失败！");
		}
		this.copyBean(waterPrice, true);
		return waterPriceMapper.addWaterPrice(waterPrice)>0?JsonMessageUtil.successMessage("保存成功！"):JsonMessageUtil.errorMessaage("保存失败！");
	}

	@Override
	public String updateWaterPrice(WcsSysWaterPrice waterPrice) {
		//判断阶梯起量与阶梯止量是否相等
		if(waterPrice.getLadderStartMeasure()>=waterPrice.getLadderEndMeasure()){
			return JsonMessageUtil.errorMessaage("阶梯起量不能大于等于阶梯止量，保存失败！");
		}
		//判断水价是否存在
		if(waterPriceMapper.isJudgePrice(waterPrice)>0){
			return JsonMessageUtil.errorMessaage("水费价格记录已存在，保存失败！");
		}
		this.copyBean(waterPrice, false);
		return waterPriceMapper.updateWaterPrice(waterPrice)>0?JsonMessageUtil.successMessage("保存成功！"):JsonMessageUtil.errorMessaage("保存失败！");
	}

	@Override
	public String deleteWaterPrice(int wpId) {
		return waterPriceMapper.deleteWaterPrice(wpId)>0?JsonMessageUtil.successMessage("删除成功！"):JsonMessageUtil.errorMessaage("删除失败！");
	}


	@Override
	public List<WcsSysWaterPriceV> queryWaterPrice(WcsSysWaterPriceV waterPrice) {
		return waterPriceVMapper.queryWaterPriceV(waterPrice);
	}

	@Override
	public WcsSysWaterPriceV queryWaterPriceVByPrice(String priceType,
			Double definiteNumber) {
		//创建Map
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("priceType", priceType);
		map.put("definiteNumber", definiteNumber);
		return waterPriceVMapper.queryWaterPriceVByPrice(map);
	}

}
