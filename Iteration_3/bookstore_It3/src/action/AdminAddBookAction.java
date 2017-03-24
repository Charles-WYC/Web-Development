package action;

import com.opensymphony.xwork2.ModelDriven;

import entity.Book;
import entity.BookDetail;
import entity.User;
import service.BookService;

public class AdminAddBookAction extends BaseAction implements ModelDriven<Book>{
	private Book book;
	private String author;
	private String publisher;
	private BookService bookService;
	
	public Book getModel(){
		return this.book;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
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

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	public String execute(){
		BookDetail bookDetail = new BookDetail(author, publisher);
		bookService.addBook(book, bookDetail);
		return SUCCESS;
	}
}
