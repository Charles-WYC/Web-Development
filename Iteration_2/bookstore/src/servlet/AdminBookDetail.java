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
	        // 请求中采用的编码方式是8859_1，当前的编码是gb2312，需要转换
	        request.setCharacterEncoding("gb2312");
	        
		  	int bookID = Integer.parseInt(request.getParameter("bookID"));
		  
		  	BookBean book = new BookBean();
		  	book.getBookByID(bookID);

	        // 第三句话：向页面传递信息，第一个参数是使用的名字，应该和显示时候使用的名字一致，第二个参数传递的值本身
	        request.setAttribute("book",book);

	        // 第四句话：转向响应界面
	        RequestDispatcher rd = request.getRequestDispatcher("adminbookdetail.jsp"); 
	        rd.forward(request,response); // 完成跳转

	  }

	  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	  {
	     doGet(request,response);
	  }

}
