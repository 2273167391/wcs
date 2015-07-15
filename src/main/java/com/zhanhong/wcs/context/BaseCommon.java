package com.zhanhong.wcs.context;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.zhanhong.wcs.entity.sys.WcsSysEmployee;
import com.zhanhong.wcs.tools.CommonParam;

public class BaseCommon {
	/**
	 * 获取当前用户
	 * @return
	 */
	public WcsSysEmployee getCurrentEmployee(){
		return (WcsSysEmployee) ThreadContextHolder.getSessionContext().getAttribute(CommonParam.CURRENT_USER);
	}
	
	/**
	 * 获取当前用户ID
	 * @return
	 */
	public int getCurrentEmployeeId(){
		WcsSysEmployee employee=(WcsSysEmployee) ThreadContextHolder.getSessionContext().getAttribute(CommonParam.CURRENT_USER);
		return employee.getEmpId();
	}
	
	/**
	 * 复制Bean
	 * @param source 被复制的Bean
	 * @param target 目标Bean
	 * @param flag true:添加操作，false:更新操作
	 */
	public void copyBean(Object source,Object target,boolean flag){
		BeanUtils.copyProperties(source, target);
		BeanUtils.copyProperties(new CommonParamters(getCurrentEmployeeId(), new Date()), target);
		if(flag){
			BeanUtils.copyProperties(new CommonCreateParamters(getCurrentEmployeeId(), new Date()), target);
		}
	}
	/**
	 * 复制Bean
	 * @param target 目标Bean
	 * @param flag true:添加操作，false:更新操作
	 */
	public void copyBean(Object target,boolean flag){
		BeanUtils.copyProperties(new CommonParamters(getCurrentEmployeeId(), new Date()), target);
		if(flag){
			BeanUtils.copyProperties(new CommonCreateParamters(getCurrentEmployeeId(), new Date()), target);
		}
	}
	
	public class CommonParamters{
		private Integer lastUpdateBy;//最后更新人ID
		private Date lastUpdateDate;//最后修改时间
		public CommonParamters(Integer lastUpdateBy, Date lastUpdateDate) {
			this.lastUpdateBy = lastUpdateBy;
			this.lastUpdateDate = lastUpdateDate;
		}
		public Integer getLastUpdateBy() {
			return lastUpdateBy;
		}
		public void setLastUpdateBy(Integer lastUpdateBy) {
			this.lastUpdateBy = lastUpdateBy;
		}
		public Date getLastUpdateDate() {
			return lastUpdateDate;
		}
		public void setLastUpdateDate(Date lastUpdateDate) {
			this.lastUpdateDate = lastUpdateDate;
		}
	}
	
	public class CommonCreateParamters{
		private Integer version;//版本
		private Integer creationBy;//创建人
		private Date creationDate;//创建时间
		public CommonCreateParamters(Integer creationBy, Date creationDate) {
			this.creationBy = creationBy;
			this.creationDate = creationDate;
			this.version=1;
		}
		public Integer getCreationBy() {
			return creationBy;
		}
		public void setCreationBy(Integer creationBy) {
			this.creationBy = creationBy;
		}
		public Date getCreationDate() {
			return creationDate;
		}
		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
		}
		public Integer getVersion() {
			return version;
		}
		public void setVersion(Integer version) {
			this.version = version;
		}
		
		
	}
}
