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
	
  </head>
  
  <body>
  	<br><br><br><br><br><br><br><br><br><br>
  	<form action="users_register.action" method="post">
  	<table border="1" align="center">
  		<tr>
  		<td>I d：</td><td><input id="username" name="userName" type="text"></td>
  		</tr>
  		<tr>
  		<td>小 名:</td><td><input id="nickName" name="nickName" type="text"></td>
  		</tr>
  		<tr>
  		<td>密  码：</td><td><input id="password" name="password" type="password"></td>
  		</tr>
  		<tr>
  		<td>重复密码：</td><td><input id="repassword" name="repassword" type="password"></td>
  		</tr>
  		<tr>
  		<td>学 校：</td><td><input id="school" name="school" type="text"></td>
  		</tr>
  		<tr>
  		<td>Email：</td><td><input id="email" name="email" type="text"></td>
  		</tr>
  		<tr>
  			<td colspan="2" align="right"><input type="button" value="提交" onclick="submit()"/><input type="button" value="重置"/></td>
  		</tr>

  	</table>
  		<center><h3><font color="red">${requestScope.msg}</font></h3></center>
  	</form>
  </body>
</html>
