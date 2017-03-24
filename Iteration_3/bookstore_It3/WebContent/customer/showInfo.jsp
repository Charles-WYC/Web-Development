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
					out.println("<span>用户ID:&nbsp;&nbsp;&nbsp;&nbsp;"+user.getUserID()+"</span><br><br>");
					out.println("<span>用户名:&nbsp;&nbsp;&nbsp;&nbsp;"+user.getUsername()+"</span><br><br>");
					out.println("<span>密码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+user.getPassword()+"</span><br><br>");
					out.println("<span>身份:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+user.getIdentity()+"</span><br><br>");
					out.println("<span>邮寄地址:&nbsp;&nbsp;"+user.getMail_address()+"</span><br><br>");
					out.println("<span>邮箱:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+user.getUserDetail().getEmail()+"</span><br><br>");
					out.println("<span>身份证号:&nbsp;&nbsp;"+user.getUserDetail().getID_number()+"</span><br><br>");
					out.println("<form action='/bookstore_It3/customer/editInfo.jsp' method='post'>");
					out.println("<input type='submit' value='修改'>");
					out.println("</form>");
					%>
				</td>
			</tr>
		</table>
	</td>
</tr>