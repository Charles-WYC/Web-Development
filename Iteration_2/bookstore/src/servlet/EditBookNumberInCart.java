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
	        // 请求中采用的编码方式是8859_1，当前的编码是gb2312，需要转换
	        request.setCharacterEncoding("gb2312");

	        // 第一句话：获取用户输入的信息
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

	        // 第四句话：转向响应界面
	        RequestDispatcher rd = request.getRequestDispatcher("findCart"); 
	        rd.forward(request,response); // 完成跳转
	       
	  }

	  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	  {
	     doGet(request,response);
	  }
	
}
