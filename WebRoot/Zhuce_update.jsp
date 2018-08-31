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
<title>用户注册</title>
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
				<a href="#" class="signup focus">注册信息修改</a> 
			</div>

		</div>
		<form action="Zhuce/update" method="post">
			<div>
			<input type="text" placeholder="手机号" name="zhuce.zphone" id="phone"  onblur="formcheck()">
				<input type="text" placeholder="姓名" name="zhuce.zxm" id="xm"> 
				<select name="zhuce.zlou" id="lou">
					<option value="未选择">请选择宿舍楼号</option>
					<option value="1号楼">1号楼</option>
					<option value="2号楼">2号楼</option>
					<option value="3号楼">3号楼</option>
					<option value="4号楼">4号楼</option>
					<option value="5号楼">5号楼（送到楼下）</option>
					<option value="6号楼女">6号楼女（送到楼下）</option>
					<option value="6号楼男">6号楼男</option>
					<option value="7号楼">7号楼</option>
					<option value="8号楼">8号楼</option>
					<option value="9号楼男">9号楼男</option>
					<option value="9号楼女">9号楼女</option>
					<option value="10号楼">10号楼</option>
					<option value="11号楼">11号楼</option>
					<option value="12号楼">12号楼</option>
					<option value="13号楼">13号楼</option>
					<option value="14号楼">14号楼</option>
					<option value="15号楼">15号楼</option>
					<option value="16号楼">16号楼</option>
					<option value="17号楼">17号楼</option>
				</select> 
				<input type="text" placeholder="宿舍号" name="zhuce.zsushe" id="sushe"> 
				
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
