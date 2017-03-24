<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="adminHeader.jsp"%>
   <tr>
      <td>
          <table>
             <tr>
                <td>用户编号</td><td>用户名</td><td>用户Email</td><td>用户身份证号</td>
             </tr>
             <!--  c:forEach用于循环控制，items属性指出要循环遍历的集合，var定义一个循环变量，表示集合中的一个元素 -->
             <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.userID}</td>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.ID_number}</td>
                    <td>
					<form action="deleteUser" method="post">
						<input type="hidden" name="userID" value= ${user.userID }>
						<input type="submit" value="删除">
					</form>
					</td>
                </tr>
             </c:forEach>
          </table>
      </td>
   </tr>
</table>