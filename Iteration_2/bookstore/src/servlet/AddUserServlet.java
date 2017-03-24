package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;

public class AddUserServlet extends HttpServlet
{
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
        // 请求中采用的编码方式是8859_1，当前的编码是gb2312，需要转换
        request.setCharacterEncoding("gb2312");

        // 第一句话：获取用户输入的信息
        String username = request.getParameter("username");

        String password = request.getParameter("password");

        String mail_address = request.getParameter("mail_address");

        String email = request.getParameter("email");

        String ID_number = request.getParameter("ID_number");

        // 第二句话：调用JavaBean，创建对象、初始化、然后调用方法
        UserBean user = new UserBean();
        user.setUsername(username);
        user.setPassword(password);
        user.setMail_address(mail_address);
        user.setEmail(email);
        user.setID_number(ID_number);

        boolean b = user.add();

        // 第三句话：向页面传递信息
        if(b)
        {
            request.setAttribute("info","注册成功！请登录！");
        	
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp"); 
            rd.forward(request,response); // 完成跳转
        }
        else
        {
            request.setAttribute("info","注册失败！");

            // 第四句话：转向响应界面
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp"); 
            rd.forward(request,response); // 完成跳转
        }

  }

  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
     doGet(request,response);
  }

}
