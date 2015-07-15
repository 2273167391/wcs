package com.zhanhong.wcs.view.use;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zhanhong.wcs.tools.CustomDateSerialize;

@Alias("waterMeterV")
public class WcsUseWaterMeterV {
	private Integer waterMeterId;//水表ID
	private String waterMeterCode;//水表编码
	private Integer userId;//用户ID
	private String userName;//用户名
	private String homeAddress;//用户地址
	private Integer empId;//操作人ID
	private String empName;//操作人
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date changeMeterDate;//换表日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endChangeMeterDate;
	private Double changeMeterUpNumber;//换表起方
	private String changeMeterCode;//换表水表编码
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date appointmentInstallDate;//预约安装时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endAppointmentInstallDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date installDate;//安装时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endInstallDate;
	
	private Integer version;//版本
	private Integer creationBy;//创建人ID
	private String creationName;//创建人
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date creationDate;//创建时间
	private Integer lastUpdateBy;//更新人ID
	private String lastUpdateName;//更新人
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date lastUpdateDate;//更新时间
	private String isChangeMeter;//是否是换表
	private String isExecute;//是否安装
	private String meterStatusCode;//状态编码
	private String meterStatus;//水表状态
	public Integer getWaterMeterId() {
		return waterMeterId;
	}
	public void setWaterMeterId(Integer waterMeterId) {
		this.waterMeterId = waterMeterId;
	}
	public String getWaterMeterCode() {
		return waterMeterCode;
	}
	public void setWaterMeterCode(String waterMeterCode) {
		this.waterMeterCode = waterMeterCode;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	@JsonSerialize(using=CustomDateSerialize.class)
	public Date getChangeMeterDate() {
		return changeMeterDate;
	}
	public void setChangeMeterDate(Date changeMeterDate) {
		this.changeMeterDate = changeMeterDate;
	}
	
	public Date getEndChangeMeterDate() {
		return endChangeMeterDate;
	}
	public void setEndChangeMeterDate(Date endChangeMeterDate) {
		this.endChangeMeterDate = endChangeMeterDate;
	}
	public Double getChangeMeterUpNumber() {
		return changeMeterUpNumber;
	}
	public void setChangeMeterUpNumber(Double changeMeterUpNumber) {
		this.changeMeterUpNumber = changeMeterUpNumber;
	}
	public String getChangeMeterCode() {
		return changeMeterCode;
	}
	public void setChangeMeterCode(String changeMeterCode) {
		this.changeMeterCode = changeMeterCode;
	}
	
	@JsonSerialize(using=CustomDateSerialize.class)
	public Date getAppointmentInstallDate() {
		return appointmentInstallDate;
	}
	public void setAppointmentInstallDate(Date appointmentInstallDate) {
		this.appointmentInstallDate = appointmentInstallDate;
	}
	public Date getEndAppointmentInstallDate() {
		return endAppointmentInstallDate;
	}
	public void setEndAppointmentInstallDate(Date endAppointmentInstallDate) {
		this.endAppointmentInstallDate = endAppointmentInstallDate;
	}
	
	@JsonSerialize(using=CustomDateSerialize.class)
	public Date getInstallDate() {
		return installDate;
	}
	public void setInstallDate(Date installDate) {
		this.installDate = installDate;
	}
	public Date getEndInstallDate() {
		return endInstallDate;
	}
	public void setEndInstallDate(Date endInstallDate) {
		this.endInstallDate = endInstallDate;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getCreationBy() {
		return creationBy;
	}
	public void setCreationBy(Integer creationBy) {
		this.creationBy = creationBy;
	}
	public String getCreationName() {
		return creationName;
	}
	public void setCreationName(String creationName) {
		this.creationName = creationName;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getLastUpdateBy() {
		return lastUpdateBy;
	}
	public void setLastUpdateBy(Integer lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}
	public String getLastUpdateName() {
		return lastUpdateName;
	}
	public void setLastUpdateName(String lastUpdateName) {
		this.lastUpdateName = lastUpdateName;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public String getIsChangeMeter() {
		return isChangeMeter;
	}
	public void setIsChangeMeter(String isChangeMeter) {
		this.isChangeMeter = isChangeMeter;
	}
	public String getIsExecute() {
		return isExecute;
	}
	public void setIsExecute(String isExecute) {
		this.isExecute = isExecute;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getMeterStatusCode() {
		return meterStatusCode;
	}
	public void setMeterStatusCode(String meterStatusCode) {
		this.meterStatusCode = meterStatusCode;
	}
	public String getMeterStatus() {
		return meterStatus;
	}
	public void setMeterStatus(String meterStatus) {
		this.meterStatus = meterStatus;
	}
	
}
