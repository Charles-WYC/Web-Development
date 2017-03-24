package action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import entity.Book;
import entity.User;
import service.BookService;

public class FindBookOnConditionAction extends BaseAction{
	private int bookID = 0;
	private float price = 0;
	private String category;
	private String book_name;
	private String author;
	private BookService bookService;
	
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String execute(){
		System.out.println(book_name);
		Book book = new Book();
		book.setBook_name(book_name);
		book.setBookID(bookID);
		book.setCategory(category);
		book.setPrice(price);
		
		List<Book> books = bookService.findBookOnCondition(book);
		
		System.out.println(books.size());
		if(!author.equals("")){
			System.out.println(2);
			List<Book> midBooks = new ArrayList();
			for(Book tempBook : books){
				if(tempBook.getBookDetail().getAuthor().equals(author)){
					midBooks.add(tempBook);
				}
			}
			books = midBooks;
			
		}
		User user = (User) ActionContext.getContext().getSession().get("user");
		ServletActionContext.getRequest().setAttribute("preBook_name", book_name);
		ServletActionContext.getRequest().setAttribute("preAuthor", author);
		ServletActionContext.getRequest().setAttribute("preCategory", category);
		ServletActionContext.getRequest().setAttribute("books", books);
		if(user.getIdentity().equals("admin")){
			return ADMINSUCCESS;
		}
		else
		{
			return CUSTOMERSUCCESS;
		}
	}
}
