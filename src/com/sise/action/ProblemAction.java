package com.sise.action;

import java.sql.Timestamp;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sise.pojo.Problem;
import com.sise.service.imp.ProblemService;
import com.sise.util.Page;

public class ProblemAction extends ActionSupport{
 //problem控制层对象
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProblemService problemService;//problem服务层实现对象
	
	private String problemId;//问题id
	private String title;//题目
	private String input;//输入
	private String output;//输出
	private String inputpath;//输入路径
	private String outputpath;//输出路径
	private String sample_input;//案例输入
	private String sample_output;//案例输出
	private String hint;//提示
	private String timelimit;//时间限制
	private String memorylimit;//内存限制
	private String description;//描述
	
	private String curPage;
	private Page page;
	private String message;
	private List<Problem> problemlist;
	private Problem problem;
	
	public ProblemService getProblemService() {
		return problemService;
	}
	public void setProblemService(ProblemService problemService) {
		this.problemService = problemService;
	}
	
	
	
	public Problem getProblem() {
		return problem;
	}
	public void setProblem(Problem problem) {
		this.problem = problem;
	}
	public String getProblemId() {
		return problemId;
	}
	public void setProblemId(String problemId) {
		this.problemId = problemId;
	}
	public String getCurPage() {
		return curPage;
	}
	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Problem> getProblemlist() {
		return problemlist;
	}
	public void setProblemlist(List<Problem> problemlist) {
		this.problemlist = problemlist;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTimelimit() {
		return timelimit;
	}
	public void setTimelimit(String timelimit) {
		this.timelimit = timelimit;
	}
	public String getMemorylimit() {
		return memorylimit;
	}
	public void setMemorylimit(String memorylimit) {
		this.memorylimit = memorylimit;
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
		Problem problem = new Problem();
		
		problem.setDescription(description);
		problem.setHint(hint);
		problem.setInDate(new Timestamp(System.currentTimeMillis()));
		problem.setInput(input);
		problem.setOutput(output);
		problem.setInputPath("D:/data/temp");
		problem.setOutputPath("D:/data/temp");
		problem.setMemoryLimit(Integer.valueOf(memorylimit));
		problem.setTitle(title);
		problem.setSampleInput(sample_input);
		problem.setSampleOutput(sample_output);
		problem.setTimeLimit(Integer.valueOf(timelimit));
		problem.setRatio(new Short("0"));
		problem.setDifficulty(new Short("0"));
		problem.setAccepted(0);
		problem.setSolved(0);
		problem.setSubmit(0);
		
		problemService.addProblem(problem);
		
		return "addProblemOK";
	}
	
	/**
	 * 管理员查询问题
	 */
	public String queryProblemadmin(){
		//获取当前页数
		 page=new Page();
		
		
		int totalCount = 0;
		//获取有多少条留言
		totalCount = problemService.getMessageCount();
		
		//存好总条数进入page对象中
		page.setTotalCount(totalCount);
		
		if(curPage!=null){
			page.setCurrentPage(Integer.valueOf(curPage));
		}
		
		//分页查询留言板信息
		try {
			problemlist = problemService.queryPage(page);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "queryokadmin";
	}
	
	/**
	 * 用户查询问题
	 */
	public String queryProblemuser(){
		//获取当前页数
		 page=new Page();
		
		
		int totalCount = 0;
		//获取有多少条留言
		totalCount = problemService.getMessageCount();
		
		//存好总条数进入page对象中
		page.setTotalCount(totalCount);
		
		if(curPage!=null){
			page.setCurrentPage(Integer.valueOf(curPage));
		}
		
		//分页查询留言板信息
		try {
			problemlist = problemService.queryPage(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "queryokuser";
	}
	
	/**
	 * 修改问题
	 */
	public String updateProblem(){
		Problem problem = new Problem();
		problem.setProblemId(Integer.valueOf(problemId));
	
		problem.setDescription(description);
		problem.setHint(hint);
		problem.setInDate(new Timestamp(System.currentTimeMillis()));
		problem.setInput(input);
		problem.setOutput(output);
		problem.setInputPath("D:/data/temp");
		problem.setOutputPath("D:/data/temp");
		problem.setMemoryLimit(Integer.valueOf(memorylimit));
		problem.setTitle(title);
		problem.setSampleInput(sample_input);
		problem.setSampleOutput(sample_output);
		problem.setTimeLimit(Integer.valueOf(timelimit));
		problem.setRatio(new Short("0"));
		problem.setDifficulty(new Short("0"));
		problem.setAccepted(0);
		problem.setSolved(0);
		problem.setSubmit(0);
		
		
		problemService.updateProblem(problem);
		
		return "updateProblemOk";
	}
	/**
	 * 删除问题
	 */
	public String deleteProblem(){
		
		Problem problem = new Problem();
		
		problem.setProblemId(Integer.valueOf(problemId));
		
		problemService.deleteProblem(problem);
		
		return "deleteOk";
	}

	/**
	 * 根据问题id查询问题到编辑问题页面
	 * @return
	 */
	public String queryProblem(){
		problem = problemService.queryProblem(problemId);
		return "queryOk";
	}
	
	/**
	 * 根据问题id查询问题到用户页面
	 * @return
	 */
	public String queryProblemUser(){
		problem = problemService.queryProblem(problemId);
		return "queryProblemUser";
	}
	
	/**
	 * 根据问题id跳转到提交问题前页面
	 * @return
	 */
	public String queryProblemPreSubmit(){
		problem = problemService.queryProblem(problemId);
		return "presubmit";
	}
	
}
