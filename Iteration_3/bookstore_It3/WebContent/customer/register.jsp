<%@ page contentType="text/html;charset=gb2312"%>

<%@ include file="header.jsp"%>

<table align="center" width=1100>
   <tr>
      <td>
         <table>
             <tr>
                 <td>
                     <!--注册界面代码-->
                     <form action="/bookstore_It3/customer/register.action" enctype="multipart/form-data" method="post">
						<label><span>用户名：&nbsp;&nbsp;</span></label><input type="text" name="user.username" value=""> <br>
                        <p>
						<label><span>密码：&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="password" name="user.password" value=""> <br> 
                        <p>
						<label><span>邮寄地址：</span></label><input type="text" name="user.mail_address" value=""> <br>
                        <p>
						<label><span>邮箱：&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="email" value=""> <br>
                        <p>
						<label><span>身份证号：</span></label><input type="text" name="ID_number" value=""> <br>
                        <p>
                        <label><span>上传照片&nbsp;</span></label><input type="file"  name="photo"> <br>
                        <p>
                        <label><span>上传视频&nbsp;</span></label><input type="file"  name="video"> <br>
                        <p>
                        <input type="submit" value="注册">
                        <input type="reset" value="清空">
                     </form>
                 </td>
             </tr>
        	<tr>
        		<td>
        			<form action="../index/index.jsp" method="post">
        				<input type="submit" value="返回">
        			</form>
        		</td>
        	</tr>
         </table>
      </td>
   </tr>
</table>