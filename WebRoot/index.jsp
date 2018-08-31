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

<title>客舟</title>
<link rel="stylesheet" href="css/index.css?version=1212　" />

</head>

<body>
	<div class="login_wrap">

		<img src="img/logowz.png">
	</div>

	<div class="login_box">

		<div class="login_form">
			<div class="login_title">
				<a href="Xiadan_insert.jsp" class="focus">下单</a> 
				<a href="Xiadan_select.jsp" class="focus">查询</a>
				<a href="Xiadan_delete.jsp" class="focus">取消下单</a>
			</div>

			<div>
				<div class="wenzi1">
					下单需知<br>
					<div class="wenzi2">
											<ul>
							<li>当天下午六点之前下单</li>
<li>新功能：注册。大家可以自由注册，注册过之后下次下单就可以只输入手机号</li>

						</ul>
					</div>
				</div>

				<div class="wenzi1">
					收费标准<br>
					<div class="wenzi2">
<ul>
							<li>晴天两元每件
</li>
							<li>雨天三元每件
</li>
							<li>大件酌情加费
</li>
						</ul>
					</div>
				</div>

				<div class="wenzi1">
					送达时间<br>
					<div class="wenzi2">
						<ul>
							<li>晚上8：00-11：00为派送时间
</li>
<li>如果当天晚上没有收到快递，请于次日中午12点之前与我们联系
</li>
<li>有问题次日12点之前与我们联系的将为您负责到底
</li>
<li>超时请恕不予处理
</li>
						</ul>
					</div>
				</div>

				<div class="wenzi1">
					与我联系<br>
					<div class="wenzi2">
						<ul>
							<li>客服电话：18792434300</li>
<li>用户QQ一群：252363211</li>
<li>用户QQ二群：641742396</li>
						</ul>
					</div>
				</div>
			</div>



		</div>
	</div>
</body>
</html>
