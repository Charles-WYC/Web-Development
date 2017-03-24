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
	        // 请求中采用的编码方式是8859_1，当前的编码是gb2312，需要转换
	        request.setCharacterEncoding("gb2312");

	        // 第一句话：获取用户输入的信息
	        int userID = Integer.parseInt(request.getParameter("userID"));
	        UserBean user = new UserBean(userID);
	        user.deleteUser();
	        // 第四句话：转向响应界面
	        RequestDispatcher rd = request.getRequestDispatcher("findAlluser"); 
	        rd.forward(request,response); // 完成跳转
	       
	  }

	  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	  {
	     doGet(request,response);
	  }
	
}