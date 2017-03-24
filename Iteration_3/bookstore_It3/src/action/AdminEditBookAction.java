package action;

import org.apache.struts2.ServletActionContext;

import entity.Book;
import entity.BookDetail;
import service.BookService;

public class AdminEditBookAction extends BaseAction{
	private Book book;
	private String author;
	private String publisher;
	private BookService bookService;
	
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
		BookDetail bookDetail = new BookDetail(book, author, publisher);
		book.setBookDetail(bookDetail);
		bookService.updateBook(book);
		ServletActionContext.getRequest().setAttribute("book", book);
		return SUCCESS;
	}
}
