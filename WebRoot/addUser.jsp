<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>增加用户</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/addUser.js"></script>
  </head>
  
  <body>
    <br><br>
   
    <form action="" id="addUserForm" >
     <table>
    	<tr align="center">
    	<td>用户名:</td><td><input type="text" id="username"></td>
    	</tr>
    	<tr >
    	<td align="center">性别：</td><td><select id="sex"><option value="m">男</option><option value="f">女</option></select></td>
    	</tr >
    	<tr align="center">
    	<td>年龄:</td><td><input type="text" id="age"></td>
    	</tr>
    	<tr align="center">
    	<td>联系电话:</td><td><input type="text" id="phone"></td>
    	</tr>
    	<tr align="center">
    	<td>加入时间:</td><td><input type="text" id="addDate"></td>
    	</tr>
    	<tr>
    		<td>
    			<input value = "保 存" type="button" onclick="addUser()">
    			<input value = "重 置" type="button" onclick="reset()">
    		</td>
    	</tr>
    </table>
    </form>
  
    
  </body>
</html>
