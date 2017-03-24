<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header.jsp"%>
<table align="center" width=1100>
   <tr>
      <td>
      	<table>
      		<c:forEach var="order" items = "${orders }">
			    <tr>
			      	<td>订单号</td><td>订单总价</td><td>订单状态</td><td>订单时间</td>
			      	<td>
			      		<c:if test= "${order.status == 'unpay' }">
							<form action="editOrderAmount" method="post">
								<input type="text" name="newAmount" value="" style="width:40px;">
								<input type="hidden" name="orderID" value= ${order.orderID }>
								<input type="submit" value="修改金额">
							</form>
			      		</c:if>
			      	</td>
			      	<td>
			      		<c:if test= "${order.status == 'undelivery' }">
							<form action="deliverOrder" method="post">
								<input type="hidden" name="orderID" value= ${order.orderID }>
								<input type="submit" value="发货">
							</form>
			      		</c:if>
			      	</td>
			      	<td>
						<form action="deleteOrder" method="post">
							<input type="hidden" name="orderID" value= ${order.orderID }>
							<input type="submit" value="删除">
						</form>
					</td>
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
								<form action="showBookDetail" method="post">
									<input type="hidden" name="bookID" value= ${orderItem.book.bookID }>
									<input type="submit" value="详情">
								</form>
							</td>
						</tr>
		           </c:forEach>	
		        <tr>
      				<td><hr color="#9DC45F" size=3></td>
      				<td><hr color="#9DC45F" size=3></td>
      				<td><hr color="#9DC45F" size=3></td>
      				<td><hr color="#9DC45F" size=3></td>
      				<td><hr color="#9DC45F" size=3></td>
      				<td><hr color="#9DC45F" size=3></td>
      				<td><hr color="#9DC45F" size=3></td>
		        </tr>
      		</c:forEach>
          </table>
      </td>
   </tr>
</table>