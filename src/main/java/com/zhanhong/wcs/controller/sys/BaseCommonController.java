package com.zhanhong.wcs.controller.sys;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhanhong.wcs.context.ThreadContextHolder;
import com.zhanhong.wcs.entity.sys.WcsSysEmployee;
import com.zhanhong.wcs.entity.sys.WcsSysRole;
import com.zhanhong.wcs.service.BaseCommonService;
import com.zhanhong.wcs.service.RoleService;
import com.zhanhong.wcs.tools.CommonParam;

/**
 * 共用控制器
 * @author Arvin_Li
 *
 */
@Controller
@RequestMapping(value="/base/common")
public class BaseCommonController {
	
	@Autowired
	private BaseCommonService baseCommonService;
	
	@Autowired
	private RoleService roleService;
	
	/**
	 * 根据字典类型获取数据字典
	 * @param type 字典类型
	 * @return
	 */
	@RequestMapping(value="/wordbook/{type}")
	@ResponseBody
	public List<Map<String, String>> queryWordbookByType(@PathVariable String type){
		return baseCommonService.queryWordBookByCode(type);
	}
	
	/**
	 * 获取用户角色
	 * @param empId
	 * @return
	 */
	@RequestMapping(value="/emp/role")
	@ResponseBody
	public List<WcsSysRole> queryEmpRole(){
		//获取当前登录用户
		WcsSysEmployee employee=(WcsSysEmployee) ThreadContextHolder.getSessionContext().getAttribute(CommonParam.CURRENT_USER);
		return roleService.queryRoleByEmpId(employee.getEmpId());
	}

}
