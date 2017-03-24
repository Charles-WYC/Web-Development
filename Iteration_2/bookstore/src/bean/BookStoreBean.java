package bean;

import java.sql.Date;
import java.util.ArrayList;

public class BookStoreBean extends Base{

	   public ArrayList findAllBooks(){
	      ArrayList books = new ArrayList();
	      String sql = "select * from book natural join book_detail";
	      try{
	         createStatement(sql);
	         rs = executeQuery();
	         // 使用while循环遍历结果集
	         while(rs.next())
	         {
	            // 使用rs的getString方法，以字符串的形式获取第一列，参数也可以是列的名字
	            // 可以得到当前记录的每一列
	            int bookID = rs.getInt("bookID");
	            String book_name = rs.getString("book_name");
	            String author = rs.getString("author");
	            float price = rs.getFloat("price");
	            String publisher = rs.getString("publisher");
	            int quantity = rs.getInt("quantity");
	            int sales_volume = rs.getInt("sales_volume");
	            String category = rs.getString("category");
	            // 创建图书对象
	            BookBean book = new BookBean(bookID, price, quantity, book_name, author, publisher, sales_volume,category);
	            books.add(book);
	         }
	      }catch(Exception e){
	         System.out.println(e.toString());
	      }
	      return books;
	   }
	   
	   public ArrayList findBooksOnCondition(String bookID, String price, String sales_volume, String quantity,String book_name, String author, String publisher, String category){
		      ArrayList books = new ArrayList();
		      String sql = "select * from book natural join book_detail where ";
		      ArrayList<String> strings=new ArrayList();
		      ArrayList<String> stringp=new ArrayList();
		      if(bookID !="")
		      {
		    	  sql+="bookID = ? and   ";
		    	  strings.add(bookID);
		    	  stringp.add("bookID");
		      }
		      if(price != "")
		      {
		    	  sql+="price = ? and   ";
		    	  strings.add(price);
		    	  stringp.add("price");
		      }
		      if(sales_volume !="")
		      {
		    	  sql+="sales_volume = ? and   ";
		    	  strings.add(sales_volume);
		    	  stringp.add("sales_volume");
		      }
		      if(quantity != "")
		      {
		    	  sql+="quantity = ? and   ";
		    	  strings.add(quantity);
		    	  stringp.add("quantity");
		      }
		      if(book_name != "")
		      {
		    	  sql+="book_name = ? and   ";
		    	  strings.add(book_name);
		    	  stringp.add("book_name");
		      }
		      if(author != "")
		      {
		    	  sql+="author = ? and   ";
		    	  strings.add(author);
		    	  stringp.add("author");
		      }
		      if(publisher != "")
		      {
		    	  sql+="publisher = ? and   ";
		    	  strings.add(publisher);
		    	  stringp.add("publisher");
		      }
		      if(category !="")
		      {
		    	  sql+="category = ? and   ";
		    	  strings.add(category);
		    	  stringp.add("category");
		      }
		      int i = sql.length();
		      sql=sql.substring(0, i-6).trim();
		      try{
		         createStatement(sql);
		         int k = strings.size();
		         for(i = 0; i<k; i++)
		         {
		        	 if(stringp.get(i)=="price" ){
			        	 stmt.setFloat(i+1, Float.parseFloat(strings.get(i)));
		        	 }
		        	 else if(stringp.get(i)=="quantity" || stringp.get(i)=="sales_volume" || stringp.get(i)=="bookID")
		        	 {
			        	 stmt.setInt(i+1, Integer.parseInt(strings.get(i)));
		        	 }
		        	 else
		        	 {
			        	 stmt.setString(i+1, strings.get(i));
		        	 }
		         }
		         rs = executeQuery();
		         // 使用while循环遍历结果集
		         while(rs.next())
		         {
		            // 使用rs的getString方法，以字符串的形式获取第一列，参数也可以是列的名字
		            // 可以得到当前记录的每一列
		            int tempbookID = rs.getInt("bookID");
		            String tempbook_name = rs.getString("book_name");
		            String tempauthor = rs.getString("author");
		            float tempprice = rs.getFloat("price");
		            String temppublisher = rs.getString("publisher");
		            int tempquantity = rs.getInt("quantity");
		            int tempsales_volume = rs.getInt("sales_volume");
		            String tempcategory = rs.getString("category");
		            // 创建图书对象
		            BookBean book = new BookBean(tempbookID, tempprice, tempquantity, tempbook_name, tempauthor, temppublisher, tempsales_volume,tempcategory);
		            books.add(book);
		         }
		      }catch(Exception e){
		         System.out.println(e.toString());
		      }
		      return books;
		   }

	   public ArrayList findAllUser(){
	      ArrayList users = new ArrayList();
	      String sql = "select * from user natural join user_detail where identity = 'customer' ";
	      try{
	         createStatement(sql);
	         rs = executeQuery();
	         // 使用while循环遍历结果集
	         while(rs.next())
	         {
	            // 使用rs的getString方法，以字符串的形式获取第一列，参数也可以是列的名字
	            // 可以得到当前记录的每一列
	        	int tempUserID = rs.getInt("userID");
	        	String tempUsername = rs.getString("username");
	        	String tempPassword = rs.getString("password");
	        	String tempMailAddress = rs.getString("mail_address");
	        	String tempEmail = rs.getString("email");
	        	String tempIDNumber = rs.getString("ID_number");
	        	
	        	UserBean user = new UserBean(tempUsername,tempPassword, tempMailAddress, tempEmail, tempIDNumber,tempUserID, "customer");
	        	users.add(user);
	         }
	      }catch(Exception e){
	         System.out.println(e.toString());
	      }
	      return users;
	   }

	   public ArrayList findAllIndent(){
	      ArrayList indents = new ArrayList();
	      String sql = "select * from indent ";
	      try{
	         createStatement(sql);
	         rs = executeQuery();
	         // 使用while循环遍历结果集
	         while(rs.next())
	         {
	            // 使用rs的getString方法，以字符串的形式获取第一列，参数也可以是列的名字
	            // 可以得到当前记录的每一列
	        	int tempIndentID = rs.getInt("indentID");
	        	int tempUserID = rs.getInt("userID");
	        	float tempAmount = rs.getFloat("amount");
	        	Date tempTime = rs.getDate("time");
	        	String tempStatus = rs.getString("status");
	        	
	        	IndentBean indent = new IndentBean(tempIndentID, tempStatus, tempAmount, tempTime, tempUserID);
	        	indent.findAllItem();
	        	indents.add(indent);
	        	
	         }
	      }catch(Exception e){
	         System.out.println(e.toString());
	      }
	      return indents;
	   }
}
