<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>userDetail</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/userDetail.js"></script>

  </head>
  
  <body>
    <br><br><br><br><br><br><br>
    <table align="center" border="1" width="100%" id="myTable">
    	<tr bgcolor="gray" align="center">
    		<td>编号</td><td>用户名</td><td>性别</td><td>年龄</td><td>联系电话</td><td>加入时间</td><td>成功登陆次数</td><td>锁定状态</td>
		</tr>
		<c:forEach items = "${requestScope.userInfos }" var = "r" varStatus="s">
								<tr align="center">
									<td><input type="radio"  name="id" value="${r.id}" onclick="changeId('${r.id}','${r.userName}','${r.age}','${r.sex}','${r.addDate}','${r.phone}','${r.success}')"><input id="user_id" type="hidden"></td>
									<td><center>${r.userName}<input id="user_name" type="hidden"></center></td>
									<td align="center">
										<c:if test="${r.sex == 'm'}">
										男
										</c:if>
										<c:if test="${r.sex != 'm'}">
										女
										</c:if>
										<input id="user_sex" type="hidden">
									</td>
									<td><center>${r.age}<input id="user_age" type="hidden"></center></td>
									<td><center>${r.phone}<input id="user_phone" type="hidden"></center></td>
									<td><center>${r.addDate}<input id="user_addDate" type="hidden"></center></td>
									<td><center>${r.success}<input id="user_success" type="hidden"></center></td>
									<td align="center">
										<c:if test="${r.flag == '1'}">
										<input value="解锁" type="button" onclick="openLock('${r.id}')">
										</c:if>
										<c:if test="${r.flag != '1'}">
										未锁
										</c:if>
									</td>
								</tr>
								</c:forEach>
		
		<!-- 这里用jstl做遍历 -->
		
		<tr>
			<td colspan="8" align="center">
				<input type="button" value="添加" onclick="addUser()">
				<input type="button" value="修改" onclick="updateUser()">
				<input type="button" value="删除" onclick="deleteUser()">
				<input type="button" value="打印" onclick="printUser()">
			</td>
		</tr>
    </table>
  </body>
</html>
