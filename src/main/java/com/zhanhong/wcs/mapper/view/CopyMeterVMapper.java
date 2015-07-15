package com.zhanhong.wcs.mapper.view;

import java.util.List;

import com.zhanhong.wcs.view.cost.WcsCostCopyMeterV;

public interface CopyMeterVMapper {
	public List<WcsCostCopyMeterV> queryCopyMeterAll(WcsCostCopyMeterV copyMeterV);
	
	
	
	/**
	 * 根据抄表ID查询上个月记录数
	 * @param copyMeterId
	 * @return
	 */
	public WcsCostCopyMeterV queryCopyMeterUpMonthsByID(int waterMeterId);
	
	/**
	 * 根据抄表ID获取本月记录
	 * @param waterMeterId
	 * @return
	 */
	public WcsCostCopyMeterV queryCopyMeterCurrentMonthByID(int waterMeterId);
}
