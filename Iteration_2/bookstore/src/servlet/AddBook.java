package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;

public class AddBook extends HttpServlet
{
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
        // 请求中采用的编码方式是8859_1，当前的编码是gb2312，需要转换
        request.setCharacterEncoding("gb2312");

        // 第一句话：获取用户输入的信息
        String book_name = request.getParameter("book_name");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        float price = Float.parseFloat(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int sales_volume = Integer.parseInt(request.getParameter("sales_volume"));
        String category = request.getParameter("category");
        BookBean book = new BookBean( price, quantity, book_name, author, publisher, sales_volume,category);
        book.addBook();
        request.setAttribute("book", book);
        RequestDispatcher rd = request.getRequestDispatcher("adminbookdetail.jsp"); 
        rd.forward(request,response); 

  }

  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
     doGet(request,response);
  }

}