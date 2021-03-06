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
  <table width="780">
  <tr align="center" ><td>问题id</td><td>题目</td><td>发表时间</td></tr>
  			<tr>
  				<c:forEach  items="${problemlist}" var="problem" >
				<tr >
					<th>${problem.problemId}</th>
					<th><a href="problem_queryProblemUser.action?problemId=${problem.problemId}">${problem.title}</a></th>
					<th>${problem.inDate}</th>
				</tr>
					</c:forEach>
			</tr>
  			<tr>
  				<th colspan="3"><center>
  					<a href="problem_queryProblemuser.action?curPage=1" style='TEXT-DECORATION:none;'>&nbsp;首页&nbsp;</a>
    <a href="problem_queryProblemuser.action?curPage=${page.currentPage-1 }" style='TEXT-DECORATION:none;'>&nbsp;上一页&nbsp;</a>
    <a href="problem_queryProblemuser.action?curPage=${page.currentPage+1 }" style='TEXT-DECORATION:none;'>&nbsp;下一页&nbsp;</a>
    <a href="problem_queryProblemuser.action?curPage=${page.totalPage }" style='TEXT-DECORATION:none;'>&nbsp;尾页&nbsp;</a>
   	<script type="text/javascript">
   		function goPage(sel){
   			location.href='problem_queryProblemuser.action?curPage='+sel.value;
   		}
   	</script> 
    当前是第
    <select onchange="goPage(this)">
	    <c:forEach begin="1" end="${page.totalPage }" var="v">
	    	<c:if test="${v == page.currentPage}">
	    		<option value="${v }" selected="selected">${v }</option>
	    	</c:if>
	    	<c:if test="${v != page.currentPage}">
	    		<option value="${v }" >${v }</option>
	    	</c:if>
	    </c:forEach>
    </select> 
    页 
  				</center></th>
  			</tr>
  			
  			<tr>
  				<th colspan="3">
  					总页数:【${page.totalPage }】页&nbsp;总条数:【${page.totalCount }】条
  				</th>
  			</tr>
  			
  		</table>
 
  </body>
</html>
