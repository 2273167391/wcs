package com.zhanhong.wcs.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhanhong.wcs.context.BaseCommon;
import com.zhanhong.wcs.entity.cost.WcsCostRechargeNotes;
import com.zhanhong.wcs.entity.use.WcsUseMagcard;
import com.zhanhong.wcs.mapper.MagcardMapper;
import com.zhanhong.wcs.mapper.RechargeNotesMapper;
import com.zhanhong.wcs.mapper.view.RechargeNotesVMapper;
import com.zhanhong.wcs.service.RechargeNotesService;
import com.zhanhong.wcs.tools.JsonMessageUtil;
import com.zhanhong.wcs.view.cost.WcsCostRechargeNotesV;
@Service
public class RechargeNotesServiceImpl extends BaseCommon implements RechargeNotesService{

	@Autowired
	private RechargeNotesMapper rechargeNotesMapper;
	@Autowired
	private RechargeNotesVMapper rechargeNotesVMapper;
	
	@Autowired
	private MagcardMapper magcardMapper;
	@Override
	public int addRechargeNotes(WcsCostRechargeNotes rechargeNotes,
			String magcardCode) {
		//获取磁卡信息
		WcsUseMagcard magcard=magcardMapper.queryMagacrdByNum(magcardCode);
		if(null==magcard)return 0;
		magcard.setAmount(rechargeNotes.getRechargeMoney());//设置磁卡余额
		magcard.setLastUpdateBy(rechargeNotes.getCreationBy());//更新人
		magcard.setLastUpdateDate(new Date());//更新时间
		magcardMapper.updateRechargeMagcard(magcard);//修改用户卡
		//查询更新过后的磁卡信息
		magcard=magcardMapper.queryMagacrdByNum(magcardCode);
		rechargeNotes.setSerialNumber("RN"+System.currentTimeMillis());//设置充值编码
		rechargeNotes.setMagcardId(magcard.getMagcardId());//设置磁卡ID
		rechargeNotes.setBalance(magcard.getAmount());//设置余额
		this.copyBean(rechargeNotes, true);
		return rechargeNotesMapper.addRechargeNotes(rechargeNotes);
	}

	@Override
	public String deleteRechargeNotes(int rechargeId) {
		return rechargeNotesMapper.deleteRechargeNotes(rechargeId)>0?JsonMessageUtil.successMessage("删除成功！"):JsonMessageUtil.errorMessaage("删除失败！");
	}

	@Override
	public List<WcsCostRechargeNotesV> queryRechargeNotesAll(
			WcsCostRechargeNotesV rechargeNotesV) {
		return rechargeNotesVMapper.queryRechargeNotesAll(rechargeNotesV);
	}

	@Override
	public List<WcsCostRechargeNotesV> queryRechargeNotesByMagcardId(
			Map<String, Object> map) {
		return rechargeNotesVMapper.queryRechargeNotesByMagcardId(map);
	}

}
