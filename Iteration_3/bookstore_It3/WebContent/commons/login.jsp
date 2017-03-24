<%@ page contentType="text/html;charset=gb2312"%>

<%@ include file="header.jsp"%>

<table align="center" width=1100>
   <tr>
      <td>
         <table align="center">
             <tr>
                 <td>
                     <!--登录界面代码-->
                     <form action="/bookstore_It3/login" method="post">
						<label>
                        <span>用户名:</span><input type="text" name="user.username" value="customer1">
                        </label>
                        <p>
                        <label>
                        <span>密码:&nbsp;&nbsp;</span><input type="password" name="user.password" value="customer1">
                        </label>
                        <p>
                        <input type="submit" value="登录">
                        <input type="reset" value="恢复默认">
                     </form>
                 </td>
             </tr>
         </table>
      </td>
   </tr>
</table>