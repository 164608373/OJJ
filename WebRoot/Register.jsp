<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册页面</title>
    
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
  
  <table border="1">
  <tr>
  <td>online judge</td>
  <td>Problem Set</td>
   <td>Authors</td>
   <td>User</td>
  </tr>
  <tr align="center">
  <td><a href="board_queryPage.action">留言板</a></td>
  <td><a href="">问题</a></td>
  <td><a href="user/Register.jsp">注册</a></td>
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
