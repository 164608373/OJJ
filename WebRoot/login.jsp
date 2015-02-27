<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/login.js"></script>
  </head>
  
  <body>
  <table border="1">
  <tr>
  <td>online judge</td>
  <td>online Exercise</td>
   <td>Exercise author</td>
  </tr>
  <tr align="center">
  <td><a href="">留言板</a></td>
  <td><a href="">问题</a></td>
  <td>Id<input id="username" name="userName" type="text"></td>
  </tr>
  <tr  align="center">
  <td><a href="">主页</a></td>
  <td><a href="">提交状态</a></td>
  <td>密 码<input id="password" name="password" type="password"></td>
  </tr>
  <tr  align="center">
  <td><a href="">FAQ</a></td>
  <td><a href="">排行榜</a></td>
  <td><button id="login">登陆</button><button>注册</button></td>
  </tr>
  <tr  align="center">
  <td><a href="">a</a></td>
  <td><a href="">a</a></td>
  <td><a href="">a</a></td>
  </tr>
  </table>
  	<br>
  	<form action="users_login.action" method="post">
  	<table border="1" align="center">
  		<tr>
  		<td>I d：</td><td><input id="username" name="userName" type="text"></td>
  		</tr>
  		<tr>
  		<td>密  码：</td><td><input id="password" name="password" type="password"></td>
  		</tr>
  		<tr>
  			<td colspan="2" align="right"><input type="button" value="提交" onclick="submit()"/><input type="button" value="重置"/></td>
  		</tr>

  	</table>
  		<center><h3><font color="red">${requestScope.msg}</font></h3></center>
  	</form>
  </body>
</html>
