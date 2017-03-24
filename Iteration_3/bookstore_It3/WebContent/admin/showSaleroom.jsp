<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header.jsp"%>
<table align="center" width=1100>
   <tr>
      <td>
          <table>
             <tr>
                <td>用户ID</td><td>书籍ID</td><td></td><td>年</td><td>月</td><td>日</td><td></td><td>年</td><td>月</td><td>日</td><td>类别</td>
			</tr>
			<tr>
				<form action="showSaleroom" method="post">
				<td>
						<input type="text" name="userID" value="${preUserID }" style="width:60px;">
				</td>
				<td>
						<input type="text" name="bookID" value="${preBookID }" style="width:60px;">
				</td>
				<td>from</td>
				<td>
						<input type="text" name="Byear" value="${preBYear }" style="width:60px;">
				</td>
				<td>
						<input type="text" name="Bmonth" value="${preBMonth }" style="width:60px;">
				</td>
				<td>
						<input type="text" name="Bday" value="${ preBDay}" style="width:60px;">
				</td>
				<td>to</td>
				<td>
						<input type="text" name="Eyear" value="${preEYear }" style="width:60px;">
				</td>
				<td>
						<input type="text" name="Emonth" value="${preEMonth }" style="width:60px;">
				</td>
				<td>
						<input type="text" name="Eday" value="${ preEDay}" style="width:60px;">
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
          </table>
          <table>
             <tr>
             	<td>总销售量:</td><td>${total_sale_volume }</td><td>总销售额:</td><td>${total_amount }</td>
             </tr>
             
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