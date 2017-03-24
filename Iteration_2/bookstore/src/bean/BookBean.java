package bean;

public class BookBean extends Base{

   // 描述图书的属性
   private int bookID;
   private float price;
   private int quantity;
   private String book_name;
   private String author;
   private String publisher;
   private int sales_volume;
   private String category;
   
   public BookBean(int bookID, float price, int quantity, String book_name, String author, String publisher, int sales_volume, String category)
   {
	   this.bookID = bookID;
	   this.price = price;
	   this.quantity = quantity;
	   this.book_name = book_name;
	   this.author = author;
	   this.publisher = publisher;
	   this.sales_volume = sales_volume;
	   this.category = category;
   }
   public BookBean(float price, int quantity, String book_name, String author, String publisher, int sales_volume, String category)
   {
	   this.price = price;
	   this.quantity = quantity;
	   this.book_name = book_name;
	   this.author = author;
	   this.publisher = publisher;
	   this.sales_volume = sales_volume;
	   this.category = category;
	   
   }
   public BookBean()
   {
	   
   }
   public BookBean(int bookID)
   {
	   this.bookID = bookID;
   }
   public void setQuantity(int quantity)
   {
	   this.quantity = quantity;
   }
   
   public int getQuantity()
   {
	   return quantity;
   }
   // 编写对乘员进行操作的方法
   public void setBookID(int bookID){
      this.bookID = bookID;
   }

   public int getBookID(){
      return bookID;
   }

   public void setBook_name(String book_name){
      this.book_name = book_name;
   }

   public String getBook_name(){
      return book_name;
   }

   public void setAuthor(String author){
      this.author = author;
   }

   public String getAuthor(){
      return author;
   }

   public void setPrice(float price){
      this.price = price;
   }
   
   public float getPrice(){
      return price;
   }

   public void setPublisher(String publisher){
      this.publisher = publisher;
   }

   public String getPublisher(){
      return publisher;
   }
   public void addBook()
   {
	   String sql = "insert into book value(NULL, ?, ?, ?, ?, ?)";
	      try{
	         createStatement(sql);
	         stmt.setString(3, book_name);
	         stmt.setInt(2, quantity);
	         stmt.setFloat(1, price);
	         stmt.setInt(4, sales_volume);
	         stmt.setString(5, category);
	         executeUpdate();

	         sql = "select max(bookID) from book";
	         createStatement(sql);
	         rs = executeQuery();
	         rs.next();
	         bookID = rs.getInt(1);
	         
	         sql = "insert into book_detail value(?,?,?)";
	         createStatement(sql);
	         stmt.setInt(1,bookID);
	         stmt.setString(2, author);
	         stmt.setString(3, publisher);
	         executeUpdate();
	         
	      }catch(Exception e){
	         System.out.println(e.toString());
	      }
	   
   }
   public void updateBook()
   {
	   String sql = "update book set book_name = ?, quantity = ?, price = ?, sales_volume=?, category = ? where bookID = ?";
	      try{
	         createStatement(sql);
	         stmt.setString(1, book_name);
	         stmt.setInt(2, quantity);
	         stmt.setFloat(3, price);
	         stmt.setInt(4, sales_volume);
	         stmt.setString(5, category);
	         stmt.setInt(6,bookID);
	         executeUpdate();

	         sql = "update book_detail set author = ?, publisher = ? where bookID = ?";
	         createStatement(sql);
	         stmt.setString(1, author);
	         stmt.setString(2, publisher);
	         stmt.setInt(3,bookID);
	         executeUpdate();
	         
	      }catch(Exception e){
	         System.out.println(e.toString());
	      }
	   
   }
   public void deleteBook()
   {
	   String sql = "select * from book where bookID = ?";
	   
	      try{
	    	 createStatement(sql);
	    	 stmt.setInt(1, bookID);
	    	 rs = executeQuery();
	    	 rs.next();
	    	 price = rs.getFloat("price");
	    	 sql = "select * form shipment where bookID = ?";
	    	 createStatement(sql);
	    	 stmt.setInt(1, bookID);
	    	 rs = executeQuery();
	    	 while(rs.next())
	    	 {
	    		 int indentID = rs.getInt("indentID");
	    		 int number = rs.getInt("number");
	    		 sql = "Update indent set amount = amount - ? where indentID = ?";
	    		 createStatement(sql);
	    		 stmt.setFloat(1, number*price);
	    		 stmt.setInt(2, indentID);
	    		 executeUpdate();
	    	 }
	   	   	 sql = "delete form book where bookID = ?";
	         createStatement(sql);
	         stmt.setInt(1,bookID);
	         int n =executeUpdate();
	      }catch(Exception e){
	         System.out.println(e.toString());
	      }
	   
   }
   public void getBookByID(int bookID)
   {
	   String sql = "select * from book natural join book_detail where bookID = ?";
	      try{
	         createStatement(sql);
	         stmt.setInt(1,bookID);
	         rs = executeQuery();
	         // 使用while循环遍历结果集
	         if(rs.next())
	         {
	            // 使用rs的getString方法，以字符串的形式获取第一列，参数也可以是列的名字
	            // 可以得到当前记录的每一列
	            this.bookID = rs.getInt("bookID");
	            book_name = rs.getString("book_name");
	            author = rs.getString("author");
	            price = rs.getFloat("price");
	            publisher = rs.getString("publisher");
	            quantity = rs.getInt("quantity");
	            sales_volume = rs.getInt("sales_volume");
	            category = rs.getString("category");
	         }
	      }catch(Exception e){
	         System.out.println(e.toString());
	      }
   }
public int getSales_volume() {
	return sales_volume;
}
public void setSales_volume(int sales_volume) {
	this.sales_volume = sales_volume;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}

}