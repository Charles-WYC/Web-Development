<%@ page contentType="text/html;charset=gb2312" import= "entity.User"%>

<%@ include file="header.jsp"%>

<tr>
	<td>
		<table>
			<tr>
				<td>
					<img src="D://Program Files/Eclipse/bookstore_It3/WebContent/photo/photo${user.userID }.jpg"/>
				</td>
				<td>
					<object classid="clsid:22D6F312-B0F6-11D0-94AB-0080C74C7E95" height=300 width=300>
						<param name="filename" value="D://Program Files/Eclipse/bookstore_It3/WebContent/video/video${user.userID }.mp4" />
					</object>
				</td>
			</tr>
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
					out.println("<form action='/bookstore_It3/customer/editInfo.jsp' method='post'>");
					out.println("<input type='submit' value='�޸�'>");
					out.println("</form>");
					%>
				</td>
			</tr>
		</table>
	</td>
</tr>