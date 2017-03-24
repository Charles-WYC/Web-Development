<%@ page contentType="text/html;charset=gb2312"%>

<%@ include file="indexHeader.jsp"%>

   <tr>
      <td>
         <table>
             <tr>
                 <td>
                     <!--登录界面代码-->
                     <form action="adminLogin" method="post">
                        <!-- 主要是涉及提交信息，就要用到form，action决定了提交给哪个文件处理 -->
                        <% String info = request.getParameter("info"); 
	                 		if(info == null)
	                 		{
	                 			info = "";
	                 		}
	                 	%>
						<%=info %>
						<label><span>管理员:</span></label><input type="text" name="username" value="admin"> <br>
                        <p>
						<label><span>密码:&nbsp;&nbsp;</span></label><input type="password" name="userpass" value="admin"> <br> 
                        <p>
                        <input type="submit" value="登录">
                        <input type="reset" value="回复默认">
                     </form>
                 </td>
             </tr>
         </table>
      </td>
   </tr>