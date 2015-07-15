package com.zhanhong.wcs.mapper.view;

import java.util.List;

import com.zhanhong.wcs.view.use.WcsUseMaterialV;

public interface MaterialVMapper {
	public List<WcsUseMaterialV> queryMaterial(WcsUseMaterialV materialV);
	public List<WcsUseMaterialV> queryMaterialByUserId(int userId);
}
