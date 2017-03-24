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
      // �����в��õı��뷽ʽ��8859_1����ǰ�ı�����gb2312����Ҫת��
      request.setCharacterEncoding("gb2312");

        // �ڶ��仰������JavaBean���������󡢳�ʼ����Ȼ����÷���
	    HttpSession session = request.getSession();
	    BookStoreBean BookStore = (BookStoreBean) session.getAttribute("BookStore");
        ArrayList books = BookStore.findAllBooks();

        // �����仰����ҳ�洫����Ϣ����һ��������ʹ�õ����֣�Ӧ�ú���ʾʱ��ʹ�õ�����һ�£��ڶ����������ݵ�ֵ����
        request.setAttribute("books",books);

        // ���ľ仰��ת����Ӧ����
        RequestDispatcher rd = request.getRequestDispatcher("adminShowbook.jsp"); 
        rd.forward(request,response); // �����ת

  }

  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
     doGet(request,response);
  }

}