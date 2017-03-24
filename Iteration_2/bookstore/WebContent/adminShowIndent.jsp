<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="adminHeader.jsp"%>
   <tr>
      <td>
      	<table>
      		<c:forEach var="indent" items = "${indents }">
			    <tr>
			      	<td>订单号</td><td>订单总价</td><td>订单状态</td><td>订单时间</td>
			      	<td>
			      		<c:if test= "${indent.status == 'unpay' }">
							<form action="editIndentAmount" method="post">
								<input type="text" name="newAmount" value="" style="width:40px;">
								<input type="hidden" name="indentID" value= ${indent.indentID }>
								<input type="submit" value="修改金额">
							</form>
			      		</c:if>
			      	</td>
			      	<td>
			      		<c:if test= "${indent.status == 'undelivery' }">
							<form action="deliveryIndent" method="post">
								<input type="hidden" name="indentID" value= ${indent.indentID }>
								<input type="submit" value="发货">
							</form>
			      		</c:if>
			      	</td>
			      	<td>
						<form action="deleteIndent" method="post">
							<input type="hidden" name="indentID" value= ${indent.indentID }>
							<input type="submit" value="删除">
						</form>
					</td>
			    </tr>
		      	<tr>
		      		<td>${indent.indentID}</td>
		      		<td>${indent.amount}</td>
		      		<td>${indent.status}</td>
		      		<td>${indent.time}</td>
		      	</tr>
		      	<tr>
		            <td>&nbsp;&nbsp;</td><td>图书名称</td><td>图书单价</td><td>数量</td><td>总价</td>
		        </tr>
		          <c:forEach var="indentItem" items = "${indent.indentItems }">
		                <tr>
		                	<td>&nbsp;&nbsp;</td>
			               	<td>${indentItem.book_name }</td>
			                <td>${indentItem.price }</td>
			                <td>${indentItem.number }</td>
			                <td>${indentItem.total_price }</td>
					        <td>
								<form action="adminBookDetail" method="post">
									<input type="hidden" name="bookID" value= ${indentItem.bookID }>
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