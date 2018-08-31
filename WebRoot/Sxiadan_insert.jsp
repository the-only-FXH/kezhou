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

<title>下单成功</title>
<link rel="stylesheet" href="css/index.css?version=12321" />

</head>

<body>
	<div class="login_wrap">

		<img src="img/logowz.png">
	</div>

	<div class="login_box">

		<div class="login_form">
			<div class="login_title">
				<a href="Xiadan_insert.jsp" class="a1">下单成功</a> 
			</div>

			<div>
				<div class="wenzi1">
					你的下单信息为：<br>
					<div class="wenzi2">
						<ul>
							<li>手机：${xiadan.phone}</li>
						</ul>
						<ul>
							<li>姓名：${xiadan.xm}</li>
						</ul>
						<ul>
							<li>楼号：${xiadan.lou}</li>
						</ul>
						<ul>
							<li>宿舍：${xiadan.sushe}</li>
						</ul>
						<ul>
							<li>快递类型：${xiadan.kdlx}</li>
						</ul>
						<ul>
							<li>取货号：${xiadan.qhh}</li>
						</ul>
						<ul>
							<li>备注：${xiadan.beizhu}</li>
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
