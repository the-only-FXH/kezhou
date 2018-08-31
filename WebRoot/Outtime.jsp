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

<title>已过下单时间</title>
<link rel="stylesheet" href="css/index.css?version=12213" />

</head>

<body>
	<div class="login_wrap">

		<img src="img/logowz.png">
	</div>

	<div class="login_box">

		<div class="login_form">
			<div class="login_title">
				<a href="#" class="a1">已过下单时间</a> 
			</div>

			<div>
				<div class="wenzi1">
抱歉！已过下单时间，不能下单或取消下单。请于每日下午六点半之前下单
				</div>
				<div class="pp">
				<a href="index.jsp" class="a1">返回</a> 
			</div> 
		  </div>
	</div>
	</div>
</body>
</html>
