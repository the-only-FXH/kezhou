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
<title>客舟下单</title>
<link rel="stylesheet" type="text/css"
	href="css/xiadan1.css?version=23232 ">
<link rel="stylesheet" type="text/css"
	href="css/xiadan2.css?version=23223 ">
	
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
			    if(a!="")
                {document.getElementById("xm").value=a[0];
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
			<div class="nav_slider">
				<a href="#" class="signup focus">客舟下单</a> <a href="Zhuce_insert.jsp"
					class="signup focus">用户注册</a>

			</div>

		</div>
		<form action="Xiadan/insert" method="post">
			<div>
			    <input type="text" placeholder="手机号" name="xiadan.phone" id="phone" onblur="formcheck()">
				<input type="text" placeholder="姓名" name="xiadan.xm" id="xm"> 
				<select name="xiadan.lou" id="lou">
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
				<input type="text" placeholder="宿舍号" name="xiadan.sushe" id="sushe">
				<select id="kdlx" name="xiadan.kdlx">
					
					<option value="未选择">请选择快递类型</option>
					<option value="12号楼圆通">12号楼圆通</option>
					<option value="12号楼天天">12号楼天天</option>
					<option value="12号楼韵达">12号楼韵达</option>
					<option value="12号楼中通">12号楼中通</option>
					<option value="12号楼申通">12号楼申通</option>
					<option value="12号楼宅急送">12号楼宅急送</option>
					<option value="12号楼黄马甲">12号楼黄马甲</option>
					<option value="12号楼百世">12号楼百世</option>
					<option value="1号楼顺丰">1号楼顺丰</option>
					<option value="京东">京东快递</option>	
					
				</select> 
				<input type="text" placeholder="取货号" name="xiadan.qhh" id="qhh">

				<input type="text" placeholder="请再次输入取货号"  id="rqhh">

				
				 <font color="#7FFFD4"><br>备注：（若为临时放在上述快递代取点的快递请在此处注明,非当天快递也请注明快递时间在下面注明）</font>
				<textarea rows="5" cols="38" name="xiadan.beizhu">
				</textarea>
				<input type="submit" id="submit" class="button" name="button"
					value="确认下单">
			</div>
			<div class="qq">
				<a href="index.jsp" class="signup focus">返回</a>
			</div>
		</form>

	</div>
<script type="text/javascript" src="js1/form1.js?version=223"></script> 
</body>
</html>
