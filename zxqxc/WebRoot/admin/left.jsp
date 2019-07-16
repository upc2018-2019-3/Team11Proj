<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="StyleSheet" href="<%=path %>/css/dtree.css" type="text/css" />
	<script type="text/javascript" src="<%=path %>/js/dtree.js"></script>

  </head>
  <c:if test="${sessionScope.userType==0 }">
  <body leftmargin="2" topmargin="10">
  <div id="background" style="position:absolute;z-index:-1;width:100%;height:100%;top:0px;left:0px;"><img src="<%=path %>/images/left.png" width="100%" height="100%"/></div>
    <script type="text/javascript">
		d = new dTree('d');
        d.add(0,-1,'系统导航菜单');
        
        
        
        d.add(1,0,'修改登陆密码','');
    	d.add(101,1,'修改登陆密码','<%=path %>/admin/userinfo/userPw.jsp','','main');
	
    	d.add(2,0,'类别信息管理','');
    	d.add(203,2,'类别信息管理','<%=path %>/catelogMana.action','','main');
    	d.add(204,2,'添加类别信息','<%=path %>/admin/catelog/catelogAdd.jsp','','main');
    	
    	
    	
    	d.add(3,0,'物品信息管理','');
    	d.add(305,3,'物品信息管理','<%=path %>/goodsMana.action','','main');
    	d.add(306,3,'添加物品信息','<%=path %>/admin/goods/goodsAdd.jsp','','main');
		
    	
    	
    	
    	
    	
    	d.add(6,0,'进货信息管理','');
		d.add(601,6,'进货信息管理','<%=path %>/rukuMana.action','','main');
    	d.add(602,6,'添加进货信息','<%=path %>/admin/ruku/rukuAdd.jsp','','main');
    	
    	
    	
    	d.add(7,0,'销售信息管理','');
		d.add(701,7,'销售信息管理','<%=path %>/chukuMana.action','','main');
    	d.add(702,7,'添加销售信息','<%=path %>/admin/chuku/chukuAdd.jsp','','main');
    	
    	
    	
    	d.add(8,0,'库存盘点查询','');
		d.add(801,8,'库存盘点查询','<%=path %>/admin/tongji/tongjiPre.jsp','','main');
		
		
		d.add(9,0,'报损信息模块','');
		d.add(902,9,'报损信息管理','<%=path %>/baosunMana.action','','main');
		d.add(903,9,'添加报损信息','<%=path %>/admin/baosun/baosunAdd.jsp','','main');
		
		
    	
		document.write(d);
		d.openAll();
   </script>
</body>
</c:if>



<c:if test="${sessionScope.userType==1 }">
  
</c:if>

</html>
