package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;

public class LogoutProcessServlet extends HttpServlet
{
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
      // 请求中采用的编码方式是8859_1，当前的编码是gb2312，需要转换
      request.setCharacterEncoding("gb2312");
        // 获取用户输入的信息
      
      HttpSession session = request.getSession();
      session.invalidate();
      RequestDispatcher rd = request.getRequestDispatcher("index.jsp");  // 跳转到登录页面
      rd.forward(request,response); // 完成跳转 

  }

  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
     doGet(request,response);
  }

}