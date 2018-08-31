<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="user-scalable=no,width=device-width,initial-scale=1,maximum-scale=1">
<title>下单查询</title>
<link rel="stylesheet" type="text/css"
	href="css/xiadan1.css?version=23112 ">
<link rel="stylesheet" type="text/css"
	href="css/xiadan2.css?version=211112321">
	
   <script type="text/javascript" src="js/ajax.js"></script>
   <script type="text/javascript">
      function formcheck(){        
		var url="ajax.servlet";
		var userid=document.getElementById("phone").value;
		
		var params="userid="+userid;
		sendRequest(url,params,'POST',showresult);	
    }
  
    function showresult(){
        if (httpRequest.readyState == 4) { 
            
			if (httpRequest.status == 200) {
				var info=httpRequest.responseText;
				var a = new Array();
				a=info.split("//");
				if(a=="")
					alert("抱歉没有该手机号对应的注册信息,请重新注册即可");
				else
					{
                document.getElementById("xm").value=a[0];
                document.getElementById("lou").value=a[1];
                document.getElementById("sushe").value=a[2];
     
                }
			}
		}
}
</script>

</head>
<body background="img/4.jpg">
	<div class="login_cont">
		<div class="login_nav">
			<div>
				<img src="img/6.png" width="100%" height="100%">

			</div>
			<div class="ss">
				<a href="#" class="signup focus">当天下单查询</a> 
			</div>

		</div>
		<form action="Xiadan/selectByPhone" method="post">
			<div>
			<input type="text" placeholder="请输入手机号" name="phone" id="phone">
				
			
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
