package action;

import org.apache.struts2.ServletActionContext;

import entity.Book;
import service.BookService;

public class AdminShowBookDetailAction extends BaseAction{
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
		Book book = bookService.getBookByID(bookID);
		ServletActionContext.getRequest().setAttribute("book", book);
		return SUCCESS;
	}
}
