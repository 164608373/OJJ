<%@ page language="java" import="java.util.*" pageEncoding="gbk"  contentType="text/html;charset=gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("gbk");
response.setCharacterEncoding("gbk");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�ύ����ҳ��</title>
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
 //��½�¼�
  $("#login").click(function(){
 	var id=$("#username").val(); //��ȡid
 	var pass=$("#password").val();//��ȡ����
 	//alert(id+":"+pass); ����
 	var url = "users_login.action?&userName="+id+"&password="+pass;
 	window.location.href=url;
   });
   
  //ע��
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
  <td><a href="board_queryPage.action">���԰�</a></td>
  <td><a href="problem_queryProblemuser.action">����</a></td>
  <td><a href="Register.jsp">ע��</a></td>
  <c:if test="${sessionScope.user != null}"><td>welcome</td></c:if>
  <c:if test="${sessionScope.user == null}"><td>Id<input id="username" name="userName" type="text"></td></c:if>
  </tr>
  <tr  align="center">
  <td><a href="">��ҳ</a></td>
  <td><a href="">�ύ����</a></td>
  <td><a href="users_loginCheck.action">�޸��û���Ϣ</a></td>
  <c:if test="${sessionScope.user != null}"><td><a href="">${sessionScope.user.userId}</a></td></c:if>
   <c:if test="${sessionScope.user == null}"><td>�� ��<input id="password" name="password" type="password"></td></c:if>
  </tr>
  <tr  align="center">
  <td><a href="">FAQ</a></td>
  <td><a href="">�ύ״̬</a></td>
   <td><a href="">���а�</a></td>
  <c:if test="${sessionScope.user != null}"><td><a href="users_logout.action">logout</a></td></c:if>
  <c:if test="${sessionScope.user == null}"><td><button id="login">��½</button><button id="register">ע��</button></td></c:if>
  </tr>
  <tr  align="center">
  <td><a href="">a</a></td>
  <td><a href="">a</a></td>
  <td><a href="">a</a></td>
   <td><a href="">a</a></td>
  </tr>
  </table>
  <br>
  
  
    <table border="0" width="980" ><tbody><tr><td>
<form method="POST" action="rejudge_run.action">
<p align="center"><font size="4" color="#333399">Submit Your Solution Via Web</font></p>
<p align="center">
Problem ID:<input type="text" name="problem_id" value="${problem.problemId}" size="20" accesskey="p" readonly="readonly"><br>
Language:<select size="1" name="language" style="width:100;" >
<option value="0" >G++</option>
<option value="1">GCC</option>
<option value="2">Pascal</option>
</select><br>
</p><p align="center">
Source: <br>
<textarea rows="30" name="submitCode" cols="79" accesskey="c"></textarea></p>
<div align="center">
<pre><input type="submit" value="Submit" name="submit" accesskey="s"><input type="reset" value="Reset" name="reset"></pre>
</div>
</form>
</td></tr></tbody></table>
  </body>
</html>
