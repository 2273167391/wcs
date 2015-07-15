package com.zhanhong.wcs.entity.use;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.zhanhong.wcs.entity.base.BaseWcs;

/**
 * 用户实体类
 * @author Arvin_Li
 *
 */
@Alias(value="user")
@JsonIgnoreProperties(value={"version"})
@JsonSerialize(include=Inclusion.NON_NULL)
public class WcsUseUser extends BaseWcs{
	private Integer userId;//用户ID
	private String userCode;//用户编码
	private String userName;//户名
	private String mobileTelephone;//手机
	private String homeTelephone;//家庭电话
	private String idCard;//身份证号
	private String status;//用户状态
	private String userType;//用户类型
	private Integer streetId;//居住街道
	private String homeAddress;//详细地址
	private String remarks;//备注
	private Integer version;//版本
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobileTelephone() {
		return mobileTelephone;
	}
	public void setMobileTelephone(String mobileTelephone) {
		this.mobileTelephone = mobileTelephone;
	}
	public String getHomeTelephone() {
		return homeTelephone;
	}
	public void setHomeTelephone(String homeTelephone) {
		this.homeTelephone = homeTelephone;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Integer getStreetId() {
		return streetId;
	}
	public void setStreetId(Integer streetId) {
		this.streetId = streetId;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
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
	public WcsUseUser() {
		super();
	}
	
}
