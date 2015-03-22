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
    
    <title>登陆页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/main.css">
	
	
	<script type="text/javascript" src="js/index.js"></script>
  </head>
  
  <body>
  <div class="container-fluid">
			<div class="row">
				<div class="col-md-2 sidebar-container">
					<div class="side-bar">
						<div class="sidebar-brand">
							<h1><span class="glyphicon glyphicon-fire"></span></h1>
						</div>
						<ul class="nav nav-stacked">
							<li>Home
								<ul class="nav nav-stacked">
									<li  role="presentation">
										<a href="board_queryPage.action">
											<span class="glyphicon glyphicon-list-alt"></span> 留言板
										</a>
									</li>
									<li  role="presentation">
										<a href="index.jsp">
											<span class="glyphicon glyphicon-home"></span> 主页
										</a>
									</li>
									<li role="presentation">
										<a href="">
											<span class="glyphicon glyphicon-question-sign"></span> FAQ
										</a>
									</li>
								</ul>
							</li>
							<li>Porfile
								<ul class="nav nav-stacked">
									<li role="presentation">
										<a href="problem_queryProblemuser.action">
											<span class="glyphicon glyphicon-text-background"></span> 问题
										</a>
									</li>
									<li role="presentation">
										<a href="">
											<span class="glyphicon glyphicon-edit"></span> 提交问题
										</a>
									</li>
									<li role="presentation">
										<a href="compileinfo_pageQuery.action">
											<span class="glyphicon glyphicon-paste"></span> 提交状态
										</a>
									</li>
								</ul>
							</li>
							<li>Message
								<ul class="nav nav-stacked">
									<li role="presentation">
										<a href="Register.jsp">
											<span class="glyphicon glyphicon-check"></span> 注册
										</a>
									</li>
									<li role="presentation">
										<a href="users_loginCheck.action">
											<span class="glyphicon glyphicon-user"></span> 修改用户信息
										</a>
									</li>
									<li role="presentation">
										<a href="">
											<span class="glyphicon glyphicon-flag"></span> 排行榜
										</a>
									</li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
				<div class="col-md-10 nopd">
					<nav class="navbar navbar-ojj">
						<div class="container-fluid">
							 <c:if test="${sessionScope.user != null}">
							 <ul class="nav navbar-nav navbar-right">
								<li><p class="navbar-text">Hi~</p></li>
								<li><a href="">用户：${sessionScope.user.userId}</a>
								<li><a href="users_logout.action">注销</a>
							</ul>
							 </c:if>
							<c:if test="${sessionScope.user == null}">
							<ul class="nav navbar-nav navbar-right">
								<li><a href="login.jsp">登录</a>
								</li>
								<li><a href="Register.jsp">注册</a></li>
							</ul>
							 </c:if>
						</div>
					</nav>

					<div class="content">
						
						<div class="logon-container">
					<form  action="users_login.action" method="post">
						<div class="logon-brand">
							<h1 align="center">登陆</h1>
						</div>
  						<div class="form-group">
    						<label for="exampleInputEmail1">Account ID</label>
    						<input type="text" class="form-control" id="userName" name="userName" placeholder="Enter Account ID">
  						</div>
  						<div class="form-group">
    						<label for="exampleInputPassword1">Password</label>
    						<input type="password" class="form-control" id="password" name="password" placeholder="Password">
  						</div>
  						<button id="login" type="submit" class="btn btn-primary">登陆</button>
  						<button id="reset" type="reset" class="btn btn-primary">重置</button>
  						<br>
  						<font color="red">${requestScope.msg}</font>
  						<center><h3><font color="red">
				  		<c:if test="${requestScope.msg == null}">
				  		 请登录
						</c:if>
						</font></h3></center>
					</form>
				</div>

					</div>

				</div>
		</div>
		</div>
  </body>
</html>
