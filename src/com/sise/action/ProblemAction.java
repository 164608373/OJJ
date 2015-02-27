package com.sise.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sise.service.imp.ProblemService;

public class ProblemAction extends ActionSupport{
 //problem控制层对象
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProblemService problemService;//problem服务层实现对象
	
	private String problemid;//问题id
	private String title;//题目
	private String input;//输入
	private String output;//输出
	private String inputpath;//输入路径
	private String outputpath;//输出路径
	private String sample_input;//案例输入
	private String sample_output;//案例输出
	private String hint;//提示
	
	public ProblemService getProblemService() {
		return problemService;
	}
	public void setProblemService(ProblemService problemService) {
		this.problemService = problemService;
	}
	public String getProblemid() {
		return problemid;
	}
	public void setProblemid(String problemid) {
		this.problemid = problemid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getInputpath() {
		return inputpath;
	}
	public void setInputpath(String inputpath) {
		this.inputpath = inputpath;
	}
	public String getOutputpath() {
		return outputpath;
	}
	public void setOutputpath(String outputpath) {
		this.outputpath = outputpath;
	}
	public String getSample_input() {
		return sample_input;
	}
	public void setSample_input(String sample_input) {
		this.sample_input = sample_input;
	}
	public String getSample_output() {
		return sample_output;
	}
	public void setSample_output(String sample_output) {
		this.sample_output = sample_output;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	
	/**
	 * 添加问题
	 * @return
	 */
	public String addProblem(){
		return null;
	}
	
	/**
	 * 查询问题
	 */
	public String queryProblem(){
		return null;
	}
	/**
	 * 修改问题
	 */
	public String editProblem(){
		return null;
	}
	/**
	 * 删除问题
	 */
	public String deleteProblem(){
		return null;
	}

}
