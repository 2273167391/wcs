package com.zhanhong.wcs.entity.use;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.zhanhong.wcs.entity.base.BaseWcs;

/**
 * 磁卡实体类
 * @author Arvin_Li
 *
 */
@Alias(value="magcard")
@JsonIgnoreProperties(value={"version"})
@JsonSerialize(include=Inclusion.NON_NULL)
public class WcsUseMagcard extends BaseWcs{
	private Integer magcardId;//磁卡ID
	private String cardNumber;//卡号
	private Double amount;//金额
	private Integer userId;//用户ID
	private String status;//状态
	private Integer version;//版本
	public WcsUseMagcard() {
		super();
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
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
}
