<%@ page contentType="text/html;charset=gb2312"%>

<%@ include file="indexHeader.jsp"%>

   <tr>
      <td>
         <table align="center">
             <tr>
                 <td>
                     <!--��¼�������-->
                     <form action="login_process" method="post">
                        <!-- ��Ҫ���漰�ύ��Ϣ����Ҫ�õ�form��action�������ύ���ĸ��ļ����� -->
                        <% String info = request.getParameter("info"); 
	                 		if(info == null)
	                 		{
	                 			info = "";
	                 		}
	                 	%>
						<%=info %>
						<label>
                        <span>�û���:</span><input type="text" name="username" value="customer1">
                        </label>
                        <p>
                        <label>
                        <span>����:&nbsp;&nbsp;</span><input type="password" name="userpass" value="customer1">
                        </label>
                        <p>
                        <input type="submit" value="��¼">
                        <input type="reset" value="�ظ�Ĭ��">
                     </form>
                 </td>
             </tr>
         </table>
      </td>
   </tr>