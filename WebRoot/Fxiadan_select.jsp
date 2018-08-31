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

<title>查询失败</title>
<link rel="stylesheet" href="css/index.css?version=12321" />

</head>

<body>
	<div class="login_wrap">

		<img src="img/logowz.png">
	</div>

	<div class="login_box">

		<div class="login_form">
			<div class="login_title">
				<a href="Xiadan_insert.jsp" class="a1">查询失败</a> 
			</div>

			<div>
				<div class="wenzi1">
					该手机号今日未下单！<br>
					</div>
				</div>
				<div class="pp">
				<a href="Xiadan_insert.jsp" class="a1">返回</a> 
			</div> 
		  </div>
	</div>

</body>
</html>
