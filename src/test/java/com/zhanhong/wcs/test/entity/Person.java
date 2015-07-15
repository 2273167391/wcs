package com.zhanhong.wcs.test.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.zhanhong.wcs.test.tool.CustomDateDeserialize;
import com.zhanhong.wcs.test.tool.CustomDoubleSerialize;

@JsonIgnoreProperties(value={"userName"})//忽略指定属性
@JsonSerialize(include=Inclusion.NON_NULL)//忽略空值
public class Person implements Serializable{
	private String userName;
	private String password;
	@JsonIgnore//序列化时忽略该属性
	private String sex;
	
	//@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	private Double amount;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	public Date getBirthday() {
		return birthday;
	}
	
	@JsonDeserialize(using=CustomDateDeserialize.class)
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Double getAmount() {
		return amount;
	}
	
	@JsonSerialize(using=CustomDoubleSerialize.class)
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Person [userName=" + userName + ", password=" + password
				+ ", sex=" + sex + ", birthday=" + birthday + ", amount="
				+ amount + "]";
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String userName, String password, String sex, Date birthday,
			Double amount) {
		super();
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.amount = amount;
	}
	
}
