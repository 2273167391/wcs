package com.zhanhong.wcs.view.use;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
@Alias(value="magcardV")
@JsonSerialize(include=Inclusion.NON_NULL)
public class WcsUseMagcardV {
	private Integer magcardId;//磁卡ID
	private String cardNumber;//卡号
	private Double amount;//余额
	private Integer userId;//用户ID 
	private String userName;//用户名
	private String statusCode;//状态码
	private String status;//状态
	private Integer creationBy;//创建人ID
	private String creationName;//创建人姓名
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date creationDate;//创建时间
	private Integer lastUpdateBy;//最后修改人ID
	private String lastUpdateName;//最后修改人
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date lastUpdateDate;//最后修改时间
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
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
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
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	
}
