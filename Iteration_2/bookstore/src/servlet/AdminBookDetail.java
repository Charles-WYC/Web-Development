package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BookBean;
import bean.UserBean;

public class AdminBookDetail extends HttpServlet{
	  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	  {
	        // �����в��õı��뷽ʽ��8859_1����ǰ�ı�����gb2312����Ҫת��
	        request.setCharacterEncoding("gb2312");
	        
		  	int bookID = Integer.parseInt(request.getParameter("bookID"));
		  
		  	BookBean book = new BookBean();
		  	book.getBookByID(bookID);

	        // �����仰����ҳ�洫����Ϣ����һ��������ʹ�õ����֣�Ӧ�ú���ʾʱ��ʹ�õ�����һ�£��ڶ����������ݵ�ֵ����
	        request.setAttribute("book",book);

	        // ���ľ仰��ת����Ӧ����
	        RequestDispatcher rd = request.getRequestDispatcher("adminbookdetail.jsp"); 
	        rd.forward(request,response); // �����ת

	  }

	  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	  {
	     doGet(request,response);
	  }

}
