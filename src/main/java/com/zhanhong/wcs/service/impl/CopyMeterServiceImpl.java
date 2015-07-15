package com.zhanhong.wcs.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhanhong.wcs.context.BaseCommon;
import com.zhanhong.wcs.entity.cost.WcsCostCopyMeter;
import com.zhanhong.wcs.entity.cost.WcsCostWaterCharge;
import com.zhanhong.wcs.entity.sys.WcsSysWaterPrice;
import com.zhanhong.wcs.mapper.CopyMeterMapper;
import com.zhanhong.wcs.mapper.WaterChargeMapper;
import com.zhanhong.wcs.mapper.WaterPriceMapper;
import com.zhanhong.wcs.mapper.view.CopyMeterVMapper;
import com.zhanhong.wcs.mapper.view.WaterMeterVMapper;
import com.zhanhong.wcs.service.CopyMeterService;
import com.zhanhong.wcs.tools.JsonMessageUtil;
import com.zhanhong.wcs.tools.StringUtil;
import com.zhanhong.wcs.view.cost.WcsCostCopyMeterV;
import com.zhanhong.wcs.view.use.WcsUseWaterMeterV;

@Service
public class CopyMeterServiceImpl extends BaseCommon implements CopyMeterService{
	
	/**
	 * 水价操作接口
	 */
	@Autowired
	private WaterPriceMapper waterPriceMapper;
	
	
	@Autowired
	private CopyMeterVMapper copyMeterVMapper;
	@Autowired
	private WaterMeterVMapper waterMeterVMapper;
	
	/**
	 * 抄表操作接口
	 */
	@Autowired
	private CopyMeterMapper copyMeterMapper;
	
	/**
	 * 收费操作接口
	 */
	@Autowired
	private WaterChargeMapper waterChargeMapper;

	@Override
	public String addCopyMeter(WcsCostCopyMeter copyMeter) {
		//获取本月记录
		WcsCostCopyMeterV oldCopyMeterV=copyMeterVMapper.queryCopyMeterCurrentMonthByID(copyMeter.getWaterMeterId());
		if(null!=oldCopyMeterV){
			return JsonMessageUtil.errorMessaage("该水表本月记录已存在，不能重复保存！");
		}
		
		this.copyBean(copyMeter, true);
		copyMeter.setHandlerDate(new Date());
		//添加抄表记录
		copyMeterMapper.addCopyMeter(copyMeter);
		//查询水费价格
		WcsSysWaterPrice waterPrice=waterPriceMapper.queryWaterPriceById(copyMeter.getWpId());
		if(null==waterPrice){
			//删除抄表记录
			copyMeterMapper.deleteCopyMeter(copyMeter.getCopyMeterId());
			return JsonMessageUtil.errorMessaage("水费价格不存在，保存失败！");
		}
		//创建收费对象
		WcsCostWaterCharge waterCharge=new WcsCostWaterCharge();
		waterCharge.setChargeCode(StringUtil.getSearialNumber());//收费流水号
		waterCharge.setCopyMeterId(copyMeter.getCopyMeterId());//抄表ID
		waterCharge.setCurrentMonthMoney(copyMeter.getDefiniteNumber()*waterPrice.getPrice());//本月收费
		waterCharge.setChargeStatus("W008002");
		this.copyBean(waterCharge, true);
		//添加收费记录
		return waterChargeMapper.addWaterCharge(waterCharge)>0?JsonMessageUtil.successMessage("保存成功！"):JsonMessageUtil.errorMessaage("保存失败！");
	}

	@Override
	public String deleteCopyMeter(Integer copyMeterId) {
		//删除水费收费记录
		waterChargeMapper.deleteWaterChargeByCopyMeterID(copyMeterId);
		return copyMeterMapper.deleteCopyMeter(copyMeterId)>0?JsonMessageUtil.successMessage("删除成功！"):JsonMessageUtil.errorMessaage("删除失败！");
	}

	@Override
	public WcsCostCopyMeter queryCopyMeterById(Integer copyMeterId) {
		return copyMeterMapper.queryCopyMeterById(copyMeterId);
	}

	@Override
	public List<WcsCostCopyMeterV> queryCopyMeterAll(
			WcsCostCopyMeterV copyMeterV) {
		return copyMeterVMapper.queryCopyMeterAll(copyMeterV);
	}

	@Override
	public Double getUpMonthNumber(int waterMeterId, String waterMeterCode) {
		//获取上个月的抄表记录数
		WcsCostCopyMeterV copyMeterV=copyMeterVMapper.queryCopyMeterUpMonthsByID(waterMeterId);
		if(null!=copyMeterV){
			return copyMeterV.getEndNumber();
		}else{
			//根据水表ID查询水表信息
			WcsUseWaterMeterV changeMeterV=waterMeterVMapper.queryWaterMeterById(waterMeterId);
			if("是".equals(changeMeterV.getIsChangeMeter())){
				return changeMeterV.getChangeMeterUpNumber();//返回换表起方数
			}else{
				return 0.0;
			}
		}
	}

}
