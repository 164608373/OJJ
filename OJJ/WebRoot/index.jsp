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
    
    <title>主页</title>
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
 	var url = "user/Register.jsp";
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
  <td><a href="">留言板</a></td>
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
  
  
    主页内容<br>
  </body>
</html>
