<%@ page contentType="text/html;charset=gb2312" import="entity.User"%>

<%@ include file="header.jsp"%>

<table align="center" width=1100>
   <tr>
      <td>
         <table>
             <tr>
                 <td>
                     <form action="/bookstore_It3/editUserInfo" method="post">
						<label><span>�û�ID��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${user.userID}</span></label><input type="hidden" name="user.userID" value="${user.userID }"> <br>
                        <p>
						<label><span>�û�����&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="user.username" value="${user.username }"> <br> 
                        <p>
						<label><span>���룺&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="password" name="user.password" value="${user.password }"> <br> 
                        <p>
						<label><span>��ݣ�&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${user.identity}</span></label><input type="hidden" name="user.identity" value="${user.identity }"><br>
                        <p>
						<label><span>�ʼĵ�ַ��&nbsp;&nbsp;</span></label><input type="text" name="user.mail_address" value="${user.mail_address }"> <br>
                        <p>
						<label><span>���䣺&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="email" value="${user.userDetail.email }"> <br>
                        <p>
						<label><span>���֤�ţ�&nbsp;&nbsp;</span></label><input type="text" name="ID_number" value="${user.userDetail.ID_number }"> <br>
                        <p>
                        <input type="submit" value="�����޸�">
                        <input type="reset" value="�ָ�ԭֵ">
                     </form>
                 </td>
             </tr>
         </table>
      </td>
   </tr>