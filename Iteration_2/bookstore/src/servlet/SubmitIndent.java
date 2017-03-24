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
	      // �����в��õı��뷽ʽ��8859_1����ǰ�ı�����gb2312����Ҫת��
	      request.setCharacterEncoding("gb2312");

	        // �ڶ��仰������JavaBean���������󡢳�ʼ����Ȼ����÷���
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
		    
	        // �����仰����ҳ�洫����Ϣ����һ��������ʹ�õ����֣�Ӧ�ú���ʾʱ��ʹ�õ�����һ�£��ڶ����������ݵ�ֵ����
	        request.setAttribute("indent",indent);
	        // ���ľ仰��ת����Ӧ����
	        RequestDispatcher rd = request.getRequestDispatcher("showNewIndent.jsp"); 
	        rd.forward(request,response); // �����ת

	  }

	  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	  {
	     doGet(request,response);
	  }
}
