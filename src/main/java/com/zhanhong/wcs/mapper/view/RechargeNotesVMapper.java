package com.zhanhong.wcs.mapper.view;

import java.util.List;
import java.util.Map;

import com.zhanhong.wcs.view.cost.WcsCostRechargeNotesV;

public interface RechargeNotesVMapper {
	public List<WcsCostRechargeNotesV> queryRechargeNotesAll(WcsCostRechargeNotesV rechargeNotesV);
	
	public List<WcsCostRechargeNotesV> queryRechargeNotesByMagcardId(Map<String, Object> map);
}
