<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
  <head>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<STYLE type=text/css>
	    body {margin-left: 0px;margin-top: 0px;margin-right: 0px;margin-bottom: 0px;}
        form{margin:0px;}
    </STYLE>
    <style>
	div{margin:0 auto;
	

	}
	.div1
	{
		width: 400px;
		height: 350px;
		border-color:#2A358A;
		border-style:solid;
		border-width: 16px;
		margin-top: 35px;
		margin-left:355px;
		background-color: aliceblue;
        text-align: center;
		
	}
	</style>
    
    
    <script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
    
    <script type="text/javascript">
       function ccc()
		{                                                                                         
		     if(document.ThisForm.userName.value=="")
			 {
			 	alert("请输入用户名");
				document.ThisForm.userName.focus();
				return false;
			 }
			 if(document.ThisForm.userPw.value=="")
			 {
			 	alert("请输入密码");
				document.ThisForm.userPw.focus();
				return false;
			 }
			 
			 loginService.login(document.ThisForm.userName.value,document.ThisForm.userPw.value,0,callback);
		}
		
		function callback(data)
		{
		    if(data=="no")
		    {
		        alert("用户名或密码错误");
		    }
		    if(data=="yes")
		    {
		        alert("通过验证,系统登录成功");
		        window.location.href="<%=path %>/admin/index.jsp";
		    }
		    
		}
		
		function qing()
		{
		    document.ThisForm.userName.value="";
		    document.ThisForm.userPw.value="";
		}
    </script>
  </head>
  
<body >
<div id="background" style="position:absolute;z-index:-1;width:100%;height:100%;top:0px;left:0px;"><img src="<%=path %>/images/back.gif" width="100%" height="100%"/></div>
<form method="post" action="<%=path %>/admin/index.jsp" name="ThisForm">
<br><br><br><br>
<div class="div1">
<br><br>
	        <p style="color: black;font-size: 22px;font-family: Microsoft Yahei;"><font face="隶书" size="6">中小企业进销存管理系统</font></p>
	        <br>
	          <font size="4"><b style="font-size: 18px; color: black;">账号：</b></font>
	          <input name="userName" type="text" style="width:222px;height:30px" >
	          <br><br><br>
	            <b style="font-size: 18px;color: black;">密码：</b>
	           <input name="userPw" type="password" style="width:222px;height:30px">
	          <br><br><br>
	          <p style="display:none">
	            <b style="font-size: 12px;">类型：</b>
	                <select name="userType" style="width:222px">
	                    <option value="0">0</option>
	                    <option value="1">1</option>
	                </select>
	           </p>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	       
<input type="button" value="登录" style="width: 80px;height:35px;font-size:16px;" onclick="ccc()"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="reset" value="重置" style="width: 80px;height:35px;font-size:16px;">
	               </div>
	               </form>
	               

</body>
</html>
