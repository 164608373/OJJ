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
    
    <title>留言板</title>
    <meta name="viewport" content="width=device-width">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/main.css">
	
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
  
<%--   <table border="1">
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
  
  
    主页内容<br> --%>
    		<!-- new -->
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
									<li class="active" role="presentation">
										<a href="index.jsp">
											<span class="glyphicon glyphicon-home"></span> 主页
										</a>
									</li>
									<li role="presentation">
										<a href="FAQ.jsp">
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
						<h3><span class="glyphicon glyphicon-list-alt"></span> 留言板</h3>

						<div class="main-content">
							<table class="table table-striped">
								<tr><th>
									<td>用户ID</td>
									<td>发表内容</td>
									<td>发表时间</td>
								</th></tr>
					  			<c:forEach  items="${boardlist}" var="message" >
								<tr><th>
										<td>${message.userId}</td>
										<td>${message.message}</td>
										<td>${message.posttime}</td>
								</tr></th>
								</c:forEach>
								
							</table>
							<script type="text/javascript">
						   		function goPage(sel){
						   			location.href='board_queryPage.action?curPage='+sel.value;
						   		}
						   	</script> 
							当前是第  ${page.currentPage }页
							
							<div class="btn-toolbar pull-right">
								<div class="btn-group">
									<button class="btn btn-default" onclick="location.href='board_queryPage.action?curPage=${page.currentPage-1 }';">上一页</button>
								</div>
								<div class="btn-group" role="group" aria-label="...">
  									<c:forEach begin="1" end="${page.totalPage }" var="v">
							    	<button type="button" class="btn btn-default" onclick="location.href='board_queryPage.action?curPage=${v}'">${v}</button>
							    	</c:forEach>
								</div>
								<div class="btn-group">
									<button class="btn btn-default" onclick="location.href='board_queryPage.action?curPage=${page.currentPage+1 }';">下一页</button>
									<button class="btn btn-default" onclick="location.href='post.jsp';">发布留言</button>
								</div>
								
								
								
							</div>
					</div>

				</div>
		</div>
		</div>
    
  </body>
</html>
