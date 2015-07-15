package com.zhanhong.wcs.entity.sys;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.zhanhong.wcs.entity.base.BaseWcs;
/**
 * 街道实体类
 * @author Arvin_Li
 *
 */
@Alias(value="street")
@JsonIgnoreProperties(value={"version"})
@JsonSerialize(include=Inclusion.NON_NULL)
public class WcsSysStreet extends BaseWcs{
	private Integer streetId;//街道ID
	private String streetCode;//街道编码
	private String streetName;//街道名称
	private Integer version;//版本
	public WcsSysStreet() {
		super();
	}
	public Integer getStreetId() {
		return streetId;
	}
	public void setStreetId(Integer streetId) {
		this.streetId = streetId;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public String getStreetCode() {
		return streetCode;
	}
	public void setStreetCode(String streetCode) {
		this.streetCode = streetCode;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
}
