package com.zhanhong.wcs.service;

import java.util.List;

import com.zhanhong.wcs.entity.sys.WcsSysStreet;
/**
 * 街道服务接口
 * @author Arvin_Li
 *
 */
public interface StreetService {
	/**
	 * 添加街道
	 * @param street
	 * @return
	 */
	public String addStreet(WcsSysStreet street);
	
	/**
	 * 更新街道
	 * @param street
	 * @return
	 */
	public String updateStreet(WcsSysStreet street);
	
	/**
	 * 删除街道
	 * @param streetId
	 * @return
	 */
	public String deleteStreet(int streetId);
	
	/**
	 * 查询街道信息
	 * @param street
	 * @return
	 */
	public List<WcsSysStreet> queryStreetAll(WcsSysStreet street);
	
	/**
	 * 根据街道名称查询街道信息
	 * @param streetName
	 * @return
	 */
	public WcsSysStreet queryStreetByName(String streetName);
}
