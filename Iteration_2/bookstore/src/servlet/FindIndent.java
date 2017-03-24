package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;
import java.util.ArrayList;

public class FindIndent extends HttpServlet
{
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
      // �����в��õı��뷽ʽ��8859_1����ǰ�ı�����gb2312����Ҫת��
      request.setCharacterEncoding("gb2312");

        // �ڶ��仰������JavaBean���������󡢳�ʼ����Ȼ����÷���
	    HttpSession session = request.getSession();
	    UserBean user = (UserBean) session.getAttribute("user");
        ArrayList<IndentBean> indents = user.getIndents();

        // �����仰����ҳ�洫����Ϣ����һ��������ʹ�õ����֣�Ӧ�ú���ʾʱ��ʹ�õ�����һ�£��ڶ����������ݵ�ֵ����
        request.setAttribute("indents",indents);
        // ���ľ仰��ת����Ӧ����
        RequestDispatcher rd = request.getRequestDispatcher("showindent.jsp"); 
        rd.forward(request,response); // �����ת

  }

  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
     doGet(request,response);
  }

}