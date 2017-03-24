<%@ page contentType="text/html;charset=gb2312" pageEncoding="UTF-8" import="entity.User"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
	<link href="/bookstore_It3/css/style.css" rel="stylesheet" type="text/css" />
</head>

<table align="center" width=1100>
   <tr height="100">
      <td align="center"><h1>电子书店</h1></td>
   </tr>
   <tr>
      <td align="center"><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;管理员版</h3></td>
   </tr>
   <tr>
      <td align="center">
         <!-- 超链接的基本格式  -->
         <%User user = (User)session.getAttribute("user"); 
         	int i = 1;
         	JspWriter mout=pageContext.getOut();
         	if(user == null)
         	{
         		mout.print("<a>图书管理</a>&nbsp;&nbsp;");
         		mout.print("<a>用户管理</a>&nbsp;&nbsp;");
         		mout.print("<a>订单管理</a>&nbsp;&nbsp;");
         		mout.print("<a>销量统计</a>&nbsp;&nbsp;");
         		mout.print("<a>个人信息</a>&nbsp;&nbsp;");
         		mout.print("<a>退出</a>");
         	}
         	else
         	{
         		mout.print("<a href='/bookstore_It3/showBook.action'>图书管理</a>&nbsp;&nbsp;");
         		mout.print("<a href='/bookstore_It3/admin/showCustomer.action'>用户管理</a>&nbsp;&nbsp;");
         		mout.print("<a href='/bookstore_It3/admin/showOrder.action'>订单管理</a>&nbsp;&nbsp;");
         		mout.print("<a href='/bookstore_It3/admin/showSaleroom.jsp'>销量统计</a>&nbsp;&nbsp;");
         		mout.print("<a href='/bookstore_It3/admin/showInfo.jsp'>个人信息</a>&nbsp;&nbsp;");
         		mout.print("<a href='/bookstore_It3/logout.action'>退出</a>");
         	}
         %>
         </td>
   </tr>
   <tr>
      <td><hr color="#9DC45F" size=3></td>
   </tr>
</table>