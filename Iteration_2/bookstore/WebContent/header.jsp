<%@ page contentType="text/html;charset=gb2312" import="bean.UserBean"%>

<head>
	<link rel="stylesheet"  type="text/css"  href="style.css"/>
</head>

<table  align="center" width=1100>
   <tr height="100">
      <td align="center"><h1>�������</h1></td>
   </tr>
   <tr>
      <td align="center"><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�û���</h3></td>
   </tr>
   <tr>
      <td>
         <!-- �����ӵĻ�����ʽ  -->
         <%UserBean user = (UserBean)session.getAttribute("user"); 
         	int i = 1;
         	JspWriter mout=pageContext.getOut();
         	if(user == null)
         	{
         		mout.print("<a>ȫ��ͼ��</a>&nbsp;&nbsp;");
         		mout.print("<a>���ﳵ</a>&nbsp;&nbsp;");
         		mout.print("<a>�ҵĶ���</a>&nbsp;&nbsp;");
         		mout.print("<a>������Ϣ</a>&nbsp;&nbsp;");
         		mout.print("<a>�˳�</a>");
         	}
         	else
         	{
         		mout.print("<a href='findAllBooks'>ȫ��ͼ��</a>&nbsp;&nbsp;");
         		mout.print("<a href='findCart'>���ﳵ</a>&nbsp;&nbsp;");
         		mout.print("<a href='findIndent'>�ҵĶ���</a>&nbsp;&nbsp;");
         		mout.print("<a href='userInfo.jsp'>������Ϣ</a>&nbsp;&nbsp;");
         		mout.print("<a href='logoutProcess'>�˳�</a>");
         	}
         %>
         </td>
   </tr>
   <tr>
      <td><hr color="#9DC45F" size=3></td>
   </tr>
</table>
<table align="center" width=1100>