package com.sise.pojo;

/**
 * TbUser entity. @author MyEclipse Persistence Tools
 */

public class TbUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private TbUserDetail tbUserDetail;
	private String userName;
	private String password;
	private String number;
	private String flag;

	// Constructors

	/** default constructor */
	public TbUser() {
	}

	/** minimal constructor */
	public TbUser(Integer id, TbUserDetail tbUserDetail, String userName,
			String password) {
		this.id = id;
		this.tbUserDetail = tbUserDetail;
		this.userName = userName;
		this.password = password;
	}

	/** full constructor */
	public TbUser(Integer id, TbUserDetail tbUserDetail, String userName,
			String password, String number, String flag) {
		this.id = id;
		this.tbUserDetail = tbUserDetail;
		this.userName = userName;
		this.password = password;
		this.number = number;
		this.flag = flag;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TbUserDetail getTbUserDetail() {
		return this.tbUserDetail;
	}

	public void setTbUserDetail(TbUserDetail tbUserDetail) {
		this.tbUserDetail = tbUserDetail;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}