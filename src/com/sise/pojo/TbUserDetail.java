package com.sise.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * TbUserDetail entity. @author MyEclipse Persistence Tools
 */

public class TbUserDetail implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userName;
	private String sex;
	private String age;
	private String phone;
	private String addDate;
	private String success;
	private Set tbUsers = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbUserDetail() {
	}

	/** minimal constructor */
	public TbUserDetail(String userName, String sex, String age) {
		this.userName = userName;
		this.sex = sex;
		this.age = age;
	}

	/** full constructor */
	public TbUserDetail(String userName, String sex, String age, String phone,
			String addDate, String success, Set tbUsers) {
		this.userName = userName;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.addDate = addDate;
		this.success = success;
		this.tbUsers = tbUsers;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddDate() {
		return this.addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	public String getSuccess() {
		return this.success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public Set getTbUsers() {
		return this.tbUsers;
	}

	public void setTbUsers(Set tbUsers) {
		this.tbUsers = tbUsers;
	}

}