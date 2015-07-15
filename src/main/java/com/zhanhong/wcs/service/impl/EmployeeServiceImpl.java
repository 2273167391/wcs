package com.zhanhong.wcs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhanhong.wcs.context.BaseCommon;
import com.zhanhong.wcs.entity.sys.WcsSysEmployee;
import com.zhanhong.wcs.mapper.BaseCommonMapper;
import com.zhanhong.wcs.mapper.EmployeeMapper;
import com.zhanhong.wcs.mapper.EmployeeRoleMapper;
import com.zhanhong.wcs.mapper.view.EmployeeVMapper;
import com.zhanhong.wcs.service.EmployeeService;
import com.zhanhong.wcs.tools.JsonMessageUtil;
import com.zhanhong.wcs.tools.MD5;
import com.zhanhong.wcs.tools.StringUtil;
import com.zhanhong.wcs.view.sys.WcsSysEmployeeV;
/**
 * 职员服务接口实现类
 * @author Arvin_Li
 *
 */
@Service
public class EmployeeServiceImpl extends BaseCommon implements EmployeeService{

	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private BaseCommonMapper baseCommonMapper;
	@Autowired
	private EmployeeVMapper employeeVMapper;
	@Autowired
	private EmployeeRoleMapper employeeRoleMapper;

	/**
	 * 添加职员信息
	 */
	@Override
	public String addEmployee(WcsSysEmployee employee) {
		//查询是否存在要添加的用户
		WcsSysEmployee oldEmp=employeeMapper.queryEmployeeByAccount(employee.getAccount());
		if(null!=oldEmp){
			return JsonMessageUtil.errorMessaage("账户名【"+employee.getAccount()+"】已存在，保存失败！");
		}
		employee.setEmpCode(baseCommonMapper.getEmployeeCode());//设置员工编码
		//随机获取用户密码
		String pwd=StringUtil.getRandomPwd();
		//设置用户密码
		employee.setPassword(MD5.getPwdCode(employee.getAccount(), pwd));
		this.copyBean(employee, true);
		return employeeMapper.addEmployee(employee)>0?JsonMessageUtil.successMessage("保存成功，密码为："+pwd):JsonMessageUtil.errorMessaage("保存失败！");
	}

	/**
	 * 修改职员信息
	 */
	@Override
	public String updateEmployee(WcsSysEmployee employee) {
		this.copyBean(employee, false);
		return employeeMapper.updateEmployee(employee)>0?JsonMessageUtil.successMessage("保存成功！"):JsonMessageUtil.errorMessaage("保存失败！");
	}

	/**
	 * 根据账户名查询职员信息
	 */
	@Override
	public WcsSysEmployee queryEmployeeByAccount(String user) {
		return employeeMapper.queryEmployeeByAccount(user);
	}

	@Override
	public List<WcsSysEmployee> queryEmployeeByRole(int roleId) {
		return employeeMapper.queryEmployeeByRole(roleId);
	}

	@Override
	public List<WcsSysEmployee> queryNotRoleEmpByRoleId(int roleId) {
		return employeeMapper.queryNotRoleEmpByRoleId(roleId);
	}

	@Override
	public List<WcsSysEmployeeV> queryEmployeeVAll(WcsSysEmployeeV employeeV) {
		if(StringUtil.isEmpty(employeeV.getEmpCode())){
			employeeV.setEmpCode("%"+employeeV.getEmpCode()+"%");
		}
		if(StringUtil.isEmpty(employeeV.getAccount())){
			employeeV.setAccount("%"+employeeV.getAccount()+"%");
		}
		if(StringUtil.isEmpty(employeeV.getTrueName())){
			employeeV.setTrueName("%"+employeeV.getTrueName()+"%");
		}
		return employeeVMapper.queryEmployeeVAll(employeeV);
	}

	@Override
	public String deleteEmployee(int empId) {
		if(employeeRoleMapper.queryEmpRoleByEmpId(empId)>0){
			return JsonMessageUtil.errorMessaage("该职员有角色关联，请先解除该职员的角色！");
		}
		return employeeMapper.deleteEmployee(empId)>0?JsonMessageUtil.successMessage("删除成功！"):JsonMessageUtil.errorMessaage("删除失败！");
	}

	@Override
	public List<WcsSysEmployee> queryEmployeeByRoleType(String roleType) {
		return employeeMapper.queryEmployeeByRoleType(roleType);
	}

	@Override
	public String updateEmpPwd(Map<String, Object> map) {
		return employeeMapper.updateEmpPwd(map)>0?JsonMessageUtil.successMessage("修改成功，下次登录生效！"):JsonMessageUtil.errorMessaage("修改失败！");
	}
}
