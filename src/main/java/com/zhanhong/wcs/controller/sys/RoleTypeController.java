package com.zhanhong.wcs.controller.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhanhong.wcs.entity.sys.WcsSysRoleType;
import com.zhanhong.wcs.service.RoleTypeService;

/**
 * 角色类型控制器
 * @author Arvin_Li
 *
 */

@Controller
@RequestMapping(value="/sys/role_type")
public class RoleTypeController {
	
	@Autowired
	private RoleTypeService roleTypeService;
	
	/**
	 * 获取所有角色类型
	 * @return
	 */
	@RequestMapping(value="/all")
	@ResponseBody
	public List<WcsSysRoleType> queryAllRoleType(){
		return roleTypeService.queryRoleTypeAll();
	}
	
	/**
	 * 保存角色类型
	 * @param roleType
	 * @return
	 */
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public String saveRoleType(WcsSysRoleType roleType){
		//如果ID为空那么就添加
		if(null==roleType.getRoleTypeId()){
			return roleTypeService.addRoleType(roleType);
		}
		return roleTypeService.updateRoleType(roleType);
	}
	
	/**
	 * 删除角色类型
	 * @param typeId
	 * @return
	 */
	@RequestMapping(value="/delete/{typeId}")
	@ResponseBody
	public String deleteRoleType(@PathVariable int typeId){
		return roleTypeService.deleteRoleType(typeId);
	}
	
	
}
