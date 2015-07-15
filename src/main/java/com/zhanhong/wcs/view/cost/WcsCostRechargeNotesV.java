package com.zhanhong.wcs.view.cost;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.zhanhong.wcs.tools.CustomDateTimeSerialize;

@Alias("rechangeNotesV")
@JsonSerialize(include=Inclusion.NON_NULL)
public class WcsCostRechargeNotesV {
	private Integer rechargeId;
	private String serialNumber;//流水号
	private Integer magcardId;//磁卡ID
	private String cardNumber;//卡号
	private Double rechargeMoney;//充值金额
	private Double balance;//余额
	private String remarks;//备注
	private Integer isExpend;//是否支出
	private String rechargeExpense;
	private Integer userId;//用户ID
	private String userName;//用户名
	private Integer creationBy;//创建人ID
	private String creationName;//创建人
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date creationDate;//创建时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endCreationDate;
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
	public Integer getMagcardId() {
		return magcardId;
	}
	public void setMagcardId(Integer magcardId) {
		this.magcardId = magcardId;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
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
	public Integer getIsExpend() {
		return isExpend;
	}
	public void setIsExpend(Integer isExpend) {
		this.isExpend = isExpend;
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
	
	public Date getEndCreationDate() {
		return endCreationDate;
	}
	public void setEndCreationDate(Date endCreationDate) {
		this.endCreationDate = endCreationDate;
	}
	public String getRechargeExpense() {
		return rechargeExpense;
	}
	public void setRechargeExpense(String rechargeExpense) {
		this.rechargeExpense = rechargeExpense;
	}
	
}
