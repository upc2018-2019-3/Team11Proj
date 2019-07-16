<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		<script type="text/javascript" src="<%=path %>/js/public.js"></script>
		<script type="text/javascript" src="<%=path %>/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="<%=path %>/js/popup.js"></script>
        <script language="javascript">
           function baosunDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/baosunDel.action?id="+id;
               }
           }
           
           function baosunAdd()
           {
                 var url="<%=path %>/admin/baosun/baosunAdd.jsp";
				 window.location.href=url;
           }
           
           function p()
           {
               window.print();
           }
       </script>
	</head>

	<body leftmargin="8" topmargin="8" background='<%=path %>/images/allbg.gif'>
	<div id="background" style="position:absolute;z-index:-1;width:100%;height:100%;top:0px;left:0px;"><img src="<%=path %>/images/left.png" width="100%" height="100%"/></div>
			<table width="90%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="18" background="<%=path %>/images/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="4%">序号</td>
					<td width="15%">物品</td>
					<td width="10%">数量</td>
					<td width="10%">产生时间</td>
					
					<td width="10%">备注信息</td>
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.baosunList}" var="baosun" varStatus="sta">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${ss.index+1}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${baosun.goods.mingcheng}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${baosun.shuliang}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${baosun.shijian}
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
					    ${baosun.beizhu}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="删除" onclick="baosunDel(${baosun.id})"/>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<input type="button" value="添加报损信息" style="width: 123px;margin-top: 10px;" onclick="baosunAdd()" />
			
	</body>
</html>
