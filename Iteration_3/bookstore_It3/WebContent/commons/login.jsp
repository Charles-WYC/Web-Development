<%@ page contentType="text/html;charset=gb2312"%>

<%@ include file="header.jsp"%>

<table align="center" width=1100>
   <tr>
      <td>
         <table align="center">
             <tr>
                 <td>
                     <!--��¼�������-->
                     <form action="/bookstore_It3/login" method="post">
						<label>
                        <span>�û���:</span><input type="text" name="user.username" value="customer1">
                        </label>
                        <p>
                        <label>
                        <span>����:&nbsp;&nbsp;</span><input type="password" name="user.password" value="customer1">
                        </label>
                        <p>
                        <input type="submit" value="��¼">
                        <input type="reset" value="�ָ�Ĭ��">
                     </form>
                 </td>
             </tr>
         </table>
      </td>
   </tr>
</table>