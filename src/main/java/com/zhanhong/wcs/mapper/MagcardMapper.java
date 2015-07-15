package com.zhanhong.wcs.mapper;

import com.zhanhong.wcs.entity.use.WcsUseMagcard;

public interface MagcardMapper {
	/**
	 * 添加磁卡
	 * @param magcard
	 * @return
	 */
	public int addMagcard(WcsUseMagcard magcard);
	
	/**
	 * 充值磁卡
	 * @param magcard
	 * @return
	 */
	public int updateRechargeMagcard(WcsUseMagcard magcard);
	
	/**
	 * 扣款磁卡金额
	 * @param magcard
	 * @return
	 */
	public int updateCutPaymentMagcard(WcsUseMagcard magcard);
	
	/**
	 * 删除磁卡
	 * @param magcardId
	 * @return
	 */
	public int deleteMagcard(int magcardId);
	
	/**
	 * 根据卡号查询磁卡信息
	 * @param cardNumber
	 * @return
	 */
	public WcsUseMagcard queryMagacrdByNum(String cardNumber);
	
	/**
	 * 根据磁卡ID获取磁卡信息
	 * @param magcardId
	 * @return
	 */
	public WcsUseMagcard queryMagcardById(int magcardId);
	
	/**
	 * 注销磁卡
	 * @param magcardId
	 * @return
	 */
	public int cancelMagcard(int magcardId);
}
