package entity;

public class BookDetail {
	private int bookID;
	private Book book;
	private String author;
	private String publisher;
	
	public BookDetail(){
		
	}
	public BookDetail(String author, String publisher){
		this.author = author;
		this.publisher = publisher;
	}
	public BookDetail(Book book, String author, String publisher){
		this.author = author;
		this.publisher = publisher;
		this.book = book;
		this.bookID = book.getBookID();
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	
	
	
}
