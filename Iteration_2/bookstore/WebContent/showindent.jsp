<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header.jsp"%>

<table align="center">
   <tr>
      <td>
      	<table align="center" >
      		<c:forEach var="indent" items = "${indents }">
			    <tr>
			      	<td>������</td><td>�����ܼ�</td><td>����״̬</td><td>����ʱ��</td>
			      	<td>
			      		<c:if test= "${indent.status == 'unpay' }">
							<form action="payIndent" method="post">
								<input type="hidden" name="indentID" value= ${indent.indentID }>
								<input type="submit" value="֧��">
							</form>
			      		</c:if>
			      		<c:if test= "${indent.status == 'unconfirm' }">
							<form action="confirmIndent" method="post">
								<input type="hidden" name="indentID" value= ${indent.indentID }>
								<input type="submit" value="ȷ���ջ�">
							</form>
			      		</c:if>
			    </tr>
		      	<tr>
		      		<td>${indent.indentID}</td>
		      		<td>${indent.amount}</td>
		      		<td>${indent.status}</td>
		      		<td>${indent.time}</td>
		      	</tr>
		      	<tr>
		            <td>&nbsp;&nbsp;</td><td>ͼ������</td><td>ͼ�鵥��</td><td>����</td><td>�ܼ�</td>
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