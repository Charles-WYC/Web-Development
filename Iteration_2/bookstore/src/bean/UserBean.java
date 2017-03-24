package bean;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import bean.*;
import java.util.ArrayList;

public class UserBean extends Base {
	private String username;
	private String password;
	private String mail_address;
	private String email;
	private String ID_number;
	private int userID;
	private String identity;
	
	public UserBean(){
	   }
	public UserBean(int userID)
	{
		this.userID = userID;
	}
	public UserBean(String username,String password, String mail_address, String email, String ID_number){
	   this.username = username;
	   this.password = password;
	   this.mail_address = mail_address;
	   this.email = email;
	   this.ID_number = ID_number;
	}

	public UserBean(String username,String password, String mail_address, String email, String ID_number, int userID, String identity){
	   this.username = username;
	   this.password = password;
	   this.mail_address = mail_address;
	   this.email = email;
	   this.ID_number = ID_number;
	   this.userID = userID;
	   this.identity = identity;
	}
	
	public void setUserID(int userID)
	{
		this.userID = userID;
	}
	public int getUserID()
	{
		return userID;
	}
	public void setID_number(String ID_number)
	{
		this.ID_number = ID_number;
	}
	public String getID_number()
	{
		return ID_number;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getEmail()
	{
		return email;
	}
	public void setMail_address(String mail_address)
	{
		this.mail_address = mail_address;
	}
	public String getMail_address()
	{
		return mail_address;
	}
	public void setUsername(String username){
	   this.username = username;
	}

	public String getUsername(){
	   return username;
	}

	public void setPassword(String password){
	   this.password = password;
	}

	public String getPassword(){
	   return password;
	}
	public void deleteUser()
	{
		   String sql = "delete form user where userID = ?";
		      try{
		         createStatement(sql);
		         stmt.setInt(1,userID);
		         executeUpdate();
		      }catch(Exception e){
		         System.out.println(e.toString());
		      }
		
	}
	public void updateUser()
	{
		   String sql = "update user set username= ?, password = ?, mail_address = ? where userID = ?";
		      try{
		         createStatement(sql);
		         stmt.setString(1, username);
		         stmt.setString(2, password);
		         stmt.setString(3, mail_address);
		         stmt.setInt(4,userID);
		         executeUpdate();
		         
		         sql = "update user_detail set email= ?, ID_number=? where userID = ?";
		         createStatement(sql);
		         stmt.setString(1, email);
		         stmt.setString(2, ID_number);
		         stmt.setInt(3,userID);
		         executeUpdate();
		      }catch(Exception e){
		         System.out.println(e.toString());
		      }
		
	}
	public boolean adminLogin() throws Exception{
		// ������������SQL���
				String sql = "select * from user where username=? and password=? and identity = 'admin' ";

				// ���Ĳ�����������������ִ��SQL����
		        createStatement(sql);

				// �Ա�����ֵ����һ��������ʾ��������ţ��ڼ����ʺţ����ڶ���������ʾ������ֵ
				stmt.setString(1,username);
				stmt.setString(2,password);

		        rs = executeQuery();

				//  rs�൱��һ������������С���������ɣ�ָ��ָ���һ����¼��ǰ��
				// ���������Խ�����д���ʹ��next�������б�����ʹ��get�����õ���ǰ�е���
				boolean b = rs.next();
				if(b)
				{
					userID = rs.getInt("userID");
					identity = "admin";
					sql = "select * from user natural join user_detail where userID = ?";
					createStatement(sql);
					stmt.setInt(1, userID);
					rs = executeQuery();
					rs.next();
					mail_address = rs.getString("mail_address");
					ID_number = rs.getString("ID_number");
					email = rs.getString("email");
				}

				return b;      
	}
	public boolean login() throws Exception{
		// ������������SQL���
		String sql = "select * from user where username=? and password=? and identity = 'customer'";

		// ���Ĳ�����������������ִ��SQL����
        createStatement(sql);

		// �Ա�����ֵ����һ��������ʾ��������ţ��ڼ����ʺţ����ڶ���������ʾ������ֵ
		stmt.setString(1,username);
		stmt.setString(2,password);

        rs = executeQuery();

		//  rs�൱��һ������������С���������ɣ�ָ��ָ���һ����¼��ǰ��
		// ���������Խ�����д���ʹ��next�������б�����ʹ��get�����õ���ǰ�е���
		boolean b = rs.next();
		if(b)
		{
			userID = rs.getInt("userID");
			identity = "customer";
			sql = "select * from user natural join user_detail where userID = ?";
			createStatement(sql);
			stmt.setInt(1, userID);
			rs = executeQuery();
			rs.next();
			mail_address = rs.getString("mail_address");
			ID_number = rs.getString("ID_number");
			email = rs.getString("email");
		}

		return b;      
	}
	
	public ArrayList<IndentBean> getIndents()
	{
		ArrayList<IndentBean> indents = new ArrayList();
		String sql = "select * from indent where userID = ?";
		try{
	         createStatement(sql);
	         
	         stmt.setInt(1, userID);
	         rs = executeQuery();
	         // ʹ��whileѭ�����������
	         while(rs.next())
	         {
	            // ʹ��rs��getString���������ַ�������ʽ��ȡ��һ�У�����Ҳ�������е�����
	            // ���Եõ���ǰ��¼��ÿһ��
	            int tempIndentID = rs.getInt("indentID");
	            String tempStatus = rs.getString("status");
	            float tempAmount = rs.getFloat("amount");
	            java.sql.Date tempTime = rs.getDate("time");
	            
	            IndentBean indent = new IndentBean(tempIndentID, tempStatus, tempAmount, tempTime);
	            indent.findAllItem();
	            
	            indents.add(indent);
	         }
	      }catch(Exception e){
	         System.out.println(e.toString());
	      }
		return indents;
	}
	public int newIndent(float total_price)
	{
		  int indentID = 0;
	      String sql = "insert into indent value(NULL, ?, ?, 'unpay',?)";
	      try{
	         createStatement(sql);
	         Date now = new Date();
	         SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
	         String time = dataFormat.format(now);
	         stmt.setInt(1, userID);
	         stmt.setFloat(2, total_price);
	         stmt.setString(3, time);
	         int n = executeUpdate();
	         if(n !=0)
	         {
	        	 sql = "select max(indentID) from indent";
	        	 createStatement(sql);
	        	 rs=executeQuery();
	        	 rs.next();
	        	 indentID = rs.getInt(1);
	         }
	        
	      }catch(Exception e){
	         System.out.println(e.toString());
	      }
	      return indentID;
		
	}
	
	public ArrayList<CartItem> getCart()
	{
	      ArrayList<CartItem> cartItems = new ArrayList();
	      String sql = "select * from shopping_cart join book join book_detail where userID = ? and shopping_cart.bookID = book.bookID and shopping_cart.bookID = book_detail.bookID";
	      try{
	         createStatement(sql);
	         
	         stmt.setInt(1, userID);
	         rs = executeQuery();
	         // ʹ��whileѭ�����������
	         while(rs.next())
	         {
	            // ʹ��rs��getString���������ַ�������ʽ��ȡ��һ�У�����Ҳ�������е�����
	            // ���Եõ���ǰ��¼��ÿһ��
	            int tempBookID = rs.getInt("bookID");
	            String tempBookName = rs.getString("book_name");
	            String tempAuthor = rs.getString("author");
	            float tempPrice = rs.getFloat("price");
	            String tempPublisher = rs.getString("publisher");
	            int tempNumber = rs.getInt("number");
	            
	            // ����ͼ�����
	            CartItem cartItem = new CartItem(userID, tempBookID, tempNumber, tempPrice, tempNumber*tempPrice, tempBookName,tempPublisher, tempAuthor);
	            
	            cartItems.add(cartItem);
	         }
	      }catch(Exception e){
	         System.out.println(e.toString());
	      }
	      return cartItems;
	}
	public boolean add()
	{
	      String sql = "select * from user where username = ?";
	      boolean success = true;    
	      try{
	    	 createStatement(sql);
	    	 
	    	 stmt.setString(1,username);

	         rs = executeQuery();
	    	 
	    	 if( !rs.next())
	    	 {
		    	 sql = "insert into user values(NULL,?,?,'customer',?)";
		         // ����������
		         createStatement(sql);
		         
		         // ��SQL����в�����ֵ
		         stmt.setString(1,username);
		         stmt.setString(2,password);
		         stmt.setString(3,mail_address);
	
		         // ִ��SQL���
		         int n = executeUpdate();
		         // ִ��û�н�������ص�SQL���ʹ��executeUpdate�����������ķ���ֵ����������ʾ�����ɹ��ļ�¼��
		         if(n==0)
		            success = false;
		         else
		         {
		        	 sql = "select userID from user where username = ?";
		        	 
		        	 createStatement(sql);
		        	 
		        	 stmt.setString(1,username);

			         rs = executeQuery();
		        	 
		        	 if(!rs.next())
		        	 {
		        		 success = false;
		        	 }
		        	 else
		        	 {
		        		 int userID = rs.getInt("userID");
		        		 sql = "insert into user_detail values(?,?,?)";
		        		 createStatement(sql);
		        		 stmt.setInt(1, userID);
		        		 stmt.setString(2, email);
		        		 stmt.setString(3, ID_number);
		        		 
		        		 n = executeUpdate();
		        		 
		        		 if(n == 0)
		        			 success = false;
		        		 else
		        		 {
		        			 this.userID=userID;
		        		 }
		        		
		        	 }
		         }
	    	 }
	    	 else
	    	 {
	    		 success = false;
	    	 }

	      }catch(Exception e){
	         success = false;
	         System.out.println(e.getMessage());
	      } 
	      return success;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}
}
