<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header.jsp"%>
<table align="center" width=1100>
   <tr>
      <td>
          <table>
             <tr>
                <td>�û����</td><td>�û���</td><td>�û�Email</td><td>�û����֤��</td>
             </tr>
             <!--  c:forEach����ѭ�����ƣ�items����ָ��Ҫѭ�������ļ��ϣ�var����һ��ѭ����������ʾ�����е�һ��Ԫ�� -->
             <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.userID}</td>
                    <td>${user.username}</td>
                    <td>${user.userDetail.email}</td>
                    <td>${user.userDetail.ID_number}</td>
                    <td>
					<form action="deleteCustomer" method="post">
						<input type="hidden" name="userID" value= ${user.userID }>
						<input type="submit" value="ɾ��">
					</form>
					</td>
                </tr>
             </c:forEach>
          </table>
      </td>
   </tr>
</table>