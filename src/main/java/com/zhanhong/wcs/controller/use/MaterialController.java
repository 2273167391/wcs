package com.zhanhong.wcs.controller.use;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhanhong.wcs.entity.use.WcsUseMaterial;
import com.zhanhong.wcs.service.MaterialService;
import com.zhanhong.wcs.view.use.WcsUseMaterialV;

@Controller
@RequestMapping(value="/use/material")
public class MaterialController {
	
	@Autowired
	private MaterialService materialService;
	
	/**
	 * 查询材料信息
	 * @param materialV
	 * @return
	 */
	@RequestMapping(value="/all")
	@ResponseBody
	public List<WcsUseMaterialV> queryMaterial(WcsUseMaterialV materialV){
		return materialService.queryMaterial(materialV);
	}
	
	/**
	 * 根据用户ID获取材料信息
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/{userId}")
	@ResponseBody
	public List<WcsUseMaterialV> queryMaterialByUserId(@PathVariable int userId){
		return materialService.queryMaterialByUserId(userId);
	}
	
	/**
	 * 保存材料信息
	 * @param material
	 * @return
	 */
	
	@RequestMapping(value="/save")
	@ResponseBody
	public String saveMaterial(WcsUseMaterial material){
		if(null==material.getMaterialId()){
			return materialService.addMaterial(material);
		}
		return materialService.updateMaterial(material);
	}
	
	@RequestMapping(value="/delete/{materialId}")
	@ResponseBody
	public String deleteMaterial(@PathVariable int materialId){
		return materialService.deleteMaterial(materialId);
	}
}
