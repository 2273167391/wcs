package com.zhanhong.wcs.mapper;

import com.zhanhong.wcs.entity.cost.WcsCostCopyMeter;

public interface CopyMeterMapper {
	
	/**
	 * 添加抄表记录行
	 * @param copyMeter
	 * @return
	 */
	public int addCopyMeter(WcsCostCopyMeter copyMeter);
	
	/**
	 * 删除抄表记录行
	 * @param copyMeterId
	 * @return
	 */
	public int deleteCopyMeter(Integer copyMeterId);
	
	/**
	 * 根据抄表ID获取记录行
	 * @param copyMeterId
	 * @return
	 */
	public WcsCostCopyMeter queryCopyMeterById(Integer copyMeterId);
}
