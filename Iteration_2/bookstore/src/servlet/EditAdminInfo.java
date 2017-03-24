package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;

public class EditAdminInfo extends HttpServlet
{
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
        // �����в��õı��뷽ʽ��8859_1����ǰ�ı�����gb2312����Ҫת��
        request.setCharacterEncoding("gb2312");

        // ��һ�仰����ȡ�û��������Ϣ
        int userID = Integer.parseInt(request.getParameter("userID"));
        
        String username = request.getParameter("username");

        String password = request.getParameter("password");

        String mail_address = request.getParameter("mail_address");

        String email = request.getParameter("email");

        String ID_number = request.getParameter("ID_number");

        // �ڶ��仰������JavaBean���������󡢳�ʼ����Ȼ����÷���
        UserBean user = new UserBean();
        user.setUserID(userID);
        user.setUsername(username);
        user.setPassword(password);
        user.setMail_address(mail_address);
        user.setEmail(email);
        user.setID_number(ID_number);
        user.setIdentity("customer");
        user.updateUser();
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        	
        RequestDispatcher rd = request.getRequestDispatcher("adminInfo.jsp"); 
        rd.forward(request,response); 
  }

  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
     doGet(request,response);
  }

}