<%@ page contentType="text/html;charset=gb2312" import="entity.Book" %>

<%@ include file="header.jsp"%>

<table align="center" width=1100>
	<tr>
		<td>
			<table>
	             <tr>
	                 <td align="left">
						<% 
						Book book = (Book)request.getAttribute("book");
						out.println("<span>书名:&nbsp;&nbsp;&nbsp;&nbsp;"+book.getBook_name()+"</span><br><br>");
						out.println("<span>作者:&nbsp;&nbsp;&nbsp;&nbsp;"+book.getBookDetail().getAuthor()+"</span><br><br>");
						out.println("<span>编号:&nbsp;&nbsp;&nbsp;&nbsp;"+book.getBookID()+"</span><br><br>");
						out.println("<span>出版社:&nbsp;&nbsp;"+book.getBookDetail().getPublisher()+"</span><br><br>");
						out.println("<span>单价:&nbsp;&nbsp;&nbsp;&nbsp;"+book.getPrice()+"RMB</span><br><br>");
						out.println("<span>库存:&nbsp;&nbsp;&nbsp;&nbsp;"+book.getQuantity()+"本</span><br><br>");
						out.println("<span>销量:&nbsp;&nbsp;&nbsp;&nbsp;"+book.getSales_volume()+"本</span><br><br>");
						out.println("<span>类别:&nbsp;&nbsp;&nbsp;&nbsp;"+book.getCategory()+"</span><br><br>");
						%>
					</td>
				</tr>
				<tr>
					<%
					out.println("<td><form action='toEditBook' method='post'>");
					out.println("<input type='hidden' name='bookID' value= '"+book.getBookID() +"'>");
					out.println("<input type='submit' value='修改'>");
					out.println("</form></td>");
					out.println("<td><form action='deleteBook' method='post'>");
					out.println("<input type='hidden' name='bookID' value= '"+book.getBookID()+ "'>");
					out.println("<input type='submit' value='删除'>");
					out.println("</form></td>");
					%>
				</tr>
			</table>
		</td>
	</tr>
</table>