<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header.jsp"%>

<table align="center" width=1100>
   <tr>
      <td>
          <table >
             <form action = "addOrder" method = "post">
             <tr>
                <td >
                	<input type = "submit" value = "���ɶ���">
                </td>
             </tr>
             <!--  c:forEach����ѭ�����ƣ�items����ָ��Ҫѭ�������ļ��ϣ�var����һ��ѭ����������ʾ�����е�һ��Ԫ�� -->
             <c:forEach var="cartItem" items="${cartItems }">
                <tr height="40px">
                	<td>
                		<input name="items" type="checkbox" value= ${cartItem.cartItemID } />
                	</td>
                </tr>
             </c:forEach>
                </form>	
          </table>
      </td>
      <td>
      
          <table>
             <tr>
                <td>ͼ������</td><td>ͼ�鵥��</td><td>����</td><td>�ܼ�</td><td>����</td><td>����</td><td>ɾ��</td><td>����</td>
             </tr>
             <!--  c:forEach����ѭ�����ƣ�items����ָ��Ҫѭ�������ļ��ϣ�var����һ��ѭ����������ʾ�����е�һ��Ԫ�� -->
             <c:forEach var="cartItem" items="${cartItems }">
                <tr>
                    <td>${cartItem.book.book_name}</td>
                    <td>${cartItem.book.price}</td>
                    <td>${cartItem.number}</td>
                    <td>${cartItem.total_price}</td>
                	<td style="width:140px;">
                    <form action="editBookNumberInCart" method="post">
						<input type="hidden" name="cartItemID" value= ${cartItem.cartItemID }>
						<input type="hidden" name="type" value= "2">
						<input type="text" name="degree" value= "1" style="width:40px;">
						<input type="submit" value="����">
					</form>
					</td>
                    <td style="width:140px;">
					<form action="editBookNumberInCart" method="post">
						<input type="hidden" name="cartItemID" value= ${cartItem.cartItemID }>
						<input type="hidden" name="type" value= "1">
						<input type="text" name="degree" value= "1" style="width:40px;">
						<input type="submit" value="����">
					</form>
					</td>
                    <td>
					<form action="editBookNumberInCart" method="post">
						<input type="hidden" name="cartItemID" value= ${cartItem.cartItemID }>
						<input type="hidden" name="type" value= "0">
						<input type="submit" value="ɾ��">
					</form>
					</td>
                    <td>
					<form action="bookDetail.action" method="post">
						<input type="hidden" name="bookID" value= ${cartItem.book.bookID }>
						<input type="submit" value="����">
					</form>
					</td>
                </tr>
             </c:forEach>
                </form>	
          </table>
      </td>
   </tr>
</table>