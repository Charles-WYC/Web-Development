<%@ page contentType="text/html;charset=gb2312"%>

<%@ include file="header.jsp"%>

   <tr>
      <td>
         <table>
             <tr>
                 <td>
                     <!--注册界面代码-->
                     <form action="addUser" method="post">
                        <!-- 主要是涉及提交信息，就要用到form，action决定了提交给哪个文件处理 -->
	                 	<% String info = request.getParameter("info"); 
	                 		if(info == null)
	                 		{
	                 			info = "";
	                 		}
	                 	%>
						<%=info %>
						<label><span>用户名：&nbsp;&nbsp;</span></label><input type="text" name="username" value=""> <br>
                        <p>
						<label><span>密码：&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="password" name="password" value=""> <br> 
                        <p>
						<label><span>邮寄地址：</span></label><input type="text" name="mail_address" value=""> <br>
                        <p>
						<label><span>邮箱：&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="email" value=""> <br>
                        <p>
						<label><span>身份证号：</span></label><input type="text" name="ID_number" value=""> <br>
                        <p>
                        <input type="submit" value="注册">
                        <input type="reset" value="清空">
                     </form>
                 </td>
             </tr>
         </table>
      </td>
   </tr>