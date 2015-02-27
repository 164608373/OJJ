<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>打印用户信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/printUser.js"></script>
</head>

<body onload="loadUser()">
	<p>&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot; ?&gt;</p>
<p>&lt;user&gt;</p>
<p> &lt;id&gt;<font id="user_id"></font>&lt;/id&gt;
<p>&lt;username&gt;<font id="user_name"></font>&lt;username&gt;</p>
<p>&lt;sex&gt;<font id="user_sex"></font>&lt;/sex&gt;</p>
<p>&lt;age&gt;<font id="user_age"></font>&lt;/age&gt;</p>
<p>&lt;phone&gt;<font id="user_phone"></font>&lt;/phone&gt;</p>
<p>&lt;addDate&gt;<font id="user_addDate"></font>&lt;/addDate&gt;</p>
<p>&lt;success&gt;<font id="user_success"></font>&lt;/success&gt;</p>
<p>&lt;/user&gt;</p>

</body>
</html>
