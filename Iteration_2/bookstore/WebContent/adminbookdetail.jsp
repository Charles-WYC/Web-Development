<%@ page contentType="text/html;charset=gb2312" import="bean.BookBean" import= "bean.UserBean"%>

<%@ include file="adminHeader.jsp"%>

<tr>
	<td>
		<table>
             <tr>
                 <td align="left">
					<% 
					BookBean book = (BookBean)request.getAttribute("book");
					out.println("<span>����:&nbsp;&nbsp;&nbsp;&nbsp;"+book.getBook_name()+"</span><br><br>");
					out.println("<span>����:&nbsp;&nbsp;&nbsp;&nbsp;"+book.getAuthor()+"</span><br><br>");
					out.println("<span>���:&nbsp;&nbsp;&nbsp;&nbsp;"+book.getBookID()+"</span><br><br>");
					out.println("<span>������:&nbsp;&nbsp;"+book.getPublisher()+"</span><br><br>");
					out.println("<span>����:&nbsp;&nbsp;&nbsp;&nbsp;"+book.getPrice()+"RMB</span><br><br>");
					out.println("<span>���:&nbsp;&nbsp;&nbsp;&nbsp;"+book.getQuantity()+"��</span><br><br>");
					out.println("<span>����:&nbsp;&nbsp;&nbsp;&nbsp;"+book.getSales_volume()+"��</span><br><br>");
					out.println("<span>���:&nbsp;&nbsp;&nbsp;&nbsp;"+book.getCategory()+"</span><br><br>");
					%>
				</td>
			</tr>
			<tr>
				<%
				out.println("<td><form action='editBookDetailProcess' method='post'>");
				out.println("<input type='hidden' name='bookID' value= '"+book.getBookID() +"'>");
				out.println("<input type='submit' value='�޸�'>");
				out.println("</form></td>");
				out.println("<td><form action='deleteBookProcess' method='post'>");
				out.println("<input type='hidden' name='bookID' value= '"+book.getBookID()+ "'>");
				out.println("<input type='submit' value='ɾ��'>");
				out.println("</form></td>");
				%>
			</tr>
		</table>
	</td>
</tr>