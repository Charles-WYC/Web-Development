<%@ page contentType="text/html;charset=gb2312" import="bean.UserBean"%>
<head>
	<link rel="stylesheet"  type="text/css"  href="style.css"/>
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
         <%UserBean user = (UserBean)session.getAttribute("user"); 
         	int i = 1;
         	JspWriter mout=pageContext.getOut();
         	if(user == null)
         	{
         		mout.print("<a>图书管理</a>&nbsp;&nbsp;");
         		mout.print("<a>用户管理</a>&nbsp;&nbsp;");
         		mout.print("<a>订单管理</a>&nbsp;&nbsp;");
         		mout.print("<a>个人信息</a>&nbsp;&nbsp;");
         		mout.print("<a>退出</a>");
         	}
         	else
         	{
         		mout.print("<a href='adminFindAllBooks'>图书管理</a>&nbsp;&nbsp;");
         		mout.print("<a href='findAllUser'>用户管理</a>&nbsp;&nbsp;");
         		mout.print("<a href='adminFindAllIndent'>订单管理</a>&nbsp;&nbsp;");
         		mout.print("<a href='adminInfo.jsp'>个人信息</a>&nbsp;&nbsp;");
         		mout.print("<a href='logoutProcess'>退出</a>");
         	}
         %>
         </td>
   </tr>
   <tr>
      <td><hr color="#9DC45F" size=3></td>
   </tr>
</table>
<table align="center" width=1100>