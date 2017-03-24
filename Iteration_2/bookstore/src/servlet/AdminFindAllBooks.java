package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;
import java.util.ArrayList;

public class AdminFindAllBooks extends HttpServlet
{
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
      // 请求中采用的编码方式是8859_1，当前的编码是gb2312，需要转换
      request.setCharacterEncoding("gb2312");

        // 第二句话：调用JavaBean，创建对象、初始化、然后调用方法
	    HttpSession session = request.getSession();
	    BookStoreBean BookStore = (BookStoreBean) session.getAttribute("BookStore");
        ArrayList books = BookStore.findAllBooks();

        // 第三句话：向页面传递信息，第一个参数是使用的名字，应该和显示时候使用的名字一致，第二个参数传递的值本身
        request.setAttribute("books",books);

        // 第四句话：转向响应界面
        RequestDispatcher rd = request.getRequestDispatcher("adminShowbook.jsp"); 
        rd.forward(request,response); // 完成跳转

  }

  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
     doGet(request,response);
  }

}