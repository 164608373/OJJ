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
    
    <title>编辑问题页面</title>
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
   <table width="780">
  <tr align="center" ><td>问题id</td><td>题目</td><td>编辑</td><td>发表时间</td><td>删除</td></tr>
  			<tr>
  				<c:forEach  items="${problemlist}" var="problem" >
				<tr >
					<th>${problem.problemId}</th>
					<th><a href="">${problem.title}</a></th>
					<th><a href="">编辑</a></th>
					<th>${problem.inDate}</th>
					<th><a href="problem_deleteProblem.action?problemId=${problem.problemId}">删除</a></th>
				</tr>
					</c:forEach>
			</tr>
  			<tr>
  				<th colspan="3"><center>
  					<a href="problem_queryProblemadmin.action?curPage=1" style='TEXT-DECORATION:none;'>&nbsp;首页&nbsp;</a>
    <a href="problem_queryProblemadmin.action?curPage=${page.currentPage-1 }" style='TEXT-DECORATION:none;'>&nbsp;上一页&nbsp;</a>
    <a href="problem_queryProblemadmin.action?curPage=${page.currentPage+1 }" style='TEXT-DECORATION:none;'>&nbsp;下一页&nbsp;</a>
    <a href="problem_queryProblemadmin.action?curPage=${page.totalPage }" style='TEXT-DECORATION:none;'>&nbsp;尾页&nbsp;</a>
   	<script type="text/javascript">
   		function goPage(sel){
   			location.href='problem_queryProblemadmin.action?curPage='+sel.value;
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
 
  <br>
  
  <br>
  <a href="admin.jsp">返回管理员主页</a>
  </body>
</html>
