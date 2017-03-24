package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;

public class LogoutProcessServlet extends HttpServlet
{
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
      // �����в��õı��뷽ʽ��8859_1����ǰ�ı�����gb2312����Ҫת��
      request.setCharacterEncoding("gb2312");
        // ��ȡ�û��������Ϣ
      
      HttpSession session = request.getSession();
      session.invalidate();
      RequestDispatcher rd = request.getRequestDispatcher("index.jsp");  // ��ת����¼ҳ��
      rd.forward(request,response); // �����ת 

  }

  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
     doGet(request,response);
  }

}