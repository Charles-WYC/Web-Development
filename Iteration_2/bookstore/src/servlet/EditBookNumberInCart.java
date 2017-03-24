package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.CartItem;
import bean.UserBean;

public class EditBookNumberInCart extends HttpServlet{
	  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	  {
	        // �����в��õı��뷽ʽ��8859_1����ǰ�ı�����gb2312����Ҫת��
	        request.setCharacterEncoding("gb2312");

	        // ��һ�仰����ȡ�û��������Ϣ
	        int bookID = Integer.parseInt(request.getParameter("bookID"));
	        int action = Integer.parseInt(request.getParameter("action"));
	        HttpSession session = request.getSession();
	        UserBean user = (UserBean) session.getAttribute("user");
	        int userID = user.getUserID();
	        CartItem cartItem = new CartItem();
	        cartItem.setBookID(bookID);
	        cartItem.setUserID(userID);
	        if(action == 0)
	        {
	        	cartItem.deleteItem();
	        }
	        else if(action == 1)
	        {
		        int degree = Integer.parseInt(request.getParameter("degree"));
	        	cartItem.increase(degree);
	        }
	        else
	        {
		        int degree = Integer.parseInt(request.getParameter("degree"));
	        	cartItem.decrease(degree);
	        }

	        // ���ľ仰��ת����Ӧ����
	        RequestDispatcher rd = request.getRequestDispatcher("findCart"); 
	        rd.forward(request,response); // �����ת
	       
	  }

	  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	  {
	     doGet(request,response);
	  }
	
}
