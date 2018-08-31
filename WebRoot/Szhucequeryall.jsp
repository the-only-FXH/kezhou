<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="po.Zhuce"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   </head>
<link href="css/icheck_skins/all.css" rel="stylesheet" />
<link rel="stylesheet" href="css/bootstrap-fileupload.css" />
<link rel="stylesheet" href="css/tabs.css" />
<link rel="stylesheet" href="css/layout.css" />
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/table.css" />
<link rel="stylesheet" href="css/font-awesome.css" />
<style>

</style>
  <body>
  
        <span>你要查询的数据表中共有${count}条记录</span>
     
        <table  align="center" border="5">
            <tr>
                <th>记录条数</th>
              <th>电话</th>
                <th>姓名</th>
                <th>楼</th>
                <th>宿舍</th>
            </tr>
       <c:forEach items="${allInfo}" var="zhuce" varStatus="status" >
      	 <tr>      
      		<td>${status.count}</td>
        	<td>${zhuce.getZphone()}</td>
        	<td>${zhuce.getZxm()}</td>
        	<td>${zhuce.getZlou()}</td>
           <td>${zhuce.getZsushe()}</td>
         	
     	 </tr>
   	   </c:forEach>     
        </table>
           
  </body>
</html>
