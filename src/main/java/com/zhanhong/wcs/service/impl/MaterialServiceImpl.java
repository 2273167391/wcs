package com.zhanhong.wcs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhanhong.wcs.context.BaseCommon;
import com.zhanhong.wcs.entity.use.WcsUseMaterial;
import com.zhanhong.wcs.mapper.MaterialMapper;
import com.zhanhong.wcs.mapper.view.MaterialVMapper;
import com.zhanhong.wcs.service.MaterialService;
import com.zhanhong.wcs.tools.JsonMessageUtil;
import com.zhanhong.wcs.view.use.WcsUseMaterialV;

@Service
public class MaterialServiceImpl extends BaseCommon implements MaterialService{
	
	@Autowired
	private MaterialMapper materialMapper;
	@Autowired
	private MaterialVMapper materialVMapper;

	@Override
	public String addMaterial(WcsUseMaterial material) {
		//查询是否存在材料
		WcsUseMaterial oldMaterial=materialMapper.queryMaterialByName(material);
		if(null!=oldMaterial){
			return JsonMessageUtil.errorMessaage("该用户已存在该材料，保存失败！");
		}
		material.setAmount(material.getPrice()*material.getNumbers());//计算金额
		this.copyBean(material, true);
		return materialMapper.addMaterial(material)>0?JsonMessageUtil.successMessage("保存成功！"):JsonMessageUtil.errorMessaage("保存失败！");
	}

	@Override
	public String updateMaterial(WcsUseMaterial material) {
		this.copyBean(material, false);
		material.setAmount(material.getPrice()*material.getNumbers());//计算金额
		return materialMapper.updateMaterial(material)>0?JsonMessageUtil.successMessage("保存成功！"):JsonMessageUtil.errorMessaage("保存失败！");
	}

	@Override
	public String deleteMaterial(int materialId) {
		return materialMapper.deleteMaterial(materialId)>0?JsonMessageUtil.successMessage("删除成功！"):JsonMessageUtil.errorMessaage("删除失败！");
	}

	@Override
	public List<WcsUseMaterialV> queryMaterial(WcsUseMaterialV materialV) {
		return materialVMapper.queryMaterial(materialV);
	}

	@Override
	public List<WcsUseMaterialV> queryMaterialByUserId(int userId) {
		return materialVMapper.queryMaterialByUserId(userId);
	}

}
