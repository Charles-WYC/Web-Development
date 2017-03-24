package bean;

public class IndentItem extends Base{
	private int indentID;
	private int bookID;
	private int number;
	private float price;
	private float total_price;
	private String book_name;
	private String publisher;
	private String author;
	
	public IndentItem(int indentID, int bookID, int number, float price, float total_price, String book_name, String publisher, String author)
	{
		this.indentID = indentID;
		this.bookID = bookID;
		this.number = number;
		this.price = price;
		this.total_price = total_price;
		this.book_name = book_name;
		this.publisher = publisher;
		this.author = author;
	}
	   public IndentItem(int indentID, int bookID, int number)
	   {
		   this.bookID = bookID;
		   this.indentID = indentID;
		   this.number = number;
	   }
	   public IndentItem()
	   {
		   
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

		public void setIndnetID(int userID)
		{
			this.indentID = userID;
		}
		public int getIndentID()
		{
			return indentID;
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