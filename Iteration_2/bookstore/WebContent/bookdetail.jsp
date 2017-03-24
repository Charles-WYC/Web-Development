<%@ page contentType="text/html;charset=gb2312" import="bean.BookBean" import= "bean.UserBean"%>

<%@ include file="header.jsp"%>

<tr>
	<td>
		<table>
             <tr>
                 <td align="left">
					<% 
					BookBean book = (BookBean)request.getAttribute("book");
					out.println("<span>书名:&nbsp;&nbsp;&nbsp;&nbsp;"+book.getBook_name()+"</span><br><br>");
					out.println("<span>作者:&nbsp;&nbsp;&nbsp;&nbsp;"+book.getAuthor()+"</span><br><br>");
					out.println("<span>编号:&nbsp;&nbsp;&nbsp;&nbsp;"+book.getBookID()+"</span><br><br>");
					out.println("<span>出版社:&nbsp;&nbsp;"+book.getPublisher()+"</span><br><br>");
					out.println("<span>单价:&nbsp;&nbsp;&nbsp;&nbsp;"+book.getPrice()+"RMB</span><br><br>");
					out.println("<span>库存:&nbsp;&nbsp;&nbsp;&nbsp;"+book.getQuantity()+"本</span><br><br>");
					out.println("<span>销量:&nbsp;&nbsp;&nbsp;&nbsp;"+book.getSales_volume()+"本</span><br><br>");
					out.println("<span>类别:&nbsp;&nbsp;&nbsp;&nbsp;"+book.getCategory()+"</span><br><br>");
					%>
				</td>
			</tr>
		</table>
	</td>
</tr>