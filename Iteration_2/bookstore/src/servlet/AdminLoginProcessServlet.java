package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;

public class AdminLoginProcessServlet extends HttpServlet
{
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
      // 请求中采用的编码方式是8859_1，当前的编码是gb2312，需要转换
      request.setCharacterEncoding("gb2312");
        // 获取用户输入的信息
        String username = request.getParameter("username");
        String userpass = request.getParameter("userpass");

        // 调用JavaBean，创建对象、初始化、然后调用方法
        UserBean user = new UserBean();
        user.setUsername(username);
        user.setPassword(userpass);
        boolean b = false;
        try{
            b = user.adminLogin();
        }catch(Exception e){
            // 当产生异常的时候，把异常信息输出在界面上
                // 设置编码方式
                response.setContentType("text/html;charset=gb2312");
                // 得到输出流对象
                PrintWriter out = response.getWriter();
                out.println(e.toString());
                return;
        }

        // 转向响应界面
        if(b){
           HttpSession session = request.getSession();
           session.setAttribute("user", user);
           BookStoreBean BookStore = new BookStoreBean();
           session.setAttribute("BookStore", BookStore);
           RequestDispatcher rd = request.getRequestDispatcher("adminFindAllBooks");  // 跳转到成功的页面
           rd.forward(request,response); // 完成跳转 
        }
        else
        {
           request.setAttribute("info", "登陆失败！");
           RequestDispatcher rd = request.getRequestDispatcher("adminLogin.jsp");  // 跳转到登录页面
           rd.forward(request,response); // 完成跳转 
        }

  }

  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
     doGet(request,response);
  }

}
