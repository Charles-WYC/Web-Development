<%@ page contentType="text/html;charset=gb2312" import="entity.Book"%>

<%@ include file="header.jsp"%>

<table align="center" width=1100>
   <tr>
      <td>
         <table>
             <tr>
                 <td>
                     <!--ע��������-->
                     <form action="editBook" method="post">
						<label><span>������&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="book.book_name" value="${book.book_name }"> <br>
                        <p>
						<label><span>���ߣ�&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="author" value="${book.bookDetail.author }"> <br> 
                        <p>
						<label><span>��ţ�&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${book.bookID }</span></label><input type="hidden" name="book.bookID" value="${book.bookID }"> <br>
                        <p>
						<label><span>�����磺&nbsp;&nbsp;</span></label><input type="text" name="publisher" value="${book.bookDetail.publisher }"> <br>
                        <p>
						<label><span>���ۣ�&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="book.price" value="${book.price }"><br>
                        <p>
						<label><span>��棺&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="book.quantity" value="${book.quantity }"><br>
                        <p>
						<label><span>������&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${book.sales_volume } ��</span></label><input type="hidden" name="book.sales_volume" value="${book.sales_volume }"><br>
                        <p>
						<label><span>���&nbsp;&nbsp;&nbsp;&nbsp;</span></label><input type="text" name="book.category" value="${book.category }"> <label> <span>(A or B or C or D)</span></label><br>
                        <p>
                        <input type="submit" value="�����޸�">
                        <input type="reset" value="�ָ�ԭֵ">
                     </form>
                 </td>
             </tr>
         </table>
      </td>
   </tr>