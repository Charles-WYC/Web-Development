package action;


import com.opensymphony.xwork2.ActionContext;

import dao.BookDao;
import entity.Book;
import entity.User;
import service.BookService;
import service.CartService;

public class AddBookIntoCartAction extends BaseAction{
	private CartService cartService;
	private int bookID;
	private int number;
	private BookService bookService;
	
	public String execute(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		Book book=bookService.getBookByID(bookID);
		cartService.addBookIntoCart(user, book, number);
		System.out.println(1);
		return SUCCESS;
	}

	public CartService getCartService() {
		return cartService;
	}
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
}
