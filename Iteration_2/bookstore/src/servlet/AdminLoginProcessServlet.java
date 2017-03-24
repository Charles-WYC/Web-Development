package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;

public class AdminLoginProcessServlet extends HttpServlet
{
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
      // �����в��õı��뷽ʽ��8859_1����ǰ�ı�����gb2312����Ҫת��
      request.setCharacterEncoding("gb2312");
        // ��ȡ�û��������Ϣ
        String username = request.getParameter("username");
        String userpass = request.getParameter("userpass");

        // ����JavaBean���������󡢳�ʼ����Ȼ����÷���
        UserBean user = new UserBean();
        user.setUsername(username);
        user.setPassword(userpass);
        boolean b = false;
        try{
            b = user.adminLogin();
        }catch(Exception e){
            // �������쳣��ʱ�򣬰��쳣��Ϣ����ڽ�����
                // ���ñ��뷽ʽ
                response.setContentType("text/html;charset=gb2312");
                // �õ����������
                PrintWriter out = response.getWriter();
                out.println(e.toString());
                return;
        }

        // ת����Ӧ����
        if(b){
           HttpSession session = request.getSession();
           session.setAttribute("user", user);
           BookStoreBean BookStore = new BookStoreBean();
           session.setAttribute("BookStore", BookStore);
           RequestDispatcher rd = request.getRequestDispatcher("adminFindAllBooks");  // ��ת���ɹ���ҳ��
           rd.forward(request,response); // �����ת 
        }
        else
        {
           request.setAttribute("info", "��½ʧ�ܣ�");
           RequestDispatcher rd = request.getRequestDispatcher("adminLogin.jsp");  // ��ת����¼ҳ��
           rd.forward(request,response); // �����ת 
        }

  }

  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
     doGet(request,response);
  }

}
