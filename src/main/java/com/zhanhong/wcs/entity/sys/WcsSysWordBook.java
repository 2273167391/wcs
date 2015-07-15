package com.zhanhong.wcs.entity.sys;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.zhanhong.wcs.entity.base.BaseWcs;
import com.zhanhong.wcs.tools.CustomDateSerialize;

/**
 * 数据字典实体
 * @author Arvin_Li
 *
 */
@Alias(value="wordBook")
@JsonIgnoreProperties(value={"version"})
@JsonSerialize(include=Inclusion.NON_NULL)
public class WcsSysWordBook extends BaseWcs{
	private String wordBookCode;//字典编码
	private String wordBookTypeCode;//字典类别编码
	private String wordBookContent;//字典内容
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date effectiveDate;//生效时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date invalidationDate;//失效时间
	private String remarks;//备注
	private String reserved1;//保留字段1
	private Integer version;//版本
	public WcsSysWordBook() {
		super();
	}
	public String getWordBookCode() {
		return wordBookCode;
	}
	public void setWordBookCode(String wordBookCode) {
		this.wordBookCode = wordBookCode;
	}
	public String getWordBookTypeCode() {
		return wordBookTypeCode;
	}
	public void setWordBookTypeCode(String wordBookTypeCode) {
		this.wordBookTypeCode = wordBookTypeCode;
	}
	public String getWordBookContent() {
		return wordBookContent;
	}
	public void setWordBookContent(String wordBookContent) {
		this.wordBookContent = wordBookContent;
	}
	
	@JsonSerialize(using=CustomDateSerialize.class)
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	
	@JsonSerialize(using=CustomDateSerialize.class)
	public Date getInvalidationDate() {
		return invalidationDate;
	}
	public void setInvalidationDate(Date invalidationDate) {
		this.invalidationDate = invalidationDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getReserved1() {
		return reserved1;
	}
	public void setReserved1(String reserved1) {
		this.reserved1 = reserved1;
	}
	
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
}
