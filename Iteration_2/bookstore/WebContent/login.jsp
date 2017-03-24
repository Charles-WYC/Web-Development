<%@ page contentType="text/html;charset=gb2312"%>

<%@ include file="indexHeader.jsp"%>

   <tr>
      <td>
         <table align="center">
             <tr>
                 <td>
                     <!--登录界面代码-->
                     <form action="login_process" method="post">
                        <!-- 主要是涉及提交信息，就要用到form，action决定了提交给哪个文件处理 -->
                        <% String info = request.getParameter("info"); 
	                 		if(info == null)
	                 		{
	                 			info = "";
	                 		}
	                 	%>
						<%=info %>
						<label>
                        <span>用户名:</span><input type="text" name="username" value="customer1">
                        </label>
                        <p>
                        <label>
                        <span>密码:&nbsp;&nbsp;</span><input type="password" name="userpass" value="customer1">
                        </label>
                        <p>
                        <input type="submit" value="登录">
                        <input type="reset" value="回复默认">
                     </form>
                 </td>
             </tr>
         </table>
      </td>
   </tr>