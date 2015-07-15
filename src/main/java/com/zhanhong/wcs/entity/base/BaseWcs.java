package com.zhanhong.wcs.entity.base;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 基类
 * @author Arvin_Li
 *
 */
public class BaseWcs {
	private Integer creationBy;//创建人
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date creationDate;//创建时间
	private Integer lastUpdateBy;//修改人
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date lastUpdateDate;//修改时间
	public Integer getCreationBy() {
		return creationBy;
	}
	public void setCreationBy(Integer creationBy) {
		this.creationBy = creationBy;
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
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
}
