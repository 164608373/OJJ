package com.sise.pojo;

import java.sql.Timestamp;

/**
 * Compileinfo entity. @author MyEclipse Persistence Tools
 */

public class Compileinfo implements java.io.Serializable {

	// Fields

	private Integer solutionId;
	private String error;
	private Integer userId;
	private Integer problemId;
	private String language;
	private Timestamp submitTime;
	private Integer codeLength;
	private Integer time;
	private Integer result;

	// Constructors

	/** default constructor */
	public Compileinfo() {
	}

	/** minimal constructor */
	public Compileinfo(Integer userId, Integer problemId, String language,
			Timestamp submitTime, Integer codeLength, Integer time,
			Integer result) {
		this.userId = userId;
		this.problemId = problemId;
		this.language = language;
		this.submitTime = submitTime;
		this.codeLength = codeLength;
		this.time = time;
		this.result = result;
	}

	/** full constructor */
	public Compileinfo(String error, Integer userId, Integer problemId,
			String language, Timestamp submitTime, Integer codeLength,
			Integer time, Integer result) {
		this.error = error;
		this.userId = userId;
		this.problemId = problemId;
		this.language = language;
		this.submitTime = submitTime;
		this.codeLength = codeLength;
		this.time = time;
		this.result = result;
	}

	// Property accessors

	public Integer getSolutionId() {
		return this.solutionId;
	}

	public void setSolutionId(Integer solutionId) {
		this.solutionId = solutionId;
	}

	public String getError() {
		return this.error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProblemId() {
		return this.problemId;
	}

	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Timestamp getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}

	public Integer getCodeLength() {
		return this.codeLength;
	}

	public void setCodeLength(Integer codeLength) {
		this.codeLength = codeLength;
	}

	public Integer getTime() {
		return this.time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Integer getResult() {
		return this.result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

}