<%@ page contentType="text/html;charset=gb2312" import="bean.BookBean"%>

<%@ include file="adminHeader.jsp"%>

   <tr>
      <td>
         <table>
             <tr align="left">
                 <td>
                     <!--ע��������-->
                     <form action="addBook" method="post">
                        <label><span>������&nbsp;&nbsp;</span><input type="text" name="book_name" value=""> </label><br>
                        <p>
						<label><span>���ߣ�&nbsp;&nbsp;</span><input type="text" name="author" value=""> </label><br> 
                        <p>
                        <label><span>�����磺</span><input type="text" name="publisher" value=""> </label><br>
                        <p>
						<label><span>���ۣ�&nbsp;&nbsp;</span><input type="text" name="price" value=""></label><br>
                        <p>
						<label><span>��棺&nbsp;&nbsp;</span><input type="text" name="quantity" value=""> </label><br>
                        <p>
						<label><span>������&nbsp;&nbsp;</span><input type="text" name="sales_volume" value=""> </label><br>
                        <p>
						<label><span>���&nbsp;&nbsp;</span><input type="text" name="category" value=""></label><label> <span>(A or B or C or D)</span></label><br>
                        <p>
                        <input type="submit" value="�ύ">
                        <input type="reset" value="���">
                     </form>
                 </td>
             </tr>
         </table>
      </td>
   </tr>