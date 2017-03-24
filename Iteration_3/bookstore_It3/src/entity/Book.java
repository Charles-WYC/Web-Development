package entity;

import java.util.List;
import java.util.Set;

public class Book {
	
	private int bookID;
	private float price;
	private int quantity;
	private String book_name;
	private int sales_volume;
	private String category;
	private BookDetail bookDetail;
	private Set<CartItem> cartItems;
	private Set<OrderItem> orderItems;
	public Book(){
		
	}
	public Book(int bookID, float price, int quantity, String book_name, int sales_volume, String category)
	{
		this.bookID = bookID;
		this.price = price;
		this.quantity = quantity;
		this.book_name = book_name;
		this.sales_volume = sales_volume;
		this.category = category;
	}
	
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
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
	public BookDetail getBookDetail() {
		return bookDetail;
	}
	public void setBookDetail(BookDetail bookDetail) {
		this.bookDetail = bookDetail;
	}
	public Set<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
