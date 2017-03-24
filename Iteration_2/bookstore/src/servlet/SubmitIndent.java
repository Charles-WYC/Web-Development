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

public class SubmitIndent extends HttpServlet{
	  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	  {
	      // 请求中采用的编码方式是8859_1，当前的编码是gb2312，需要转换
	      request.setCharacterEncoding("gb2312");

	        // 第二句话：调用JavaBean，创建对象、初始化、然后调用方法
		    HttpSession session = request.getSession();
		    UserBean user = (UserBean) session.getAttribute("user");
		    String[] items = request.getParameterValues("items");
		    int userID = user.getUserID();
		    float sum=0;
		    ArrayList<CartItem> cartItems = new ArrayList();
		    for(int i =0; i<items.length;i++)
		    {
		    	CartItem cartItem = new CartItem(userID,Integer.parseInt(items[i]));
		    	cartItems.add(cartItem);
		    	sum+=cartItem.getTotal_price();
		    }
		    
		    int indentID = user.newIndent(sum);
		    IndentBean indent = new IndentBean(indentID);
		    
		    for(int i = 0; i<items.length;i++)
		    {
		    	indent.addItemIntoShipment(Integer.parseInt(items[i]), cartItems.get(i).getNumber());
		    }

		    for(int i =0; i<items.length;i++)
		    {
		    	cartItems.get(i).deleteItem();
		    }
		    indent.getIndentInfo();
		    indent.findAllItem();
		    
	        // 第三句话：向页面传递信息，第一个参数是使用的名字，应该和显示时候使用的名字一致，第二个参数传递的值本身
	        request.setAttribute("indent",indent);
	        // 第四句话：转向响应界面
	        RequestDispatcher rd = request.getRequestDispatcher("showNewIndent.jsp"); 
	        rd.forward(request,response); // 完成跳转

	  }

	  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	  {
	     doGet(request,response);
	  }
}
