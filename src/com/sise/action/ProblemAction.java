package com.sise.action;

import java.sql.Timestamp;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sise.pojo.Problem;
import com.sise.service.imp.ProblemService;
import com.sise.util.FileTool;
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
	private String test1_input;//测试1输入
	private String test1_output;//测试1输出
	private String test2_input;//测试2输入
	private String test2_output;//测试2输出
	private String test3_input;//测试3输入
	private String test3_output;//测试3输出
	
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
	
	
	
	public String getTest1_input() {
		return test1_input;
	}
	public void setTest1_input(String test1_input) {
		this.test1_input = test1_input;
	}
	public String getTest1_output() {
		return test1_output;
	}
	public void setTest1_output(String test1_output) {
		this.test1_output = test1_output;
	}
	public String getTest2_input() {
		return test2_input;
	}
	public void setTest2_input(String test2_input) {
		this.test2_input = test2_input;
	}
	public String getTest2_output() {
		return test2_output;
	}
	public void setTest2_output(String test2_output) {
		this.test2_output = test2_output;
	}
	public String getTest3_input() {
		return test3_input;
	}
	public void setTest3_input(String test3_input) {
		this.test3_input = test3_input;
	}
	public String getTest3_output() {
		return test3_output;
	}
	public void setTest3_output(String test3_output) {
		this.test3_output = test3_output;
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
		//先根据问题id判断问题id是否存在
		if(true == problemService.existProblem(problemId) ){
			return "addproblemFail";
		}
		
		//添加问题
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
		
		FileTool fileTool = new FileTool();

		String testpath = "D:\\data\\test\\"+problemId+"\\";
		
		//为测试用例创建对比文件
		fileTool.createContent(testpath);
		
		
		//测试用例1
		problem.setTest1Input(test1_input);
		problem.setTest1Output(test1_output);
		
		if(test1_input.trim() != null && !test1_input.trim().equals("")){
			//输入文件
			fileTool.createFile(testpath+"1.in");
			fileTool.write( testpath+"1.in",test1_input);
			
			//输出文件
			fileTool.createFile(testpath+"1.out");
			fileTool.write(testpath+"1.out", test1_output);
		}
		
		//测试用例2
		problem.setTest2Input(test2_input);
		problem.setTest2Output(test2_output);
		if(test2_input.trim() != null && !test2_input.trim().equals("")){
			//输入文件
			fileTool.createFile(testpath+"2.in");
			fileTool.write( testpath+"2.in",test2_input);
			
			//输出文件
			fileTool.createFile(testpath+"2.out");
			fileTool.write(testpath+"2.out", test2_output);
		}
		
		//测试用例3
		problem.setTest3Input(test3_input);
		problem.setTest3Output(test3_output);
		if(test3_input.trim() != null && !test3_input.trim().equals("")){
			//输入文件
			fileTool.createFile(testpath+"3.in");
			fileTool.write( testpath+"3.in",test3_input);
			
			//输出文件
			fileTool.createFile(testpath+"3.out");
			fileTool.write(testpath+"3.out", test3_output);
		}
		
		
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
		
		
		FileTool fileTool = new FileTool();

		String testpath = "D:\\data\\test\\"+problemId+"\\";
		
		//为测试用例创建对比文件
		
		
		//测试用例1
		problem.setTest1Input(test1_input);
		problem.setTest1Output(test1_output);
		
		if(test1_input.trim() != null && !test1_input.trim().equals("")){
			//输入文件
			fileTool.createFile(testpath+"1.in");
			fileTool.write( testpath+"1.in",test1_input);
			
			//输出文件
			fileTool.createFile(testpath+"1.out");
			fileTool.write(testpath+"1.out", test1_output);
		}
		
		//测试用例2
		problem.setTest2Input(test2_input);
		problem.setTest2Output(test2_output);
		if(test2_input.trim() != null && !test2_input.trim().equals("")){
			//输入文件
			fileTool.createFile(testpath+"2.in");
			fileTool.write( testpath+"2.in",test2_input);
			
			//输出文件
			fileTool.createFile(testpath+"2.out");
			fileTool.write(testpath+"2.out", test2_output);
		}
		
		//测试用例3
		problem.setTest3Input(test3_input);
		problem.setTest3Output(test3_output);
		if(test3_input.trim() != null && !test3_input.trim().equals("")){
			//输入文件
			fileTool.createFile(testpath+"3.in");
			fileTool.write( testpath+"3.in",test3_input);
			
			//输出文件
			fileTool.createFile(testpath+"3.out");
			fileTool.write(testpath+"3.out", test3_output);
		}
		
		problemService.updateProblem(problem);
		
		return "updateProblemOk";
	}
	/**
	 * 删除问题
	 */
	public String deleteProblem(){
		
		Problem problem = new Problem();
		
		problem.setProblemId(Integer.valueOf(problemId));
		
		//删除测试文件
		FileTool fileTool = new FileTool();

		fileTool.DeleteFolder("D:\\data\\test\\"+problemId);
		
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
