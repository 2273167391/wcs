package com.zhanhong.wcs.entity.cost;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.zhanhong.wcs.entity.base.BaseWcs;

/**
 * 水费收费实体类
 * @author Arvin_Li
 *
 */
@Alias(value="waterCharge")
@JsonIgnoreProperties(value={"version"})
@JsonSerialize(include=Inclusion.NON_NULL)
public class WcsCostWaterCharge extends BaseWcs{
	private Integer chargeId;//收费ID
	private String chargeCode;//收费编码
	private Integer copyMeterId;//抄表ID
	private Double currentMonthMoney;//本月金额
	private Double realPrice;//实收金额
	private Double changeMoney;//找零
	private String chargeType;//收费类型
	private String chargeStatus;//收费状态
	private String remarks;//备注
	private Integer version;//版本
	private Integer chargeEmpId;//收费人员ID
	private Date chargeDate;//收费时间 
	public WcsCostWaterCharge() {
		super();
	}
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
	
	
	public Integer getCopyMeterId() {
		return copyMeterId;
	}
	public void setCopyMeterId(Integer copyMeterId) {
		this.copyMeterId = copyMeterId;
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
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getChargeStatus() {
		return chargeStatus;
	}
	public void setChargeStatus(String chargeStatus) {
		this.chargeStatus = chargeStatus;
	}
	public Integer getChargeEmpId() {
		return chargeEmpId;
	}
	public void setChargeEmpId(Integer chargeEmpId) {
		this.chargeEmpId = chargeEmpId;
	}
	public Date getChargeDate() {
		return chargeDate;
	}
	public void setChargeDate(Date chargeDate) {
		this.chargeDate = chargeDate;
	}
	
}
