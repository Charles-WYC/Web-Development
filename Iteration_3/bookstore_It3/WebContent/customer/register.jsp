<%@ page contentType="text/html;charset=gb2312"%>

<%@ include file="header.jsp"%>

<table align="center" width=1100>
   <tr>
      <td>
         <table>
             <tr>
                 <td>
                     <!--ע��������-->
                     <form action="/bookstore_It3/customer/register.action" enctype="multipart/form-data" method="post">
						<label><span>�û�����&nbsp;&nbsp;</span></label><input type="text" name="user.username" value=""> <br>
                        <p>
						<label><span>���룺&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="password" name="user.password" value=""> <br> 
                        <p>
						<label><span>�ʼĵ�ַ��</span></label><input type="text" name="user.mail_address" value=""> <br>
                        <p>
						<label><span>���䣺&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="email" value=""> <br>
                        <p>
						<label><span>���֤�ţ�</span></label><input type="text" name="ID_number" value=""> <br>
                        <p>
                        <label><span>�ϴ���Ƭ&nbsp;</span></label><input type="file"  name="photo"> <br>
                        <p>
                        <label><span>�ϴ���Ƶ&nbsp;</span></label><input type="file"  name="video"> <br>
                        <p>
                        <input type="submit" value="ע��">
                        <input type="reset" value="���">
                     </form>
                 </td>
             </tr>
        	<tr>
        		<td>
        			<form action="../index/index.jsp" method="post">
        				<input type="submit" value="����">
        			</form>
        		</td>
        	</tr>
         </table>
      </td>
   </tr>
</table>