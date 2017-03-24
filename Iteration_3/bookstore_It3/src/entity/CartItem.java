package entity;

public class CartItem {
	int cartItemID;
	Book book;
	int number;
	float total_price;
	Cart cart;
	
	public int getCartItemID() {
		return cartItemID;
	}

	public void setCartItemID(int cartItemID) {
		this.cartItemID = cartItemID;
	}
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public CartItem(){
		
	}
	
	public CartItem(Cart cart, Book book, int number, float total_price){
		this.cart=cart;
		this.book = book;
		this.number = number;
		this.total_price = total_price;
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
	
	
}
