<%@ page contentType="text/html;charset=gb2312" import="entity.User"%>

<%@ include file="header.jsp"%>

<table align="center" width=1100>
   <tr>
      <td>
         <table>
             <tr>
                 <td>
                     <form action="/bookstore_It3/editUserInfo" method="post">
						<label><span>用户ID：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${user.userID}</span></label><input type="hidden" name="user.userID" value="${user.userID }"> <br>
                        <p>
						<label><span>用户名：&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="user.username" value="${user.username }"> <br> 
                        <p>
						<label><span>密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="password" name="user.password" value="${user.password }"> <br> 
                        <p>
						<label><span>身份：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${user.identity}</span></label><input type="hidden" name="user.identity" value="${user.identity }"><br>
                        <p>
						<label><span>邮寄地址：&nbsp;&nbsp;</span></label><input type="text" name="user.mail_address" value="${user.mail_address }"> <br>
                        <p>
						<label><span>邮箱：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="email" value="${user.userDetail.email }"> <br>
                        <p>
						<label><span>身份证号：&nbsp;&nbsp;</span></label><input type="text" name="ID_number" value="${user.userDetail.ID_number }"> <br>
                        <p>
                        <input type="submit" value="保存修改">
                        <input type="reset" value="恢复原值">
                     </form>
                 </td>
             </tr>
         </table>
      </td>
   </tr>