package com.zhanhong.wcs.service;

import java.util.List;
import java.util.Map;

import com.zhanhong.wcs.entity.cost.WcsCostRechargeNotes;
import com.zhanhong.wcs.view.cost.WcsCostRechargeNotesV;

public interface RechargeNotesService {
	/**
	 * 添加充值记录
	 * @param rechargeNotes 充值对象
	 * @param magcardCode 磁卡编码
	 * @return
	 */
	public int addRechargeNotes(WcsCostRechargeNotes rechargeNotes,String magcardCode);
	
	/**
	 * 删除充值记录
	 * @param rechargeId
	 * @return
	 */
	public String deleteRechargeNotes(int rechargeId);
	
	public List<WcsCostRechargeNotesV> queryRechargeNotesAll(WcsCostRechargeNotesV rechargeNotesV);
	
	public List<WcsCostRechargeNotesV> queryRechargeNotesByMagcardId(Map<String, Object> map);
}
