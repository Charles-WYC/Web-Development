<%@ page contentType="text/html;charset=gb2312" import= "entity.User"%>

<%@ include file="header.jsp"%>

<table align="center" width=1100>
	<tr>
		<td>
			<table>
	             <tr>
	                 <td>
						<%
						out.println("<span>�û�ID:&nbsp;&nbsp;&nbsp;&nbsp;"+user.getUserID()+"</span><br><br>");
						out.println("<span>�û���:&nbsp;&nbsp;&nbsp;&nbsp;"+user.getUsername()+"</span><br><br>");
						out.println("<span>����:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+user.getPassword()+"</span><br><br>");
						out.println("<span>���:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+user.getIdentity()+"</span><br><br>");
						out.println("<span>�ʼĵ�ַ:&nbsp;&nbsp;"+user.getMail_address()+"</span><br><br>");
						out.println("<span>����:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+user.getUserDetail().getEmail()+"</span><br><br>");
						out.println("<span>���֤��:&nbsp;&nbsp;"+user.getUserDetail().getID_number()+"</span><br><br>");
						out.println("<form action='/bookstore_It3/admin/editInfo.jsp' method='post'>");
						out.println("<input type='submit' value='�޸�'>");
						out.println("</form>");
						%>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>