package com.zhanhong.wcs.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhanhong.wcs.context.BaseCommon;
import com.zhanhong.wcs.entity.cost.WcsCostRechargeNotes;
import com.zhanhong.wcs.entity.cost.WcsCostWaterCharge;
import com.zhanhong.wcs.entity.use.WcsUseMagcard;
import com.zhanhong.wcs.mapper.MagcardMapper;
import com.zhanhong.wcs.mapper.RechargeNotesMapper;
import com.zhanhong.wcs.mapper.WaterChargeMapper;
import com.zhanhong.wcs.mapper.view.MagcardVMapper;
import com.zhanhong.wcs.mapper.view.WaterChargeVMapper;
import com.zhanhong.wcs.service.WaterChargeService;
import com.zhanhong.wcs.tools.JsonMessageUtil;
import com.zhanhong.wcs.tools.StringUtil;
import com.zhanhong.wcs.view.cost.WcsCostWaterChargeV;
import com.zhanhong.wcs.view.use.WcsUseMagcardV;

@Service
public class WaterChargeServiceImpl extends BaseCommon implements WaterChargeService{
	
	@Autowired
	private WaterChargeVMapper waterChargeVMapper;
	@Autowired
	private MagcardVMapper magcardVMapper;
	@Autowired
	private MagcardMapper magcardMapper;
	@Autowired
	private RechargeNotesMapper rechargeNotesMapper;
	@Autowired
	private WaterChargeMapper waterChargeMapper;

	@Override
	public List<WcsCostWaterChargeV> queryWaterChargeAll(
			WcsCostWaterChargeV waterChargeV) {
		return waterChargeVMapper.queryWaterChargeAll(waterChargeV);
	}

	@Override
	public String waterCharge(WcsCostWaterChargeV waterChargeV) {
		//判断收费方式
		if("W007001".equalsIgnoreCase(waterChargeV.getChargeType())){
			WcsCostRechargeNotes rechargeNotes=new WcsCostRechargeNotes();
			rechargeNotes.setRechargeMoney(waterChargeV.getCurrentMonthMoney());//扣费金额
			//根据用户ID获取用户磁卡
			WcsUseMagcardV magcardV=magcardVMapper.queryMagcardVByUserId(waterChargeV.getUserId());
			if(null==magcardV){
				return JsonMessageUtil.errorMessaage("该用户还未开通磁卡，收费失败！");
			}
			//如果卡内余额小于等于0或者卡内余额小于要扣款余额，则不允许扣款
			if(magcardV.getAmount()<=0||magcardV.getAmount()<rechargeNotes.getRechargeMoney()){
				return JsonMessageUtil.errorMessaage("余额不足，扣款失败！");
			}
			rechargeNotes.setMagcardId(magcardV.getMagcardId());//设置磁卡ID
			//创建磁卡对象
			WcsUseMagcard magcard=new WcsUseMagcard();
			magcard.setMagcardId(rechargeNotes.getMagcardId());
			magcard.setAmount(rechargeNotes.getRechargeMoney());
			this.copyBean(magcard, false);
			magcardMapper.updateCutPaymentMagcard(magcard);//扣除磁卡金额
			//获取更新后的磁卡信息
			magcard=magcardMapper.queryMagcardById(magcard.getMagcardId());
			//设置金额
			rechargeNotes.setBalance(magcard.getAmount());
			rechargeNotes.setIsExpend(1);//扣款
			rechargeNotes.setSerialNumber(StringUtil.getSearialNumber());//流水号
			rechargeNotes.setRemarks(waterChargeV.getRemarks());
			this.copyBean(rechargeNotes, true);
			rechargeNotesMapper.addRechargeNotes(rechargeNotes);
		}
		//创建水费收费对象
		WcsCostWaterCharge waterCharge=new WcsCostWaterCharge();
		this.copyBean(waterChargeV, waterCharge, false);
		//设置收费人员
		waterCharge.setChargeEmpId(getCurrentEmployeeId());
		//设置收费时间
		waterCharge.setChargeDate(new Date());
		//设置收费状态
		waterCharge.setChargeStatus("W008001");
		return waterChargeMapper.updateWaterCharge(waterCharge)>0?JsonMessageUtil.successMessage("收费成功！"):JsonMessageUtil.errorMessaage("收费失败！");
	}

	@Override
	public List<WcsCostWaterChargeV> queryNotWaterCharge() {
		return waterChargeVMapper.queryNotWaterCharge();
	}

}
