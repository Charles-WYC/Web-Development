<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header.jsp"%>

   <tr>
      <td>
          <table >
             <form action = "submitIndent" method = "post">
             <tr>
                <td >
                	<input type = "submit" value = "生成订单">
                </td>
             </tr>
             <!--  c:forEach用于循环控制，items属性指出要循环遍历的集合，var定义一个循环变量，表示集合中的一个元素 -->
             <c:forEach var="cartItem" items="${cartItems }">
                <tr height="30px">
                	<td>
                		<input name="items" type="checkbox" value= ${cartItem.bookID } />
                	</td>
                </tr>
             </c:forEach>
                </form>	
          </table>
      </td>
      <td>
      
          <table>
             <tr>
                <td>图书名称</td><td>图书单价</td><td>数量</td><td>总价</td><td>减少</td><td>增加</td><td>删除</td><td>详情</td>
             </tr>
             <!--  c:forEach用于循环控制，items属性指出要循环遍历的集合，var定义一个循环变量，表示集合中的一个元素 -->
             <c:forEach var="cartItem" items="${cartItems }">
                <tr>
                    <td>${cartItem.book_name}</td>
                    <td>${cartItem.price}</td>
                    <td>${cartItem.number}</td>
                    <td>${cartItem.total_price}</td>
                	<td style="width:140px;">
                    <form action="editBookNumberInCart" method="post">
						<input type="hidden" name="bookID" value= ${cartItem.bookID }>
						<input type="hidden" name="action" value= "2">
						<input type="text" name="degree" value= "1" style="width:40px;">
						<input type="submit" value="减少">
					</form>
					</td>
                    <td style="width:140px;">
					<form action="editBookNumberInCart" method="post">
						<input type="hidden" name="bookID" value= ${cartItem.bookID }>
						<input type="hidden" name="action" value= "1">
						<input type="text" name="degree" value= "1" style="width:40px;">
						<input type="submit" value="增加">
					</form>
					</td>
                    <td>
					<form action="editBookNumberInCart" method="post">
						<input type="hidden" name="bookID" value= ${cartItem.bookID }>
						<input type="hidden" name="action" value= "0">
						<input type="submit" value="删除">
					</form>
					</td>
                    <td>
					<form action="bookDetail" method="post">
						<input type="hidden" name="bookID" value= ${cartItem.bookID }>
						<input type="submit" value="详情">
					</form>
					</td>
                </tr>
             </c:forEach>
                </form>	
          </table>
      </td>
   </tr>
</table>