package com.zhanhong.wcs.controller.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhanhong.wcs.entity.sys.WcsSysEmployee;
import com.zhanhong.wcs.service.EmployeeService;
import com.zhanhong.wcs.view.sys.WcsSysEmployeeV;

/**
 * 职员控制器
 * @author Arvin_Li
 *
 */
@Controller
@RequestMapping(value="/sys/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * 获取职员信息
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/list")
	@ResponseBody
	public List<WcsSysEmployeeV> list(WcsSysEmployeeV employee){
		return employeeService.queryEmployeeVAll(employee);
	}
	
	/**
	 * 保存职员信息
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public String saveEmp(WcsSysEmployee employee){
		if(null==employee.getEmpId()){
			return employeeService.addEmployee(employee);
		}
		return employeeService.updateEmployee(employee);
	}
	
	/**
	 * 删除职员信息
	 * @param empId
	 * @return
	 */
	@RequestMapping(value="/delete/{empId}")
	@ResponseBody
	public String deleteEmp(@PathVariable int empId){
		return employeeService.deleteEmployee(empId);
	}
	
	/**
	 * 根据角色类型获取职员信息
	 * @param roleType
	 * @return
	 */
	@RequestMapping(value="/{roleType}")
	@ResponseBody
	public List<WcsSysEmployee> getEmployeeByRoleType(@PathVariable String roleType){
		return employeeService.queryEmployeeByRoleType(roleType);
	}
}
