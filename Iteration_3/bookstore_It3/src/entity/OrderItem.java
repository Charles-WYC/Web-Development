package entity;

public class OrderItem {
	int orderItemID;
	int number;
	float total_price;
	Book book;
	Order order;
	
	public OrderItem(){
		
	}
	public OrderItem(int number, Order order, Book book, float total_price){
		this.number = number;
		this.order = order;
		this.book = book;
		this.total_price = total_price;
	}
	
	public int getOrderItemID() {
		return orderItemID;
	}
	public void setOrderItemID(int orderItemID) {
		this.orderItemID = orderItemID;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public float getTotal_price() {
		return total_price;
	}
	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
}
