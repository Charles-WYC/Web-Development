<%@ page contentType="text/html;charset=gb2312" import="bean.BookBean"%>

<%@ include file="adminHeader.jsp"%>

   <tr>
      <td>
         <table>
             <tr>
                 <td>
                     <form action="editAdminInfo" method="post">
						<label><span>����ԱID��&nbsp;&nbsp;&nbsp;${user.userID}</span></label><input type="hidden" name="userID" value="${user.userID }"> <br>
                        <p>
						<label><span>����Ա��&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="username" value="${user.username }"> <br> 
                        <p>
						<label><span>���룺&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="password" name="password" value="${user.password }"> <br> 
                        <p>
						<label><span>��ݣ�&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${user.identity}</span></label><br>
                        <p>
						<label><span>�ʼĵ�ַ��&nbsp;&nbsp;</span></label><input type="text" name="mail_address" value="${user.mail_address }"> <br>
                        <p>
						<label><span>���䣺&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="email" value="${user.email }"> <br>
                        <p>
						<label><span>���֤�ţ�&nbsp;&nbsp;</span></label><input type="text" name="ID_number" value="${user.ID_number }"> <br>
                        <p>
                        <input type="submit" value="�����޸�">
                        <input type="reset" value="�ָ�ԭֵ">
                     </form>
                 </td>
             </tr>
         </table>
      </td>
   </tr>