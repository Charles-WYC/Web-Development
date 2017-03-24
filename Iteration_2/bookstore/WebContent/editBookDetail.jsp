<%@ page contentType="text/html;charset=gb2312" import="bean.BookBean"%>

<%@ include file="adminHeader.jsp"%>

   <tr>
      <td>
         <table>
             <tr>
                 <td>
                     <!--注册界面代码-->
                     <form action="editBookDetail" method="post">
						<label><span>书名：&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="book_name" value="${book.book_name }"> <br>
                        <p>
						<label><span>作者：&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="author" value="${book.author }"> <br> 
                        <p>
						<label><span>编号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${book.bookID }</span></label><input type="hidden" name="bookID" value="${book.bookID }"> <br>
                        <p>
						<label><span>出版社：&nbsp;&nbsp;</span></label><input type="text" name="publisher" value="${book.publisher }"> <br>
                        <p>
						<label><span>单价：&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="price" value="${book.price }"><br>
                        <p>
						<label><span>库存：&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="quantity" value="${book.quantity }"><br>
                        <p>
						<label><span>销量：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${book.sales_volume } 本</span></label><input type="hidden" name="sales_volume" value="${book.sales_volume }"><br>
                        <p>
						<label><span>类别：&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="category" value="${book.category }"> <label> <span>(A or B or C or D)</span></label><br>
                        <p>
                        <input type="submit" value="保存修改">
                        <input type="reset" value="恢复原值">
                     </form>
                 </td>
             </tr>
         </table>
      </td>
   </tr>