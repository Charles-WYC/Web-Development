<%@ page contentType="text/html;charset=gb2312"%>

<%@ include file="indexHeader.jsp"%>

   <tr>
      <td>
         <table>
             <tr>
                 <td>
                     <!--��¼�������-->
                     <form action="adminLogin" method="post">
                        <!-- ��Ҫ���漰�ύ��Ϣ����Ҫ�õ�form��action�������ύ���ĸ��ļ����� -->
                        <% String info = request.getParameter("info"); 
	                 		if(info == null)
	                 		{
	                 			info = "";
	                 		}
	                 	%>
						<%=info %>
						<label><span>����Ա:</span></label><input type="text" name="username" value="admin"> <br>
                        <p>
						<label><span>����:&nbsp;&nbsp;</span></label><input type="password" name="userpass" value="admin"> <br> 
                        <p>
                        <input type="submit" value="��¼">
                        <input type="reset" value="�ظ�Ĭ��">
                     </form>
                 </td>
             </tr>
         </table>
      </td>
   </tr>