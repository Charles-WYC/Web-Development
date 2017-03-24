package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;

public class AddUserServlet extends HttpServlet
{
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
        // �����в��õı��뷽ʽ��8859_1����ǰ�ı�����gb2312����Ҫת��
        request.setCharacterEncoding("gb2312");

        // ��һ�仰����ȡ�û��������Ϣ
        String username = request.getParameter("username");

        String password = request.getParameter("password");

        String mail_address = request.getParameter("mail_address");

        String email = request.getParameter("email");

        String ID_number = request.getParameter("ID_number");

        // �ڶ��仰������JavaBean���������󡢳�ʼ����Ȼ����÷���
        UserBean user = new UserBean();
        user.setUsername(username);
        user.setPassword(password);
        user.setMail_address(mail_address);
        user.setEmail(email);
        user.setID_number(ID_number);

        boolean b = user.add();

        // �����仰����ҳ�洫����Ϣ
        if(b)
        {
            request.setAttribute("info","ע��ɹ������¼��");
        	
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp"); 
            rd.forward(request,response); // �����ת
        }
        else
        {
            request.setAttribute("info","ע��ʧ�ܣ�");

            // ���ľ仰��ת����Ӧ����
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp"); 
            rd.forward(request,response); // �����ת
        }

  }

  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
     doGet(request,response);
  }

}
