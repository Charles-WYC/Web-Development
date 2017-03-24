package servlet;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;

public class FindBooksOnCondition extends HttpServlet
{
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
        // �����в��õı��뷽ʽ��8859_1����ǰ�ı�����gb2312����Ҫת��
        request.setCharacterEncoding("gb2312");
        HttpSession session = request.getSession();
        BookStoreBean BookStore= (BookStoreBean) session.getAttribute("BookStore");
        // ��һ�仰����ȡ�û��������Ϣ
        String bookID = request.getParameter("bookID");
        String book_name = request.getParameter("book_name");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String sales_volume = request.getParameter("sales_volume");
        String category = request.getParameter("category");
        ArrayList<BookBean> books = BookStore.findBooksOnCondition(bookID, price, sales_volume, quantity,book_name, author, publisher, category);
        request.setAttribute("books", books);
        request.setAttribute("preBookID", bookID);
        request.setAttribute("preBook_name", book_name);
        request.setAttribute("preAuthor", author);
        request.setAttribute("prePulisher", publisher);
        request.setAttribute("prePrice", price);
        request.setAttribute("preQuantity", quantity);
        request.setAttribute("preSales_volume", sales_volume);
        request.setAttribute("preCategory", category);
        
        RequestDispatcher rd = request.getRequestDispatcher("showbook.jsp"); 
        rd.forward(request,response); 

  }

  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
     doGet(request,response);
  }

}