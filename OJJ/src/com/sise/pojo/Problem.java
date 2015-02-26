package com.sise.pojo;

import java.sql.Timestamp;

/**
 * Problem entity. @author MyEclipse Persistence Tools
 */

public class Problem implements java.io.Serializable {

	// Fields

	private Integer problemId;
	private String title;
	private String description;
	private String input;
	private String output;
	private String inputPath;
	private String outputPath;
	private String sampleInput;
	private String sampleOutput;
	private String hint;
	private String source;
	private String sampleProgram;
	private Timestamp inDate;
	private Integer timeLimit;
	private Integer memoryLimit;
	private String defunct;
	private Integer contestId;
	private Integer accepted;
	private Integer submit;
	private Short ratio;
	private Integer error;
	private Short difficulty;
	private Integer submitUser;
	private Integer solved;
	private Integer caseTimeLimit;

	// Constructors

	/** default constructor */
	public Problem() {
	}

	/** minimal constructor */
	public Problem(Integer problemId, String title, Integer timeLimit,
			Integer memoryLimit, String defunct, Short ratio, Short difficulty,
			Integer caseTimeLimit) {
		this.problemId = problemId;
		this.title = title;
		this.timeLimit = timeLimit;
		this.memoryLimit = memoryLimit;
		this.defunct = defunct;
		this.ratio = ratio;
		this.difficulty = difficulty;
		this.caseTimeLimit = caseTimeLimit;
	}

	/** full constructor */
	public Problem(Integer problemId, String title, String description,
			String input, String output, String inputPath, String outputPath,
			String sampleInput, String sampleOutput, String hint,
			String source, String sampleProgram, Timestamp inDate,
			Integer timeLimit, Integer memoryLimit, String defunct,
			Integer contestId, Integer accepted, Integer submit, Short ratio,
			Integer error, Short difficulty, Integer submitUser,
			Integer solved, Integer caseTimeLimit) {
		this.problemId = problemId;
		this.title = title;
		this.description = description;
		this.input = input;
		this.output = output;
		this.inputPath = inputPath;
		this.outputPath = outputPath;
		this.sampleInput = sampleInput;
		this.sampleOutput = sampleOutput;
		this.hint = hint;
		this.source = source;
		this.sampleProgram = sampleProgram;
		this.inDate = inDate;
		this.timeLimit = timeLimit;
		this.memoryLimit = memoryLimit;
		this.defunct = defunct;
		this.contestId = contestId;
		this.accepted = accepted;
		this.submit = submit;
		this.ratio = ratio;
		this.error = error;
		this.difficulty = difficulty;
		this.submitUser = submitUser;
		this.solved = solved;
		this.caseTimeLimit = caseTimeLimit;
	}

	// Property accessors

	public Integer getProblemId() {
		return this.problemId;
	}

	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInput() {
		return this.input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return this.output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getInputPath() {
		return this.inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

	public String getOutputPath() {
		return this.outputPath;
	}

	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}

	public String getSampleInput() {
		return this.sampleInput;
	}

	public void setSampleInput(String sampleInput) {
		this.sampleInput = sampleInput;
	}

	public String getSampleOutput() {
		return this.sampleOutput;
	}

	public void setSampleOutput(String sampleOutput) {
		this.sampleOutput = sampleOutput;
	}

	public String getHint() {
		return this.hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSampleProgram() {
		return this.sampleProgram;
	}

	public void setSampleProgram(String sampleProgram) {
		this.sampleProgram = sampleProgram;
	}

	public Timestamp getInDate() {
		return this.inDate;
	}

	public void setInDate(Timestamp inDate) {
		this.inDate = inDate;
	}

	public Integer getTimeLimit() {
		return this.timeLimit;
	}

	public void setTimeLimit(Integer timeLimit) {
		this.timeLimit = timeLimit;
	}

	public Integer getMemoryLimit() {
		return this.memoryLimit;
	}

	public void setMemoryLimit(Integer memoryLimit) {
		this.memoryLimit = memoryLimit;
	}

	public String getDefunct() {
		return this.defunct;
	}

	public void setDefunct(String defunct) {
		this.defunct = defunct;
	}

	public Integer getContestId() {
		return this.contestId;
	}

	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}

	public Integer getAccepted() {
		return this.accepted;
	}

	public void setAccepted(Integer accepted) {
		this.accepted = accepted;
	}

	public Integer getSubmit() {
		return this.submit;
	}

	public void setSubmit(Integer submit) {
		this.submit = submit;
	}

	public Short getRatio() {
		return this.ratio;
	}

	public void setRatio(Short ratio) {
		this.ratio = ratio;
	}

	public Integer getError() {
		return this.error;
	}

	public void setError(Integer error) {
		this.error = error;
	}

	public Short getDifficulty() {
		return this.difficulty;
	}

	public void setDifficulty(Short difficulty) {
		this.difficulty = difficulty;
	}

	public Integer getSubmitUser() {
		return this.submitUser;
	}

	public void setSubmitUser(Integer submitUser) {
		this.submitUser = submitUser;
	}

	public Integer getSolved() {
		return this.solved;
	}

	public void setSolved(Integer solved) {
		this.solved = solved;
	}

	public Integer getCaseTimeLimit() {
		return this.caseTimeLimit;
	}

	public void setCaseTimeLimit(Integer caseTimeLimit) {
		this.caseTimeLimit = caseTimeLimit;
	}

}