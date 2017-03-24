<%@ page contentType="text/html;charset=gb2312" import="bean.BookBean"%>

<%@ include file="adminHeader.jsp"%>

   <tr>
      <td>
         <table>
             <tr>
                 <td>
                     <form action="editAdminInfo" method="post">
						<label><span>管理员ID：&nbsp;&nbsp;&nbsp;${user.userID}</span></label><input type="hidden" name="userID" value="${user.userID }"> <br>
                        <p>
						<label><span>管理员：&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="username" value="${user.username }"> <br> 
                        <p>
						<label><span>密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="password" name="password" value="${user.password }"> <br> 
                        <p>
						<label><span>身份：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${user.identity}</span></label><br>
                        <p>
						<label><span>邮寄地址：&nbsp;&nbsp;</span></label><input type="text" name="mail_address" value="${user.mail_address }"> <br>
                        <p>
						<label><span>邮箱：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="email" value="${user.email }"> <br>
                        <p>
						<label><span>身份证号：&nbsp;&nbsp;</span></label><input type="text" name="ID_number" value="${user.ID_number }"> <br>
                        <p>
                        <input type="submit" value="保存修改">
                        <input type="reset" value="恢复原值">
                     </form>
                 </td>
             </tr>
         </table>
      </td>
   </tr>