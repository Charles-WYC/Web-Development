<%@ page contentType="text/html;charset=gb2312"%>

<%@ include file="indexHeader.jsp"%>

<tr>
	<td>
		<table align = "center">
             <tr>
                 <td>
					<form action="login.jsp" method="post">
						<input type="submit" value="&nbsp;用户登录&nbsp;">
					</form>
					<p>
					<form action="register.jsp" method="post">
						<input type="submit" value="&nbsp;用户注册&nbsp;">
					</form>
					<p>
					<form action="adminLogin.jsp" method="post">
						<input type="submit" value="管理员登录">
					</form>
				</td>
			</tr>
		</table>
	</td>
</tr>