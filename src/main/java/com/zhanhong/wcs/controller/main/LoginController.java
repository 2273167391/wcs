package com.zhanhong.wcs.controller.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhanhong.wcs.context.ThreadContextHolder;
import com.zhanhong.wcs.entity.sys.WcsSysEmployee;
import com.zhanhong.wcs.entity.sys.WcsSysRole;
import com.zhanhong.wcs.service.EmployeeService;
import com.zhanhong.wcs.service.RoleService;
import com.zhanhong.wcs.tools.CommonParam;
import com.zhanhong.wcs.tools.JsonMessageUtil;
import com.zhanhong.wcs.tools.MD5;
/**
 * 登录控制器
 * @author Arvin_Li
 *
 */
@Controller
public class LoginController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public String login(String userName,String password){
		ObjectMapper mapper=new ObjectMapper();
		//获取当前用户
		WcsSysEmployee employee=employeeService.queryEmployeeByAccount(userName);
		if(null!=employee){
			//判断密码是否正确
			if(MD5.checkPassword(userName, password, employee.getPassword())){
				ThreadContextHolder.getSessionContext().setAttribute(CommonParam.CURRENT_USER, employee);
				//获取用户角色
				List<WcsSysRole> roleList=roleService.queryRoleByEmpId(employee.getEmpId());
				if(roleList.size()<=0){
					return JsonMessageUtil.errorMessaage("该用户没有登录角色，请联系管理员给予相应角色信息！");
				}
				try {
					return mapper.writeValueAsString(roleList);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
					return JsonMessageUtil.errorMessaage("系统错误，请稍后再试！");
				}
			}else{
				return JsonMessageUtil.errorMessaage("用户名或密码错误！");
			}
		}else{
			return JsonMessageUtil.errorMessaage("登录用户不存在！");
		}
	}
	
	
	@RequestMapping(value="/main/{roleId}")
	public String main(@PathVariable int roleId,Model model){
		//获取当前用户角色
		WcsSysRole currentRole=roleService.queryRoleById(roleId);
		//设置当前角色到上下文线程中
		ThreadContextHolder.getSessionContext().setAttribute(CommonParam.CURRENT_ROLE, currentRole);
		model.addAttribute("user", ThreadContextHolder.getSessionContext().getAttribute(CommonParam.CURRENT_USER));
		return "main";
	}
	
	/**
	 * 退出系统
	 * @return
	 */
	@RequestMapping(value="/logout")
	public String logout(){
		//消除所有会话
		ThreadContextHolder.getSessionContext().destory();
		return "redirect:index.html";
	}
}
