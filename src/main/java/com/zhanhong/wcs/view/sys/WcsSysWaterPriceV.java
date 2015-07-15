package com.zhanhong.wcs.view.sys;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

@Alias(value="waterPriceV")
@JsonSerialize(include=Inclusion.NON_NULL)
public class WcsSysWaterPriceV {

	private Integer wpId;
	private String priceType;
	private Double price;
	private Double endPrice;
	private Double ladderStartMeasure;
	private Double ladderEndMeasure;
	private String priceTypeName;
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
	public String getPriceTypeName() {
		return priceTypeName;
	}
	public void setPriceTypeName(String priceTypeName) {
		this.priceTypeName = priceTypeName;
	}
	public Double getEndPrice() {
		return endPrice;
	}
	public void setEndPrice(Double endPrice) {
		this.endPrice = endPrice;
	}
	
}
