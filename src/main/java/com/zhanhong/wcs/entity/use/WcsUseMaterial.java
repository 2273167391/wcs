package com.zhanhong.wcs.entity.use;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.zhanhong.wcs.entity.base.BaseWcs;

/**
 * 用户材料实体类
 * @author Arvin_Li
 *
 */
@Alias(value="material")
@JsonIgnoreProperties(value={"version"})
@JsonSerialize(include=Inclusion.NON_NULL)
public class WcsUseMaterial extends BaseWcs{
	private Integer materialId;//材料ID
	private Integer userId;//用户ID
	private String materialCode;//材料编码
	private Double price;//单价
	private Integer numbers;//数量
	private Double amount;//金额
	private String remarks;//备注
	private Integer version;//版本
	public WcsUseMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getMaterialId() {
		return materialId;
	}
	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getMaterialCode() {
		return materialCode;
	}
	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getNumbers() {
		return numbers;
	}
	public void setNumbers(Integer numbers) {
		this.numbers = numbers;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
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
