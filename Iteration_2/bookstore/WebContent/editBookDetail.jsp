<%@ page contentType="text/html;charset=gb2312" import="bean.BookBean"%>

<%@ include file="adminHeader.jsp"%>

   <tr>
      <td>
         <table>
             <tr>
                 <td>
                     <!--ע��������-->
                     <form action="editBookDetail" method="post">
						<label><span>������&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="book_name" value="${book.book_name }"> <br>
                        <p>
						<label><span>���ߣ�&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="author" value="${book.author }"> <br> 
                        <p>
						<label><span>��ţ�&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${book.bookID }</span></label><input type="hidden" name="bookID" value="${book.bookID }"> <br>
                        <p>
						<label><span>�����磺&nbsp;&nbsp;</span></label><input type="text" name="publisher" value="${book.publisher }"> <br>
                        <p>
						<label><span>���ۣ�&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="price" value="${book.price }"><br>
                        <p>
						<label><span>��棺&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="quantity" value="${book.quantity }"><br>
                        <p>
						<label><span>������&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${book.sales_volume } ��</span></label><input type="hidden" name="sales_volume" value="${book.sales_volume }"><br>
                        <p>
						<label><span>���&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="category" value="${book.category }"> <label> <span>(A or B or C or D)</span></label><br>
                        <p>
                        <input type="submit" value="�����޸�">
                        <input type="reset" value="�ָ�ԭֵ">
                     </form>
                 </td>
             </tr>
         </table>
      </td>
   </tr>