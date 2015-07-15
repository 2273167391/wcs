package com.zhanhong.wcs.entity.use;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.zhanhong.wcs.entity.base.BaseWcs;
import com.zhanhong.wcs.tools.CustomDateSerialize;

/**
 * 用户水表实体类
 * @author Arvin_Li
 *
 */
@Alias(value="waterMeter")
@JsonIgnoreProperties(value={"version"})
@JsonSerialize(include=Inclusion.NON_NULL)
public class WcsUseWaterMeter extends BaseWcs{
	private Integer waterMeterId;//水表ID
	private String waterMeterCode;//水表编码
	private Integer userId;//用户ID
	private Integer empId;//操作人员ID
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date changeMeterDate;//换表日期
	private Double changeMeterUpNumber;//换表起方
	private String changeMeterCode;//换表水表Code
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date appointmentInstallDate;//预约安装时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date installDate;//安装时间
	private String meterStatus;//水表状态
	private Integer version;//版本
	public WcsUseWaterMeter() {
		super();
	}
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
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	
	@JsonSerialize(using=CustomDateSerialize.class)
	public Date getChangeMeterDate() {
		return changeMeterDate;
	}
	public void setChangeMeterDate(Date changeMeterDate) {
		this.changeMeterDate = changeMeterDate;
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
	
	@JsonSerialize(using=CustomDateSerialize.class)
	public Date getInstallDate() {
		return installDate;
	}
	public void setInstallDate(Date installDate) {
		this.installDate = installDate;
	}
	
	public Integer getVersion() {
		return version;
	}
	
	
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getMeterStatus() {
		return meterStatus;
	}
	public void setMeterStatus(String meterStatus) {
		this.meterStatus = meterStatus;
	}
	
}
