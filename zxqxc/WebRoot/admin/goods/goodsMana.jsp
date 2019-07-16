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
		
        <script language="javascript">
           function goodsDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/goodsDel.action?id="+id;
               }
           }
           
           
           function goodsAdd()
           {
                 var url="<%=path %>/admin/goods/goodsAdd.jsp";
				 window.location.href=url;
           }
           
           function over(picPath)
	       {
			  if (picPath=="")picPath="/images/default.jpg";
			  x = event.clientX;
			  y = event.clientY;      
			  document.all.tip.style.display = "block";
			  document.all.tip.style.top = y;
			  document.all.tip.style.left = x+10;
			  document.all.photo.src = ".."+picPath; 
		   }
		   function out()
	       {
			  document.all.tip.style.display = "none";
		   }	
		   
       </script>
	</head>

	<body leftmargin="8" topmargin="8" background='<%=path %>/img/allbg.gif'>
	<div id="background" style="position:absolute;z-index:-1;width:100%;height:100%;top:0px;left:0px;"><img src="<%=path %>/images/left.png" width="100%" height="100%"/></div>
			<table width="99%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="14" background="<%=path %>/img/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="4%">序号</td>
					<td width="10%">类别</td>
					<td width="10%">编号</td>
					<td width="15%">名称</td>
					<td width="10%">单位</td>
										
					<td width="20%">详细信息</td>
					<td width="10%">备注</td>
					<td width="7%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.goodsList}" var="goods" varStatus="sta">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${ss.index+1}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${goods.catelog.name}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${goods.bianhao}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${goods.mingcheng}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${goods.danwei}
					</td>
					
					
					<td bgcolor="#FFFFFF" align="center">
						${goods.beizhu}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					   <div onmouseover = "over('<%=path %>/${goods.fujian}')" onmouseout = "out()" style="cursor:hand;">
							图片
					   </div>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="删除" onclick="goodsDel(${goods.id})"/>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<br/>
			<input type="button" value="添加物品" style="width: 123px;" onclick="goodsAdd()" />
			
			<div id="tip" style="position:absolute;display:none;border:0px;width:80px; height:80px;">
				<TABLE id="tipTable" border="0" bgcolor="#ffffee">
					<TR align="center">
						<TD><img id="photo" src="" height="80" width="80"></TD>
					</TR>
				</TABLE>
			</div>
	</body>
</html>
