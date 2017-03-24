package action;

import org.apache.struts2.ServletActionContext;


import entity.Book;
import netscape.javascript.JSObject;
import service.BookService;

public class CustomerShowBookDetailAction{
	private BookService bookService;
	private int bookID;
	public void execute(){
		Book book = bookService.getBookByID(bookID);
		String jsonText ="{\"publisher\":\""+book.getBookDetail().getPublisher()+"\",\"sales_volume\":\""
				+book.getSales_volume()+"\",\"quantity\":\""+book.getQuantity()+"\",\"bookID\":\""+book.getBookID()+"\"}";
		System.out.println(jsonText);
		try{
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write(jsonText);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
}
