<%@ page contentType="text/html;charset=gb2312" import="bean.BookBean"%>

<%@ include file="adminHeader.jsp"%>

   <tr>
      <td>
         <table>
             <tr align="left">
                 <td>
                     <!--注册界面代码-->
                     <form action="addBook" method="post">
                        <label><span>书名：&nbsp;&nbsp;</span><input type="text" name="book_name" value=""> </label><br>
                        <p>
						<label><span>作者：&nbsp;&nbsp;</span><input type="text" name="author" value=""> </label><br> 
                        <p>
                        <label><span>出版社：</span><input type="text" name="publisher" value=""> </label><br>
                        <p>
						<label><span>单价：&nbsp;&nbsp;</span><input type="text" name="price" value=""></label><br>
                        <p>
						<label><span>库存：&nbsp;&nbsp;</span><input type="text" name="quantity" value=""> </label><br>
                        <p>
						<label><span>销量：&nbsp;&nbsp;</span><input type="text" name="sales_volume" value=""> </label><br>
                        <p>
						<label><span>类别：&nbsp;&nbsp;</span><input type="text" name="category" value=""></label><label> <span>(A or B or C or D)</span></label><br>
                        <p>
                        <input type="submit" value="提交">
                        <input type="reset" value="清空">
                     </form>
                 </td>
             </tr>
         </table>
      </td>
   </tr>