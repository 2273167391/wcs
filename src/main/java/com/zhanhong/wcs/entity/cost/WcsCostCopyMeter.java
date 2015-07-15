package com.zhanhong.wcs.entity.cost;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.zhanhong.wcs.entity.base.BaseWcs;

/**
 * 抄表实体类
 * @author Arvin_Li
 *
 */
@Alias(value="copyMeter")
@JsonIgnoreProperties(value={"version"})
@JsonSerialize(include=Inclusion.NON_NULL)
public class WcsCostCopyMeter extends BaseWcs{
	private Integer copyMeterId;//抄表ID
	private Integer waterMeterId;//水表ID
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date handlerDate;//抄表时间
	private Double startNumber;//起数
	private Double endNumber;//止数
	private Double definiteNumber;//实用数量
	private Integer wpId;//水价ID
	private Integer empId;//抄表人员ID
	private String remarks;//备注
	private Integer version;//版本
	public WcsCostCopyMeter() {
		super();
	}
	public Integer getCopyMeterId() {
		return copyMeterId;
	}
	public void setCopyMeterId(Integer copyMeterId) {
		this.copyMeterId = copyMeterId;
	}
	public Integer getWaterMeterId() {
		return waterMeterId;
	}
	public void setWaterMeterId(Integer waterMeterId) {
		this.waterMeterId = waterMeterId;
	}
	public Date getHandlerDate() {
		return handlerDate;
	}
	public void setHandlerDate(Date handlerDate) {
		this.handlerDate = handlerDate;
	}
	public Double getStartNumber() {
		return startNumber;
	}
	public void setStartNumber(Double startNumber) {
		this.startNumber = startNumber;
	}
	public Double getEndNumber() {
		return endNumber;
	}
	public void setEndNumber(Double endNumber) {
		this.endNumber = endNumber;
	}
	public Double getDefiniteNumber() {
		return definiteNumber;
	}
	public void setDefiniteNumber(Double definiteNumber) {
		this.definiteNumber = definiteNumber;
	}
	public Integer getWpId() {
		return wpId;
	}
	public void setWpId(Integer wpId) {
		this.wpId = wpId;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
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
