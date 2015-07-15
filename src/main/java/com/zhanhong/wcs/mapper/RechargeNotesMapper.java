package com.zhanhong.wcs.mapper;

import com.zhanhong.wcs.entity.cost.WcsCostRechargeNotes;

public interface RechargeNotesMapper {
	
	/**
	 * 添加充值记录
	 * @param rechargeNotes 充值对象
	 * @param magcardCode 磁卡编码
	 * @return
	 */
	public int addRechargeNotes(WcsCostRechargeNotes rechargeNotes);
	
	/**
	 * 删除充值记录
	 * @param rechargeId
	 * @return
	 */
	public int deleteRechargeNotes(int rechargeId);
	
	/**
	 * 根据磁卡ID删除记录ID
	 * @param magcardId
	 * @return
	 */
	public int deleteRechargeNotesByMagcardId(int magcardId);
}
