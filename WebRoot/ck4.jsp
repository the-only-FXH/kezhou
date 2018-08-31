<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询东区12号楼总单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <center>
  <a href="Xiadan/selectbydate"><font size="5">当天总单</font></a>
  <a href="Xiadan/selectbydate1"><font size="5">昨日总单</font></a>
  <a href="Xiadan/selectbydate2"><font size="5">东区12号楼快递</font></a>
  <a href="Xiadan/selectbydate3"><font size="5">西区快递</font></a>
 
   </center>
    <span><font size="5">下单记录共有${count3}条</font></span>
     
        <table  align="center" border="5" width="100%">
                <tr>
           	                <td width="30">下单记录</td>
				<td width="135">姓名</td>
				<td width="80">楼号</td>
				<td width="50">宿舍号</td>
				<td width="130">取货号</td>
				<td width="100">快递类型</td>
				<td width="100">联系电话</td>
				<td>备注</td>
                            
            </tr>
<c:forEach items="${list3}" var="xiadan" varStatus="status" >
      	 <tr>      
      		<td>${status.count}</td>
        	
        	<td>${xiadan.getXm()}</td>
        	<td>${xiadan.getLou()}</td>
           <td>${xiadan.getSushe()}</td>
           <td>${xiadan.getQhh()}</td>
         	<td>${xiadan.getKdlx()}</td>
     	 <td>${xiadan.getPhone()}</td>
     	 <td>${xiadan.getBeizhu()}</td>
     	 </tr>
   	   </c:forEach>  
   	   </table>   
  </body>
</html>
