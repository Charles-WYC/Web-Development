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
	      // 请求中采用的编码方式是8859_1，当前的编码是gb2312，需要转换
	      request.setCharacterEncoding("gb2312");
	        // 第二句话：调用JavaBean，创建对象、初始化、然后调用方法
		    int indentID = Integer.parseInt(request.getParameter("indentID"));
		    
		    IndentBean indent = new IndentBean(indentID);
		    indent.confirmIndent();
	        // 第四句话：转向响应界面
	        RequestDispatcher rd = request.getRequestDispatcher("findIndent"); 
	        rd.forward(request,response); // 完成跳转

	  }

	  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	  {
	     doGet(request,response);
	  }
}