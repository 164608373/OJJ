<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>问题列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/jquery.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript">
$(document).ready(function(){
 //登陆事件
  $("#login").click(function(){
 	var id=$("#username").val(); //获取id
 	var pass=$("#password").val();//获取密码
 	//alert(id+":"+pass); 调试
 	var url = "users_login.action?&userName="+id+"&password="+pass;
 	window.location.href=url;
   });
   
  //注册
  $("#register").click(function(){
 	var url = "Register.jsp";
 	window.location.href=url;
   }); 
   
});
</script>
  </head>
  
  <body>
  
  <table border="1">
  <tr>
  <td>online judge</td>
  <td>Problem Set</td>
   <td>Authors</td>
   <td>User</td>
  </tr>
  <tr align="center">
  <td><a href="board_queryPage.action">留言板</a></td>
  <td><a href="problem_queryProblemuser.action">问题</a></td>
  <td><a href="Register.jsp">注册</a></td>
  <c:if test="${sessionScope.user != null}"><td>welcome</td></c:if>
  <c:if test="${sessionScope.user == null}"><td>Id<input id="username" name="userName" type="text"></td></c:if>
  </tr>
  <tr  align="center">
  <td><a href="">主页</a></td>
  <td><a href="">提交问题</a></td>
  <td><a href="users_loginCheck.action">修改用户信息</a></td>
  <c:if test="${sessionScope.user != null}"><td><a href="">${sessionScope.user.userId}</a></td></c:if>
   <c:if test="${sessionScope.user == null}"><td>密 码<input id="password" name="password" type="password"></td></c:if>
  </tr>
  <tr  align="center">
  <td><a href="">FAQ</a></td>
  <td><a href="">提交状态</a></td>
   <td><a href="">排行榜</a></td>
  <c:if test="${sessionScope.user != null}"><td><a href="users_logout.action">logout</a></td></c:if>
  <c:if test="${sessionScope.user == null}"><td><button id="login">登陆</button><button id="register">注册</button></td></c:if>
  </tr>
  <tr  align="center">
  <td><a href="">a</a></td>
  <td><a href="">a</a></td>
  <td><a href="">a</a></td>
   <td><a href="">a</a></td>
  </tr>
  </table>
  <br>
   <form method="POST" action="problem_queryProblemPreSubmit.action">
<p align="center"><font size="4" color="#333399"> Problem</font></p>
<input type="hidden" name="problemId" value="${requestScope.problem.problemId}" >
<p align="left">Problem Id:${requestScope.problem.problemId}</p>
<p align="left">Title:<textarea name="title" rows="1" cols="71" disabled="disabled">${requestScope.problem.title}</textarea></p>
<p align="left">Time Limit:<input type="text" name="timelimit" size="20" value="${requestScope.problem.timeLimit}" disabled="disabled">MS</p>
<p align="left">Memory Limit:<input type="text" name="memorylimit" size="20" value="${requestScope.problem.memoryLimit}" disabled="disabled">KByte</p>
<p align="left">Description:<br><textarea rows="13" name="description" cols="120" disabled="disabled">${requestScope.problem.description}</textarea></p>
<p align="left">Input:<br><textarea rows="13" name="input" cols="120" disabled="disabled">${requestScope.problem.input}</textarea></p>
<p align="left">Output:<br><textarea rows="13" name="output" cols="120" disabled="disabled">${requestScope.problem.output}</textarea></p>
<p align="left">Sample Input:<br><textarea rows="13" name="sample_input" cols="120" disabled="disabled">${requestScope.problem.sampleInput}</textarea></p>
<p align="left">Sample Output:<br><textarea rows="13" name="sample_output" cols="120" disabled="disabled">${requestScope.problem.sampleOutput}</textarea></p>
<p align="left">Hint:<br><textarea rows="13" name="hint" cols="120" disabled="disabled">${requestScope.problem.hint}</textarea></p>

<div align="center">
<input type="submit" value="提交" name="submit">
</div></form>
 
  </body>
</html>
