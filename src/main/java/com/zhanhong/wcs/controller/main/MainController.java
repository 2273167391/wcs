package com.zhanhong.wcs.controller.main;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhanhong.wcs.context.ThreadContextHolder;
import com.zhanhong.wcs.entity.sys.WcsSysEmployee;
import com.zhanhong.wcs.entity.sys.WcsSysMenus;
import com.zhanhong.wcs.entity.sys.WcsSysRole;
import com.zhanhong.wcs.service.EmployeeService;
import com.zhanhong.wcs.service.MenusService;
import com.zhanhong.wcs.tools.CommonParam;
import com.zhanhong.wcs.tools.JsonMenuUtil;
import com.zhanhong.wcs.tools.JsonMessageUtil;
import com.zhanhong.wcs.tools.MD5;

/**
 * 主体控制器
 * @author Arvin_Li
 *
 */
@Controller
public class MainController {
	
	@Autowired
	private MenusService menusService;
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/menu")
	@ResponseBody
	public String menu(){
		//获取当前用户角色
		WcsSysRole role=(WcsSysRole) ThreadContextHolder.getSessionContext().getAttribute(CommonParam.CURRENT_ROLE);
		//获取菜单
		List<WcsSysMenus> menuList=menusService.queryMenuByRoleId(role.getRoleId());
		System.out.println(JsonMenuUtil.getJsonMenu(menuList));
		//返回菜单
		return JsonMenuUtil.getJsonMenu(menuList);
	}
	
	@RequestMapping(value="/update_pwd")
	@ResponseBody
	public String updatePwd(String pwd,String newPwd){
		//获取当前登录用户
		WcsSysEmployee employee=(WcsSysEmployee) ThreadContextHolder.getSessionContext().getAttribute(CommonParam.CURRENT_USER);
		//判断原密码
		if(MD5.checkPassword(employee.getAccount(), pwd, employee.getPassword())){
			//创建Map集合
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("password", MD5.getPwdCode(employee.getAccount(), newPwd));
			map.put("empId", employee.getEmpId());
			map.put("updateDate", new Date());
			return employeeService.updateEmpPwd(map);
		}else{
			return JsonMessageUtil.errorMessaage("原密码错误，修改失败！");
		}
	}
}
