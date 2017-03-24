<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header.jsp"%>

<table align="center">
   <tr>
      <td>
      	<table align="center">
			    <tr>
			      	<td>订单号</td><td>订单总价</td><td>订单状态</td><td>订单时间</td>
			    </tr>
		      	<tr>
		      		<td>${order.orderID}</td>
		      		<td>${order.amount}</td>
		      		<td>${order.status}</td>
		      		<td>${order.date}</td>
		      	</tr>
		      	<tr>
		            <td>&nbsp;&nbsp;</td><td>图书名称</td><td>图书单价</td><td>数量</td><td>总价</td>
		        </tr>
		          <c:forEach var="orderItem" items = "${order.orderItems }">
		                <tr>
		                	<td>&nbsp;&nbsp;</td>
			               	<td>${orderItem.book.book_name }</td>
			                <td>${orderItem.book.price }</td>
			                <td>${orderItem.number }</td>
			                <td>${orderItem.total_price }</td>
					        <td>
								<form action="bookDetail" method="post">
									<input type="hidden" name="bookID" value= ${orderItem.book.bookID }>
									<input type="submit" value="详情">
								</form>
							</td>
						</tr>
		           </c:forEach>	
		        <tr>
          		</tr>
          		<tr>
          			<td></td><td></td>
		        <td>  
          			<form action = "payOrder" method = "post">
          				<input type = "hidden" name = "orderID" value= ${order.orderID }>
          				<input type = "submit" value="支付">
          			</form>
          		</td>
          		</tr>
          </table>
      </td>
   </tr>
</table>