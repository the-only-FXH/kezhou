<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
  <%
  
  
    int k,m;
   Date date=new Date();
  if(date.getHours()>=18&&date.getHours()<=24)
response.sendRedirect("Outtime.jsp");

  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="user-scalable=no,width=device-width,initial-scale=1,maximum-scale=1">
<title>取消下单</title>
<link rel="stylesheet" type="text/css"
	href="css/xiadan1.css?version=23112 ">
<link rel="stylesheet" type="text/css"
	href="css/xiadan2.css?version=211112321">
</head>
<body background="img/4.jpg">
	<div class="login_cont">
		<div class="login_nav">
			<div>
				<img src="img/6.png" width="100%" height="100%">

			</div>
			<div class="ss">
				<a href="#" class="signup focus">取消下单</a> 
			</div>

		</div>
		<form action="Xiadan/delete" method="post">
			<div>
			<input type="text" placeholder="手机号" name="phone" id="phone">
				<input type="text" placeholder="取货号" name="qhh" id="qhh"> 
				
				
				
				<input type="submit" id="submit" class="button" name="button" value="确定">
						
			</div>
		</form>
	<div class="qq">
				<a href="Xiadan_insert.jsp" class="signup focus">返回</a>


			</div>
	</div>
	<!-- <script type="text/javascript" src="js1/form.js"></script>  -->

</body>
</html>
