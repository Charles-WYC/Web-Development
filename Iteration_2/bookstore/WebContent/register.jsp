<%@ page contentType="text/html;charset=gb2312"%>

<%@ include file="header.jsp"%>

   <tr>
      <td>
         <table>
             <tr>
                 <td>
                     <!--ע��������-->
                     <form action="addUser" method="post">
                        <!-- ��Ҫ���漰�ύ��Ϣ����Ҫ�õ�form��action�������ύ���ĸ��ļ����� -->
	                 	<% String info = request.getParameter("info"); 
	                 		if(info == null)
	                 		{
	                 			info = "";
	                 		}
	                 	%>
						<%=info %>
						<label><span>�û�����&nbsp;&nbsp;</span></label><input type="text" name="username" value=""> <br>
                        <p>
						<label><span>���룺&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="password" name="password" value=""> <br> 
                        <p>
						<label><span>�ʼĵ�ַ��</span></label><input type="text" name="mail_address" value=""> <br>
                        <p>
						<label><span>���䣺&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="email" value=""> <br>
                        <p>
						<label><span>���֤�ţ�</span></label><input type="text" name="ID_number" value=""> <br>
                        <p>
                        <input type="submit" value="ע��">
                        <input type="reset" value="���">
                     </form>
                 </td>
             </tr>
         </table>
      </td>
   </tr>