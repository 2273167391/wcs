package com.zhanhong.wcs.view.cost;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.zhanhong.wcs.tools.CustomDateTimeSerialize;

@Alias("waterChargeV")
@JsonSerialize(include=Inclusion.NON_NULL)
public class WcsCostWaterChargeV {
	private Integer chargeId;//收费ID
	private String chargeCode;//收费编码
	private Integer waterMeterId;//水表ID
	private String waterMeterCode;//水表编码
	private Double currentMonthMoney;//本月金额
	private Double price;//水费价格
	private Double realPrice;//实收金额
	private Double changeMoney;//找零
	private String chargeType;//收费类型
	private String chargeTypeName;//收费类型名
	private String chargeStatus;//收费状态
	private String chargeStatusName;//收费状态名
	private String remarks;//备注
	private Double definiteNumber;//用水量
	private Integer chargeEmpId;//收费人ID
	private String chargeEmpName;//收费人姓名
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date chargeDate;//收费时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endChargeDate;
	private Integer userId;//用户ID
	private String userName;//用户名
	private String copyMeterName;//抄表人员
	private Integer magcardId;//磁卡ID
	public Integer getChargeId() {
		return chargeId;
	}
	public void setChargeId(Integer chargeId) {
		this.chargeId = chargeId;
	}
	public String getChargeCode() {
		return chargeCode;
	}
	public void setChargeCode(String chargeCode) {
		this.chargeCode = chargeCode;
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
	public Double getCurrentMonthMoney() {
		return currentMonthMoney;
	}
	public void setCurrentMonthMoney(Double currentMonthMoney) {
		this.currentMonthMoney = currentMonthMoney;
	}
	public Double getRealPrice() {
		return realPrice;
	}
	public void setRealPrice(Double realPrice) {
		this.realPrice = realPrice;
	}
	
	public Double getChangeMoney() {
		return changeMoney;
	}
	public void setChangeMoney(Double changeMoney) {
		this.changeMoney = changeMoney;
	}
	public String getChargeType() {
		return chargeType;
	}
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}
	public String getChargeTypeName() {
		return chargeTypeName;
	}
	public void setChargeTypeName(String chargeTypeName) {
		this.chargeTypeName = chargeTypeName;
	}
	public String getChargeStatus() {
		return chargeStatus;
	}
	public void setChargeStatus(String chargeStatus) {
		this.chargeStatus = chargeStatus;
	}
	public String getChargeStatusName() {
		return chargeStatusName;
	}
	public void setChargeStatusName(String chargeStatusName) {
		this.chargeStatusName = chargeStatusName;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Double getDefiniteNumber() {
		return definiteNumber;
	}
	public void setDefiniteNumber(Double definiteNumber) {
		this.definiteNumber = definiteNumber;
	}
	public Integer getChargeEmpId() {
		return chargeEmpId;
	}
	public void setChargeEmpId(Integer chargeEmpId) {
		this.chargeEmpId = chargeEmpId;
	}
	public String getChargeEmpName() {
		return chargeEmpName;
	}
	public void setChargeEmpName(String chargeEmpName) {
		this.chargeEmpName = chargeEmpName;
	}
	
	public Integer getUserId() {
		return userId;
	}
	@JsonSerialize(using=CustomDateTimeSerialize.class)
	public Date getChargeDate() {
		return chargeDate;
	}
	public void setChargeDate(Date chargeDate) {
		this.chargeDate = chargeDate;
	}
	public Date getEndChargeDate() {
		return endChargeDate;
	}
	public void setEndChargeDate(Date endChargeDate) {
		this.endChargeDate = endChargeDate;
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
	public String getCopyMeterName() {
		return copyMeterName;
	}
	public void setCopyMeterName(String copyMeterName) {
		this.copyMeterName = copyMeterName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getMagcardId() {
		return magcardId;
	}
	public void setMagcardId(Integer magcardId) {
		this.magcardId = magcardId;
	}
	
}
