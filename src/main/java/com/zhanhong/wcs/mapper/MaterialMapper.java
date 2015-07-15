package com.zhanhong.wcs.mapper;

import com.zhanhong.wcs.entity.use.WcsUseMaterial;

public interface MaterialMapper {
	/**
	 * 添加材料
	 * @param material
	 * @return
	 */
	public int addMaterial(WcsUseMaterial material);
	
	/**
	 * 更新材料
	 * @param material
	 * @return
	 */
	public int updateMaterial(WcsUseMaterial material);
	
	/**
	 * 删除材料
	 * @param materialId
	 * @return
	 */
	public int deleteMaterial(int materialId);
	
	/**
	 * 根据材料名称查询材料信息
	 * @param materialName
	 * @return
	 */
	public WcsUseMaterial queryMaterialByName(WcsUseMaterial material);

}
