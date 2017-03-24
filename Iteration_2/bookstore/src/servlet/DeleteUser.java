package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.BookBean;
import bean.UserBean;

public class DeleteUser extends HttpServlet{
	  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	  {
	        // �����в��õı��뷽ʽ��8859_1����ǰ�ı�����gb2312����Ҫת��
	        request.setCharacterEncoding("gb2312");

	        // ��һ�仰����ȡ�û��������Ϣ
	        int userID = Integer.parseInt(request.getParameter("userID"));
	        UserBean user = new UserBean(userID);
	        user.deleteUser();
	        // ���ľ仰��ת����Ӧ����
	        RequestDispatcher rd = request.getRequestDispatcher("findAlluser"); 
	        rd.forward(request,response); // �����ת
	       
	  }

	  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	  {
	     doGet(request,response);
	  }
	
}