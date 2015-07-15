package com.zhanhong.wcs.service;

import java.util.List;
import com.zhanhong.wcs.entity.use.WcsUseMaterial;
import com.zhanhong.wcs.view.use.WcsUseMaterialV;

public interface MaterialService {
	/**
	 * 添加材料
	 * @param material
	 * @return
	 */
	public String addMaterial(WcsUseMaterial material);
	
	/**
	 * 更新材料
	 * @param material
	 * @return
	 */
	public String updateMaterial(WcsUseMaterial material);
	
	/**
	 * 删除材料
	 * @param materialId
	 * @return
	 */
	public String deleteMaterial(int materialId);
	
	/**
	 * 查询材料信息
	 * @param materialV
	 * @return
	 */
	public List<WcsUseMaterialV> queryMaterial(WcsUseMaterialV materialV);
	
	/**
	 * 根据用户ID查询材料信息
	 * @param userId
	 * @return
	 */
	public List<WcsUseMaterialV> queryMaterialByUserId(int userId);
}
