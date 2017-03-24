package action;

import service.BookService;

public class AdminDeleteBookAction extends BaseAction{
	private int bookID;
	private BookService bookService;
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
	
	public String execute(){
		bookService.deleteBookByID(bookID);
		return SUCCESS;
	}
}
