package com.zhanhong.wcs.service;

import java.util.List;

import com.zhanhong.wcs.entity.cost.WcsCostRechargeNotes;
import com.zhanhong.wcs.entity.use.WcsUseMagcard;
import com.zhanhong.wcs.view.use.WcsUseMagcardV;

public interface MagcardService {
	/**
	 * 添加磁卡
	 * @param magcard
	 * @return
	 */
	public String addMagcard(WcsUseMagcard magcard);
	
	/**
	 * 更新磁卡
	 * @param magcard
	 * @return
	 */
	public String updateRechargeMagcard(WcsCostRechargeNotes rechargeNotes);
	
	/**
	 * 扣款磁卡金额
	 * @param magcard
	 * @return
	 */
	public String updateCutPaymentMagcard(WcsCostRechargeNotes rechargeNotes);
	
	/**
	 * 注销磁卡
	 * @param magcardId
	 * @return
	 */
	public String cancelMagcard(int magcardId);
	
	/**
	 * 删除磁卡
	 * @param magcardId
	 * @return
	 */
	public String deleteMagcard(int magcardId);
	
	/**
	 * 根据卡号查询磁卡信息
	 * @param cardNumber
	 * @return
	 */
	public WcsUseMagcard queryMagacrdByNum(String cardNumber);
	
	public List<WcsUseMagcardV> queryMagcardVAll(WcsUseMagcardV magcardV);
	/**
	 * 根据用户ID获取磁卡信息
	 * @param userId
	 * @return
	 */
	public WcsUseMagcardV queryMagcardVByUserId(int userId);
}
