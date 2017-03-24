<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header.jsp"%>

   <tr>
      <td>
          <table align="center" >
             <tr>
                <td>图书编号</td><td>图书名称</td><td>作者</td><td>价格(RMB)</td><td>出版社</td><td>销量(本)</td><td>库存(本)</td><td>类别</td>
             </tr>
			<tr>
				<form action="findBooksOnCondition" method="post">
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
						<input type="text" name="publisher" value="${prePublisher }" style="width:60px;">
				</td>
				<td>
						<input type="text" name="sales_volume" value="${ preSales_volume}" style="width:40px;">
				</td>
				<td>
						<input type="text" name="quantity" value="${preQuantity }" style="width:40px;">
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
                    <td>${book.author}</td>
                    <td>${book.price}</td>
                    <td>${book.publisher}</td>
                    <td>${book.sales_volume}</td>
                    <td>${book.quantity}</td>
                    <td>${book.category}</td>
                    <td>
					<form action="bookDetail" method="post">
						<input type="hidden" name="bookID" value= ${book.bookID }>
						<input type="submit" value="详情">
					</form>
					</td>
                    <td>
					<form action="addBookIntoCart" method="post">
						<input type="hidden" name="bookID" value= ${book.bookID }>
						<input type="text" name="number" value= "1" style="width:40px;">
						<input type="submit" value="加入购物车">
					</form>
					</td>
                </tr>
             </c:forEach>
          </table>
      </td>
   </tr>
</table>