<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=gb2312" pageEncoding="UTF-8" import="entity.User"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
	<link href="/bookstore_It3/css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="/bookstore_It3/js/ajaxJson.js"></script>
</head>

<table align="center" width=1100>
   <tr height="100">
      <td align="center"><h1>电子书店</h1></td>
   </tr>
   <tr>
      <td align="center"><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户版</h3></td>
   </tr>
   <tr>
      <td>
         <!-- 超链接的基本格式  -->
         <%User user = (User)session.getAttribute("user"); 
         	int i = 1;
         	JspWriter mout=pageContext.getOut();
         	if(user == null)
         	{
         		mout.print("<a>全部图书</a>&nbsp;&nbsp;");
         		mout.print("<a>购物车</a>&nbsp;&nbsp;");
         		mout.print("<a>我的订单</a>&nbsp;&nbsp;");
         		mout.print("<a>个人信息</a>&nbsp;&nbsp;");
         		mout.print("<a>退出</a>");
         	}
         	else
         	{
         		mout.print("<a href='/bookstore_It3/showBook.action'>全部图书</a>&nbsp;&nbsp;");
         		mout.print("<a href='/bookstore_It3/customer/showCart.action'>购物车</a>&nbsp;&nbsp;");
         		mout.print("<a href='/bookstore_It3/customer/showOrder.action'>我的订单</a>&nbsp;&nbsp;");
         		mout.print("<a href='/bookstore_It3/customer/showInfo.action'>个人信息</a>&nbsp;&nbsp;");
         		mout.print("<a href='/bookstore_It3/logout.action'>退出</a>");
         	}
         %>
         </td>
   </tr>
   <tr>
      <td><hr color="#9DC45F" size=3></td>
   </tr>
</table>