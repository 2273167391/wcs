package com.zhanhong.wcs.entity.sys;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.zhanhong.wcs.entity.base.BaseWcs;
/**
 * 水价实体类
 * @author Arvin_Li
 *
 */
@Alias(value="waterPrice")
@JsonIgnoreProperties(value={"version"})
@JsonSerialize(include=Inclusion.NON_NULL)
public class WcsSysWaterPrice extends BaseWcs{
	private Integer wpId;//水价ID
	private String priceType;//水价类型
	private Double price;//水价
	private Double ladderStartMeasure;//阶梯起量
	private Double ladderEndMeasure;//阶梯止量
	private Integer version;//版本
	public Integer getWpId() {
		return wpId;
	}
	public void setWpId(Integer wpId) {
		this.wpId = wpId;
	}
	public String getPriceType() {
		return priceType;
	}
	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getLadderStartMeasure() {
		return ladderStartMeasure;
	}
	public void setLadderStartMeasure(Double ladderStartMeasure) {
		this.ladderStartMeasure = ladderStartMeasure;
	}
	public Double getLadderEndMeasure() {
		return ladderEndMeasure;
	}
	public void setLadderEndMeasure(Double ladderEndMeasure) {
		this.ladderEndMeasure = ladderEndMeasure;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public WcsSysWaterPrice() {
		super();
	}
	
}
