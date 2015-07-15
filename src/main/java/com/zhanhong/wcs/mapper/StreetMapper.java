package com.zhanhong.wcs.mapper;

import java.util.List;

import com.zhanhong.wcs.entity.sys.WcsSysStreet;

public interface StreetMapper {
	/**
	 * 添加街道
	 * @param street
	 * @return
	 */
	public int addStreet(WcsSysStreet street);
	
	/**
	 * 更新街道
	 * @param street
	 * @return
	 */
	public int updateStreet(WcsSysStreet street);
	
	/**
	 * 删除街道
	 * @param streetId
	 * @return
	 */
	public int deleteStreet(int streetId);
	
	/**
	 * 根据街道名称查询街道信息
	 * @param streetName
	 * @return
	 */
	public WcsSysStreet queryStreetByName(String streetName);
	
	/**
	 * 查询街道信息
	 * @param street
	 * @return
	 */
	public List<WcsSysStreet> queryStreetAll(WcsSysStreet street);
}
