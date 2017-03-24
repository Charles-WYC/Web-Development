package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BookBean;
import bean.IndentBean;
import bean.UserBean;

public class DeleteIndent extends HttpServlet{
	  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	  {
	        // �����в��õı��뷽ʽ��8859_1����ǰ�ı�����gb2312����Ҫת��
	        request.setCharacterEncoding("gb2312");

	        // ��һ�仰����ȡ�û��������Ϣ
	        int indentID = Integer.parseInt(request.getParameter("indentID"));
	        IndentBean indent = new IndentBean(indentID);
	        indent.deleteIndent();
	        // ���ľ仰��ת����Ӧ����
	        HttpSession session = request.getSession();
	        UserBean user = (UserBean) session.getAttribute("user");
	        if(user.getIdentity()=="admin")
	        {
		        RequestDispatcher rd = request.getRequestDispatcher("adminFindAllIndent"); 
		        rd.forward(request,response); // �����ת
	        	
	        }
	        else
	        {
		        RequestDispatcher rd = request.getRequestDispatcher("findIndent"); 
		        rd.forward(request,response); // �����ת
	        	
	        }
	       
	  }

	  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	  {
	     doGet(request,response);
	  }
	
}