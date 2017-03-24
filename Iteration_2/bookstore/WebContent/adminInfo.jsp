<%@ page contentType="text/html;charset=gb2312" import="bean.BookBean" import= "bean.UserBean"%>

<%@ include file="adminHeader.jsp"%>

<tr>
	<td>
		<table>
             <tr align="left">
                 <td>
					<% 
					out.println("<span>管理员ID:&nbsp;&nbsp;"+user.getUserID()+"</span><br><br>");
					out.println("<span>管理员:&nbsp;&nbsp;&nbsp;&nbsp;"+user.getUsername()+"</span><br><br>");
					out.println("<span>密码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+user.getPassword()+"</span><br><br>");
					out.println("<span>身份:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+user.getIdentity()+"</span><br><br>");
					out.println("<span>邮寄地址:&nbsp;&nbsp;"+user.getMail_address()+"</span><br><br>");
					out.println("<span>邮箱:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+user.getEmail()+"</span><br><br>");
					out.println("<span>身份证号:&nbsp;&nbsp;"+user.getID_number()+"</span><br><br>");
					out.println("<form action='editAdminInfo.jsp' method='post'>");
					out.println("<input type='submit' value='修改'>");
					out.println("</form>");
					%>
				</td>
			</tr>
		</table>
	</td>
</tr>