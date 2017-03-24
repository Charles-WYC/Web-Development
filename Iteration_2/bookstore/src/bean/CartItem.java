package bean;

import javax.servlet.RequestDispatcher;

public class CartItem extends Base{
	private int userID;
	private int bookID;
	private int number;
	private float price;
	private float total_price;
	private String book_name;
	private String publisher;
	private String author;
	
	public CartItem(int userID, int bookID, int number, float price, float total_price, String book_name, String publisher, String author)
	{
		this.userID = userID;
		this.bookID = bookID;
		this.number = number;
		this.price = price;
		this.total_price = total_price;
		this.book_name = book_name;
		this.publisher = publisher;
		this.author = author;
	}
	
	public CartItem(int userID, int bookID)
	{
		this.bookID = bookID;
		this.userID = userID;
		getCartItemInfo();
	}
	   public CartItem(int userID, int bookID, int number)
	   {
		   this.bookID = bookID;
		   this.userID = userID;
		   this.number = number;
	   }
	   public CartItem()
	   {
		   
	   }
	   public void getCartItemInfo()
	   {
			  String sql = "select * from shopping_cart where userID = ? and bookID = ?";   
		      try{
		    	 createStatement(sql);
		    	 
		    	 stmt.setInt(1, userID);
		    	 stmt.setInt(2, bookID);
		         rs = executeQuery();
		    	 
		    	 if( rs.next())
		    	 {
		    		 number = rs.getInt("number");
		    		 
		    		 sql = "select * from book where bookID = ?";
		    		 createStatement(sql);
		    		 stmt.setInt(1, bookID);
		    		 rs = executeQuery();
		    		 rs.next();
		    		 price = rs.getFloat("price");
		    		 total_price = number*price;
		    	 }
		    	 else
		    	 {
		    	 }

		      }catch(Exception e){
		         System.out.println(e.getMessage());
		      }
		      return ;
		   
	   }
	   public void setNumber(int number)
	   {
		   this.number = number;
	   }
	   
	   public int getNumber()
	   {
		   return number;
	   }
	   // 编写对乘员进行操作的方法
	   public void setBookID(int bookID){
	      this.bookID = bookID;
	   }

	   public int getBookID(){
	      return bookID;
	   }

		public void setUserID(int userID)
		{
			this.userID = userID;
		}
		public int getUserID()
		{
			return userID;
		}
		
		public boolean add()
		{
			  String sql = "select * from shopping_cart where userID = ? and bookID = ?";
		      boolean success = true;    
		      try{
		    	 createStatement(sql);
		    	 
		    	 stmt.setInt(1, userID);
		    	 stmt.setInt(2, bookID);
		         rs = executeQuery();
		    	 int n;
		    	 
		    	 if( rs.next())
		    	 {
		    		 int preNumber = rs.getInt("number");
		    		 number += preNumber;
		    		 
		    		 sql = "update shopping_cart set number = ?";
		    		 createStatement(sql);
		    		 stmt.setInt(1, number);
		    		 
		    		 n = executeUpdate();
		    		 if(n==0)
		    			 success = false;
		    	 }
		    	 else
		    	 {
			    	 sql = "insert into shopping_cart values(?,?,?)";
			         // 创建语句对象
			         createStatement(sql);
			         
			         // 对SQL语句中参数赋值
			         stmt.setInt(1,userID);
			         stmt.setInt(2,bookID);
			         stmt.setInt(3,number);
		
			         // 执行SQL语句
			         n = executeUpdate();
			         // 执行没有结果集返回的SQL语句使用executeUpdate方法，方法的返回值是整数，表示操作成功的记录数
			         if(n==0)
			            success = false;

		    	 }

		      }catch(Exception e){
		         success = false;
		         System.out.println(e.getMessage());
		      }
		      return success;
		}
		
		public boolean increase(int degree)
		{
			  String sql = "select * from shopping_cart where userID = ? and bookID = ?";
		      boolean success = true;    
		      try{
		    	 createStatement(sql);
		    	 
		    	 stmt.setInt(1, userID);
		    	 stmt.setInt(2, bookID);
		         rs = executeQuery();
		         int n;
		    	 rs.next();
		    	 int preNumber = rs.getInt("number");
		    	 number = preNumber+degree;
	    		 
	    		 sql = "update shopping_cart set number = ? where userID = ? and bookID = ?";
	    		 createStatement(sql);
	    		 stmt.setInt(1, number);
	    		 stmt.setInt(2, userID);
	    		 stmt.setInt(3, bookID);
		    		 
		    	n = executeUpdate();
		    	if(n==0)
		    		success = false;

		      }catch(Exception e){
		         success = false;
		         System.out.println(e.getMessage());
		      }
		      return success;
		}
		
		public boolean deleteItem()
		{
			  String sql = "delete from shopping_cart where userID = ? and bookID = ?";
		      boolean success = true;    
		      try{
		    	 createStatement(sql);
		    	 
		    	 stmt.setInt(1,userID);
		    	 stmt.setInt(2, bookID);
		    	 int n = executeUpdate();
		    	if(n==0)
		    		success = false;

		      }catch(Exception e){
		         success = false;
		         System.out.println(e.getMessage());
		      }
		      return success;
		}
		
		public boolean decrease(int degree)
		{
			  String sql = "select * from shopping_cart where userID = ? and bookID = ?";
		      boolean success = true;    
		      try{
		    	 createStatement(sql);
		    	 
		    	 stmt.setInt(1,userID);
		    	 stmt.setInt(2, bookID);
		         rs = executeQuery();
		    	 rs.next();
		    	 int preNumber = rs.getInt("number");
		    	 if(preNumber<=degree)
		    	 {
		    		 if(deleteItem() == false)
		    		 {
		    			 success = false;
		    		 }
		    	 }
		    	 else
		    	 {
		    		 number = preNumber-degree;
		    		 
		    		 sql = "update shopping_cart set number = ? where userID = ? and bookID = ?";
		    		 createStatement(sql);
		    		 stmt.setInt(1, number);
		    		 stmt.setInt(2, userID);
		    		 stmt.setInt(3, bookID);
		    		 
		    		 int n = executeUpdate();
		    		 if(n==0)
		    			 success = false;
		    	 }
		      }catch(Exception e){
		         success = false;
		         System.out.println(e.getMessage());
		      }
		      return success;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public float getTotal_price() {
			return total_price;
		}
		public void setTotal_price(float total_price) {
			this.total_price = total_price;
		}
		public String getBook_name() {
			return book_name;
		}
		public void setBook_name(String book_name) {
			this.book_name = book_name;
		}
		public String getPublisher() {
			return publisher;
		}
		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
}
