package com.zhanhong.wcs.service;

import java.util.List;

import com.zhanhong.wcs.entity.cost.WcsCostCopyMeter;
import com.zhanhong.wcs.view.cost.WcsCostCopyMeterV;

public interface CopyMeterService {
	/**
	 * 添加抄表记录行
	 * @param copyMeter
	 * @return
	 */
	public String addCopyMeter(WcsCostCopyMeter copyMeter);
	
	/**
	 * 删除抄表记录行
	 * @param copyMeterId
	 * @return
	 */
	public String deleteCopyMeter(Integer copyMeterId);
	
	/**
	 * 根据抄表ID获取记录行
	 * @param copyMeterId
	 * @return
	 */
	public WcsCostCopyMeter queryCopyMeterById(Integer copyMeterId);
	
	public List<WcsCostCopyMeterV> queryCopyMeterAll(WcsCostCopyMeterV copyMeterV);
	
	/**
	 * 获取上个月的水表数量
	 * @param waterMeterId
	 * @param waterMeterCode
	 * @return
	 */
	public Double getUpMonthNumber(int waterMeterId,String waterMeterCode);
}
