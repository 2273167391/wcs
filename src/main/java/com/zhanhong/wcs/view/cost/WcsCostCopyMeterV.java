package com.zhanhong.wcs.view.cost;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.zhanhong.wcs.tools.CustomDateTimeSerialize;

@Alias("copyMeterV")
@JsonSerialize(include=Inclusion.NON_NULL)
public class WcsCostCopyMeterV {
	private Integer copyMeterId;//抄表ID
	private Integer waterMeterId;//水表ID
	private String waterMeterCode;//水表编码
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date handlerDate;//抄表时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endHandlerDate;
	private Double startNumber;//起数
	private Double endNumber;//止数
	private Double definiteNumber;//实用数量
	private Integer wpId;//水价ID 
	private Double price;//水价
	private Double money;//金额
	private Integer copyMeterEmpId;//抄表人员ID
	private String copyMeterName;//抄表人员
	private String remarks;//备注
	private Integer creationBy;//抄表记录创建人ID
	private String creationName;//抄表记录创建人
	private Date creationDate;//抄表记录创建时间
	private Integer userId;//用户ID
	private String userName;//用户名
	public Integer getCopyMeterId() {
		return copyMeterId;
	}
	public void setCopyMeterId(Integer copyMeterId) {
		this.copyMeterId = copyMeterId;
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
	
	@JsonSerialize(using=CustomDateTimeSerialize.class)
	public Date getHandlerDate() {
		return handlerDate;
	}
	public void setHandlerDate(Date handlerDate) {
		this.handlerDate = handlerDate;
	}
	public Double getStartNumber() {
		return startNumber;
	}
	public void setStartNumber(Double startNumber) {
		this.startNumber = startNumber;
	}
	public Double getEndNumber() {
		return endNumber;
	}
	public void setEndNumber(Double endNumber) {
		this.endNumber = endNumber;
	}
	public Double getDefiniteNumber() {
		return definiteNumber;
	}
	public void setDefiniteNumber(Double definiteNumber) {
		this.definiteNumber = definiteNumber;
	}
	public Integer getWpId() {
		return wpId;
	}
	public void setWpId(Integer wpId) {
		this.wpId = wpId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getCopyMeterEmpId() {
		return copyMeterEmpId;
	}
	public void setCopyMeterEmpId(Integer copyMeterEmpId) {
		this.copyMeterEmpId = copyMeterEmpId;
	}
	public String getCopyMeterName() {
		return copyMeterName;
	}
	public void setCopyMeterName(String copyMeterName) {
		this.copyMeterName = copyMeterName;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	
	@JsonSerialize(using=CustomDateTimeSerialize.class)
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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
	public Date getEndHandlerDate() {
		return endHandlerDate;
	}
	public void setEndHandlerDate(Date endHandlerDate) {
		this.endHandlerDate = endHandlerDate;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	
}
