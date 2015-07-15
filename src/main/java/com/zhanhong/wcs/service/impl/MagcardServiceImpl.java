package com.zhanhong.wcs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhanhong.wcs.context.BaseCommon;
import com.zhanhong.wcs.entity.cost.WcsCostRechargeNotes;
import com.zhanhong.wcs.entity.use.WcsUseMagcard;
import com.zhanhong.wcs.mapper.MagcardMapper;
import com.zhanhong.wcs.mapper.RechargeNotesMapper;
import com.zhanhong.wcs.mapper.view.MagcardVMapper;
import com.zhanhong.wcs.service.MagcardService;
import com.zhanhong.wcs.tools.JsonMessageUtil;
import com.zhanhong.wcs.tools.StringUtil;
import com.zhanhong.wcs.view.use.WcsUseMagcardV;

@Service
public class MagcardServiceImpl extends BaseCommon implements MagcardService{
	
	@Autowired
	private MagcardMapper magcardMapper;
	@Autowired
	private MagcardVMapper magcardVMapper;
	@Autowired
	private RechargeNotesMapper rechargeNotesMapper;

	@Override
	public String addMagcard(WcsUseMagcard magcard) {
		//根据用户ID获取磁卡
		WcsUseMagcardV oldMagcard=magcardVMapper.queryMagcardVByUserId(magcard.getUserId());
		if(null!=oldMagcard){
			return JsonMessageUtil.errorMessaage("该用户已存在磁卡，保存失败！");
		}
		magcard.setCardNumber("USM"+System.currentTimeMillis());
		magcard.setStatus("W004001");
		this.copyBean(magcard, true);
		int result=magcardMapper.addMagcard(magcard);
		if(magcard.getAmount()!=0){
			//创建充值记录对象
			WcsCostRechargeNotes rechargeNotes=new WcsCostRechargeNotes();
			rechargeNotes.setSerialNumber(StringUtil.getSearialNumber());//设置充值流水号
			rechargeNotes.setRechargeMoney(magcard.getAmount());
			rechargeNotes.setBalance(magcard.getAmount());
			rechargeNotes.setRemarks("开卡充值金额");
			rechargeNotes.setIsExpend(0);//充值
			rechargeNotes.setMagcardId(magcard.getMagcardId());//充值磁卡ID
			this.copyBean(rechargeNotes, true);
			result=rechargeNotesMapper.addRechargeNotes(rechargeNotes);
		}
		return result>0?JsonMessageUtil.successMessage("保存成功！"):JsonMessageUtil.errorMessaage("保存失败！");
	}

	/**
	 * 充值磁卡
	 * @param magcard
	 * @return
	 */
	@Override
	public String updateRechargeMagcard(WcsCostRechargeNotes rechargeNotes) {
		//创建磁卡对象
		WcsUseMagcard magcard=new WcsUseMagcard();
		magcard.setMagcardId(rechargeNotes.getMagcardId());
		magcard.setAmount(rechargeNotes.getRechargeMoney());
		this.copyBean(magcard, false);
		magcardMapper.updateRechargeMagcard(magcard);
		//获取更新后的磁卡信息
		magcard=magcardMapper.queryMagcardById(magcard.getMagcardId());
		//设置金额
		rechargeNotes.setBalance(magcard.getAmount());
		rechargeNotes.setIsExpend(0);//充值
		rechargeNotes.setSerialNumber(StringUtil.getSearialNumber());//流水号
		this.copyBean(rechargeNotes, true);
		return rechargeNotesMapper.addRechargeNotes(rechargeNotes)>0?JsonMessageUtil.successMessage("充值成功！"):JsonMessageUtil.errorMessaage("充值失败！");
	}

	@Override
	public String deleteMagcard(int magcardId) {
		//先删除磁卡记录
		rechargeNotesMapper.deleteRechargeNotesByMagcardId(magcardId);
		return magcardMapper.deleteMagcard(magcardId)>0?JsonMessageUtil.successMessage("删除成功！"):JsonMessageUtil.errorMessaage("删除失败！");
	}

	@Override
	public WcsUseMagcard queryMagacrdByNum(String cardNumber) {
		return magcardMapper.queryMagacrdByNum(cardNumber);
	}

	/**
	 * 扣款磁卡金额
	 * @param magcard
	 * @return
	 */
	@Override
	public String updateCutPaymentMagcard(WcsCostRechargeNotes rechargeNotes) {
		WcsUseMagcard oldMagcard=magcardMapper.queryMagcardById(rechargeNotes.getMagcardId());
		//如果卡内余额小于等于0或者卡内余额小于要扣款余额，则不允许扣款
		if(oldMagcard.getAmount()<=0||oldMagcard.getAmount()<rechargeNotes.getRechargeMoney()){
			return JsonMessageUtil.errorMessaage("余额不足，扣款失败！");
		}
		//创建磁卡对象
		WcsUseMagcard magcard=new WcsUseMagcard();
		magcard.setMagcardId(rechargeNotes.getMagcardId());
		magcard.setAmount(rechargeNotes.getRechargeMoney());
		this.copyBean(magcard, false);
		magcardMapper.updateCutPaymentMagcard(magcard);
		//获取更新后的磁卡信息
		magcard=magcardMapper.queryMagcardById(magcard.getMagcardId());
		//设置金额
		rechargeNotes.setBalance(magcard.getAmount());
		rechargeNotes.setIsExpend(1);//扣款
		rechargeNotes.setSerialNumber(StringUtil.getSearialNumber());//流水号
		this.copyBean(rechargeNotes, true);
		return rechargeNotesMapper.addRechargeNotes(rechargeNotes)>0?JsonMessageUtil.successMessage("扣款成功！"):JsonMessageUtil.errorMessaage("扣款失败！");
	}

	@Override
	public List<WcsUseMagcardV> queryMagcardVAll(WcsUseMagcardV magcardV) {
		return magcardVMapper.queryMagcardVAll(magcardV);
	}

	@Override
	public String cancelMagcard(int magcardId) {
		WcsUseMagcard oldMagcard=magcardMapper.queryMagcardById(magcardId);//获取磁卡信息
		//如果磁卡余额不为0，则不能注销
		if(oldMagcard.getAmount()>0){
			return JsonMessageUtil.errorMessaage("磁卡【"+oldMagcard.getCardNumber()+"】余额大于0，不能注销！");
		}
		return magcardMapper.cancelMagcard(magcardId)>0?JsonMessageUtil.successMessage("注销成功！"):JsonMessageUtil.errorMessaage("注销失败！");
	}

	@Override
	public WcsUseMagcardV queryMagcardVByUserId(int userId) {
		return magcardVMapper.queryMagcardVByUserId(userId);
	}

}
