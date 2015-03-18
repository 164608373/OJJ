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
    
    <title>添加问题页面</title>
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

  </head>
  
  <body>
  
 
  <br>
  <form method="POST" action="problem_addProblem.action">
<p align="center"><font size="4" color="#333399">Add a Problem</font></p>
<input type="hidden" name="problem_id" value="New" >
<p align="left">Problem Id:<input type="text" name="problemId" size="20" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"></p>
<p align="left">Title:<textarea name="title" rows="1" cols="71"></textarea></p>
<p align="left">Time Limit:<input type="text" name="timelimit" size="20" value="1000">MS</p>
<p align="left">Memory Limit:<input type="text" name="memorylimit" size="20" value="65536">KByte</p>
<p align="left">Description:<br><textarea rows="13" name="description" cols="120"></textarea></p>
<p align="left">Input:<br><textarea rows="13" name="input" cols="120"></textarea></p>
<p align="left">Output:<br><textarea rows="13" name="output" cols="120"></textarea></p>
<p align="left">Sample Input:<br><textarea rows="13" name="sample_input" cols="120"></textarea></p>
<p align="left">Sample Output:<br><textarea rows="13" name="sample_output" cols="120"></textarea></p>
<p align="left">test1 Input:<br><textarea rows="13" name="test1_input" cols="120"></textarea></p>
<p align="left">test1 Output:<br><textarea rows="13" name="test1_output" cols="120"></textarea></p>
<p align="left">test2 Input:<br><textarea rows="13" name="test2_input" cols="120"></textarea></p>
<p align="left">test2 Output:<br><textarea rows="13" name="test2_output" cols="120"></textarea></p>
<p align="left">test3 Input:<br><textarea rows="13" name="test3_input" cols="120"></textarea></p>
<p align="left">test3 Output:<br><textarea rows="13" name="test3_output" cols="120"></textarea></p>

<p align="left">Hint:<br><textarea rows="13" name="hint" cols="120"></textarea></p>

<div align="center">
<input type="submit" value="Submit" name="submit">
</div></form>
  <br>
  <a href="admin.jsp">返回管理员主页</a>
  </body>
</html>
