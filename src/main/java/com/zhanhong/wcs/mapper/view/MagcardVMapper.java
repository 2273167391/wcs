package com.zhanhong.wcs.mapper.view;

import java.util.List;

import com.zhanhong.wcs.view.use.WcsUseMagcardV;

public interface MagcardVMapper {
	public List<WcsUseMagcardV> queryMagcardVAll(WcsUseMagcardV magcardV);
	
	/**
	 * 根据用户ID获取磁卡信息
	 * @param userId
	 * @return
	 */
	public WcsUseMagcardV queryMagcardVByUserId(int userId);
}
