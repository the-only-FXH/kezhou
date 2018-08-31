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

<title>注册失败</title>
<link rel="stylesheet" href="css/index.css?version=12321" />

</head>

<body>
	<div class="login_wrap">

		<img src="img/logowz.png">
	</div>

	<div class="login_box">

		<div class="login_form">
			<div class="login_title">
				<a href="#" class="a1">注册失败！</a> 
			</div>

			<div>
				<div class="wenzi1">
					该手机号已经被注册过了<br>
				
				</div>
				<div class="pp">
				<a href="Xiadan_insert.jsp" class="a1">返回</a> 
			</div> 
		  </div>
	</div>
	</div>
</body>
</html>
