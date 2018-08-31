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

<title>注册成功</title>
<link rel="stylesheet" href="css/index.css?version=12321" />

</head>

<body>
	<div class="login_wrap">

		<img src="img/logowz.png">
	</div>

	<div class="login_box">

		<div class="login_form">
			<div class="login_title">
				<a href="Xiadan_insert.jsp" class="a1">更新成功</a> 
			</div>

			<div>
				<div class="wenzi1">
					你的注册信息为：<br>
					<div class="wenzi2">
						<ul>
							<li>手机：${zhuce.zphone}</li>
						</ul>
						<ul>
							<li>姓名：${zhuce.zxm}</li>
						</ul>
						<ul>
							<li>楼号：${zhuce.zlou}</li>
						</ul>
						<ul>
							<li>宿舍：${zhuce.zsushe}</li>
						</ul>
					</div>
				</div>
				<div class="pp">
				<a href="Xiadan_insert.jsp" class="a1">返回</a> 
			</div> 
		  </div>
	</div>
	</div>
</body>
</html>
