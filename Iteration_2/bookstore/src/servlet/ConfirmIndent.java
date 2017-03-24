package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CartItem;
import bean.IndentBean;
import bean.UserBean;

public class ConfirmIndent extends HttpServlet{
	  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	  {
	      // �����в��õı��뷽ʽ��8859_1����ǰ�ı�����gb2312����Ҫת��
	      request.setCharacterEncoding("gb2312");
	        // �ڶ��仰������JavaBean���������󡢳�ʼ����Ȼ����÷���
		    int indentID = Integer.parseInt(request.getParameter("indentID"));
		    
		    IndentBean indent = new IndentBean(indentID);
		    indent.confirmIndent();
	        // ���ľ仰��ת����Ӧ����
	        RequestDispatcher rd = request.getRequestDispatcher("findIndent"); 
	        rd.forward(request,response); // �����ת

	  }

	  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	  {
	     doGet(request,response);
	  }
}