<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<title>查询成功</title>
<link rel="stylesheet" href="css/index.css?version=12321" />

</head>

<body>
	<div class="login_wrap">

		<img src="img/logowz.png">
	</div>

	<div class="login_box">

		<div class="login_form">
			<div class="login_title">
				<a href="Xiadan_insert.jsp" class="a1">查询成功</a> 
			</div>

			<div>
			
				<div class="wenzi1">
					下单信息为：<br>
					<c:forEach items="${selectByPhoneList}" var="xiadan" varStatus="status" >
					<div class="wenzi2">
					   第${status.count}条信息：
						<ul>
							<li>手机：${xiadan.getPhone()}</li>
						</ul>
						<ul>
							<li>姓名：${xiadan.getXm()}</li>
						</ul>
						<ul>
							<li>楼号：${xiadan.getLou()}</li>
						</ul>
						<ul>
							<li>宿舍：${xiadan.getSushe()}</li>
						</ul>
						<ul>
							<li>快递类型：${xiadan.getKdlx()}</li>
						</ul>
						<ul>
							<li>取货号：${xiadan.getQhh()}</li>
						</ul>
						<ul>
							<li>备注：${xiadan.getBeizhu()}</li>
						</ul>
							<div class="pp">
				<a href="Xiadan/deleteById?id=${xiadan.getId()}" class="a1">取消</a> 
			</div> 
					
					</div>
					 </c:forEach>  
				</div>
				<div class="pp">
				<a href="Xiadan_insert.jsp" class="a1">返回</a> 
			</div> 
		  </div>
	</div>
	</div>
</body>
</html>
