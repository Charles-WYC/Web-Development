<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header.jsp"%>

<table align="center">
   <tr>
      <td>
      	<table align="center" >
      		<c:forEach var="order" items = "${orders }">
			    <tr>
			      	<td>������</td><td>�����ܼ�</td><td>����״̬</td><td>����ʱ��</td>
			      	<td>
			      		<c:if test= "${order.status == 'unpay' }">
							<form action="payOrder" method="post">
								<input type="hidden" name="orderID" value= ${order.orderID }>
								<input type="submit" value="֧��">
							</form>
			      		</c:if>
			      		<c:if test= "${order.status == 'unconfirm' }">
							<form action="confirmOrder" method="post">
								<input type="hidden" name="orderID" value= ${order.orderID }>
								<input type="submit" value="ȷ���ջ�">
							</form>
			      		</c:if>
			    </tr>
		      	<tr>
		      		<td>${order.orderID}</td>
		      		<td>${order.amount}</td>
		      		<td>${order.status}</td>
		      		<td>${order.date}</td>
		      	</tr>
		      	<tr>
		            <td>&nbsp;&nbsp;</td><td>ͼ������</td><td>ͼ�鵥��</td><td>����</td><td>�ܼ�</td>
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
									<input type="submit" value="����">
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
		        </tr>
      		</c:forEach>
          </table>
      </td>
   </tr>
</table>