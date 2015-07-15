package com.zhanhong.wcs.service;

import java.util.List;
import java.util.Map;
/**
 * 共用服务类
 * @author Arvin_Li
 *
 */
public interface BaseCommonService {
	/**
	 * 获取员工编码
	 * @return
	 */
	public String getEmployeeCode();
	
	/**
	 * 获取用户编码
	 * @return
	 */
	public String getUserCode();
	
	/**
	 * 获取水表编码
	 * @return
	 */
	public String getWaterMeterCode();
	
	/**
	 * 根据字典类型编码获取字典
	 * @param type
	 * @return
	 */
	public List<Map<String, String>> queryWordBookByCode(String type);
	
	/**
	 * 获取角色类型编码
	 * @return
	 */
	public String getRoleTypeCode();
}
