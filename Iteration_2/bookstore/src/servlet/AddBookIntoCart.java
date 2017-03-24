package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.swing.JOptionPane;

import bean.*;

public class AddBookIntoCart extends HttpServlet
{
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
        // 请求中采用的编码方式是8859_1，当前的编码是gb2312，需要转换
        request.setCharacterEncoding("gb2312");

        // 第一句话：获取用户输入的信息
        int bookID = Integer.parseInt(request.getParameter("bookID"));
        int number = Integer.parseInt(request.getParameter("number"));
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("user");
        int userID = user.getUserID();
        CartItem cartItem = new CartItem(userID, bookID, number);
        if(cartItem.add())
        {
            RequestDispatcher rd = request.getRequestDispatcher("findCart"); 
            rd.forward(request,response); // 完成跳转
        }
        else
        {
        	JOptionPane.showMessageDialog(null, "错误提示", "加入购物车失败", JOptionPane.ERROR_MESSAGE); 
        }
       
  }

  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
     doGet(request,response);
  }

}