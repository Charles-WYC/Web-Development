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
								<form action="bookDetail" method="post">
									<input type="hidden" name="bookID" value= ${indentItem.bookID }>
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
          			<form action = "payIndent" method = "post">
          				<input type = "hidden" name = "indentID" value= ${indent.indentID }>
          				<input type = "submit" value="支付">
          			</form>
          		</td>
          		</tr>
          </table>
      </td>
   </tr>
</table>