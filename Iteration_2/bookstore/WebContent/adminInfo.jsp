<%@ page contentType="text/html;charset=gb2312" import="bean.BookBean" import= "bean.UserBean"%>

<%@ include file="adminHeader.jsp"%>

<tr>
	<td>
		<table>
             <tr align="left">
                 <td>
					<% 
					out.println("<span>����ԱID:&nbsp;&nbsp;"+user.getUserID()+"</span><br><br>");
					out.println("<span>����Ա:&nbsp;&nbsp;&nbsp;&nbsp;"+user.getUsername()+"</span><br><br>");
					out.println("<span>����:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+user.getPassword()+"</span><br><br>");
					out.println("<span>���:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+user.getIdentity()+"</span><br><br>");
					out.println("<span>�ʼĵ�ַ:&nbsp;&nbsp;"+user.getMail_address()+"</span><br><br>");
					out.println("<span>����:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+user.getEmail()+"</span><br><br>");
					out.println("<span>���֤��:&nbsp;&nbsp;"+user.getID_number()+"</span><br><br>");
					out.println("<form action='editAdminInfo.jsp' method='post'>");
					out.println("<input type='submit' value='�޸�'>");
					out.println("</form>");
					%>
				</td>
			</tr>
		</table>
	</td>
</tr>