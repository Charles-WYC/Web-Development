<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header.jsp"%>

<table align="center" width=1100>
   <tr>
      <td>
          <table>
             <tr>
                <td>图书编号</td><td>图书名称</td><td>作者</td><td>价格(RMB)</td><td>类别</td>
                <td>
					<form action="/bookstore_It3/admin/addBook.jsp" method="post">
						<input type="submit" value="添加图书">
					</form>
				</td>
			</tr>
			<tr>
				<form action="/bookstore_It3/findBookOnCondition" method="post">
				<td>
						<input type="text" name="bookID" value="${preBookID }" style="width:40px;">
				</td>
				<td>
						<input type="text" name="book_name" value="${preBook_name }" style="width:60px;">
				</td>
				<td>
						<input type="text" name="author" value="${ preAuthor}" style="width:60px;">
				</td>
				<td>
						<input type="text" name="price" value="${ prePrice}" style="width:40px;">
				</td>
				<td>
						<select name="category">
							<option value=""></option>
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
							<option value="D">D</option>
						</select>
				</td>
				<td>
						<input type="submit" value="查询">
				</td>
				</form>
             </tr>
             <!--  c:forEach用于循环控制，items属性指出要循环遍历的集合，var定义一个循环变量，表示集合中的一个元素 -->
             <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.bookID}</td>
                    <td>${book.book_name}</td>
                    <td>${book.bookDetail.author}</td>
                    <td>${book.price}</td>
                    <td>${book.category}</td>
                    <td>
					<form action="/bookstore_It3/admin/showBookDetail.action" method="post">
						<input type="hidden" name="bookID" value= ${book.bookID }>
						<input type="submit" value="修改&删除">
					</form>
					</td>
                </tr>
             </c:forEach>
          </table>
      </td>
   </tr>
</table>