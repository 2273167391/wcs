package com.zhanhong.wcs.entity.cost;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.zhanhong.wcs.entity.base.BaseWcs;

/**
 * 充值记录实体类
 * @author Arvin_Li
 *
 */
@Alias(value="rechargeNotes")
@JsonIgnoreProperties(value={"version"})
@JsonSerialize(include=Inclusion.NON_NULL)
public class WcsCostRechargeNotes extends BaseWcs{
	public WcsCostRechargeNotes() {
		super();
	}
	private Integer rechargeId;//充值ID
	private String serialNumber;//充值编码
	private Integer magcardId;//磁卡ID
	private Double rechargeMoney;//充值金额
	private Double balance;//余额
	private String remarks;//备注
	private Integer isExpend;//是否支出
	private Integer version;//版本
	public Integer getRechargeId() {
		return rechargeId;
	}
	public void setRechargeId(Integer rechargeId) {
		this.rechargeId = rechargeId;
	}
	
	
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Integer getIsExpend() {
		return isExpend;
	}
	public void setIsExpend(Integer isExpend) {
		this.isExpend = isExpend;
	}
	public Integer getMagcardId() {
		return magcardId;
	}
	public void setMagcardId(Integer magcardId) {
		this.magcardId = magcardId;
	}
	public Double getRechargeMoney() {
		return rechargeMoney;
	}
	public void setRechargeMoney(Double rechargeMoney) {
		this.rechargeMoney = rechargeMoney;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
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
	
}
