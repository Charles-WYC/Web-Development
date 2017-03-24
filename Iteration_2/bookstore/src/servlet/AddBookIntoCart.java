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
        // �����в��õı��뷽ʽ��8859_1����ǰ�ı�����gb2312����Ҫת��
        request.setCharacterEncoding("gb2312");

        // ��һ�仰����ȡ�û��������Ϣ
        int bookID = Integer.parseInt(request.getParameter("bookID"));
        int number = Integer.parseInt(request.getParameter("number"));
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("user");
        int userID = user.getUserID();
        CartItem cartItem = new CartItem(userID, bookID, number);
        if(cartItem.add())
        {
            RequestDispatcher rd = request.getRequestDispatcher("findCart"); 
            rd.forward(request,response); // �����ת
        }
        else
        {
        	JOptionPane.showMessageDialog(null, "������ʾ", "���빺�ﳵʧ��", JOptionPane.ERROR_MESSAGE); 
        }
       
  }

  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
     doGet(request,response);
  }

}