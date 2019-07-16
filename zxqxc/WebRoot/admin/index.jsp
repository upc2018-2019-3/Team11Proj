<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
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
	<link href="<%=path %>/css/default.css" rel="stylesheet" type="text/css">
	<STYLE type=text/css>
	    
    </STYLE>
    <script type="text/javascript">
       function switchSysBar()
       {
			if (document.getElementById("switchPoint").src.indexOf("bar_arrow.gif")!=-1)
			{
				document.getElementById("switchPoint").src="<%=path %>/images/bar_arrow_r.gif";
				document.getElementById("frmTitle").style.display="none";
			}
			else
			{
				document.getElementById("switchPoint").src="<%=path %>/images/bar_arrow.gif";
				document.getElementById("frmTitle").style.display="";
			}
       }
       
       function tuichu()
       {
           var url="<%=path %>/login.jsp";
           window.location.href=url;
       }
    </script>
    
    <script language="JavaScript">
		window.resizeTo(screen.width-10, screen.height-30);
		window.moveTo(0,0)
    </script>
  </head>
  
<body> 
<div id="background" style="position:absolute;z-index:-1;width:100%;height:80%;top:0px;left:0px;"><img src="<%=path %>/images/kong.gif" width="100%" height="30%"/></div>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr> 
    <td height="1" class="line_bg"></td> 
  </tr> 
  <tr> 
    <!-- <td height="120" valign="top" style="background-color: #2894FF">  -->
    <td height="120" valign="top" >
    <TABLE WIDTH=778 BORDER=0 CELLPADDING=0 CELLSPACING=0> 
        <TR> 
          <TD><div style="margin-left: 30px;margin-top: 35px;font-family: 微软雅黑;font-size: 22px;"> 
                                                  <font face="隶书" size="6">中小企业进销存管理系统</font> 
          </div></TD> 
          <c:if test="${sessionScope.userType==0 }">
          <TD> 
             <div style="margin-top: 60px;"> 
                                              <font size="4" face="宋体">  欢迎您：管理员</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" style="font-size:17px;face:宋体" onclick="tuichu()">退出系统</a></font>
             </div>
          </TD> 
          </c:if>
          
          
          <c:if test="${sessionScope.userType==1 }">
          <TD> 
             <div style="margin-top: 60px;"><font size="4">  
                                                <font size="5">欢迎您：${sessionScope.bumen.mingcheng }&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" style="" onclick="tuichu()">退出系统</a></font></font>
             </div>
          </TD> 
          </c:if>
        </TR> 
     </TABLE>
     </td> 
  </tr> 
  <tr> 
    <td height="1" class="line_bg"></td> 
  </tr> 
  <tr> 
    <td valign="top">
	<TABLE border=0 cellPadding=0 cellSpacing=0 height="100%" width="100%" > 
        <TR> 
          <TD height="100%" valign="top" id="frmTitle" name="frmTitle">
		     <IFRAME scrolling='auto' frameBorder=0 id=BoardTitle name="menuTree" 
		        src="<%=path %>/admin/left.jsp" style="HEIGHT: 100%; VISIBILITY: inherit; WIDTH: 150px; Z-INDEX: 2;" target="main" >
		     </IFRAME>
		  </td> 
          <TD width="8" align="center" background="<%=path %>/images/left.png"  onclick="switchSysBar();"
             class="line_right" style="cursor:hand">
             <img src="<%=path %>/images/bar_arrow.gif" width="8" height="8" id="switchPoint">
          </td> 
          <TD style="width:100%;HEIGHT:100%">
             <IFRAME frameBorder=0 id="main" name="main" scrolling="yes" src="<%=path %>/admin/right.jsp" 
                style="HEIGHT: 100%; VISIBILITY: inherit; WIDTH: 100%; Z-INDEX: 1">
             </IFRAME>
          </TD> 
        </TR> 
      </TABLE>
    </td> 
  </tr> 
</table> 


</body>
</html>
