package action;


import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import entity.Book;
import entity.User;
import service.BookService;

public class ShowBookAction extends BaseAction{
	
	private BookService bookService;
	
	public String execute(){
		List<Book> books = bookService.findAllBook();
		ServletActionContext.getRequest().setAttribute("books", books);
		User user = (User) ActionContext.getContext().getSession().get("user");

		if(user.getIdentity().equals("admin")){
			return ADMINSUCCESS;
		}
		else
		{
			return CUSTOMERSUCCESS;
		}
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
}
