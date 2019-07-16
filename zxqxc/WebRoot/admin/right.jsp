<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'right.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <br>
  <br>
 
 
  
  <body style="text-align:center;font-size:40px;"><font face="华文琥珀"><font color="#0080ff">
  
<font color="#ffffff">
    </font></font>
    <div id="background" style="position:absolute;z-index:-1;width:100%;height:100%;top:0px;left:0px;"><img src="<%=path %>/images/left.png" width="100%" height="100%"/></div>
    <font size="7">欢迎进入进销存管理系统</font><br >
    
  </body>
</html>
