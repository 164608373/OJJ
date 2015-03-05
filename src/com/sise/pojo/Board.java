package com.sise.pojo;

import java.sql.Timestamp;

/**
 * Board entity. @author MyEclipse Persistence Tools
 */

public class Board implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userId;
	private String message;
	private Timestamp posttime;

	// Constructors

	/** default constructor */
	public Board() {
	}

	/** full constructor */
	public Board(String userId, String message, Timestamp posttime) {
		this.userId = userId;
		this.message = message;
		this.posttime = posttime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getPosttime() {
		return this.posttime;
	}

	public void setPosttime(Timestamp posttime) {
		this.posttime = posttime;
	}

}