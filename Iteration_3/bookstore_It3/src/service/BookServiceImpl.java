package service;

import java.util.List;

import dao.BookDao;
import dao.BookDetailDao;
import entity.Book;
import entity.BookDetail;

public class BookServiceImpl implements BookService{
	private BookDao bookDao;
	private BookDetailDao bookDetailDao;
	
	public List<Book> findAllBook(){
		return bookDao.findAllBook();
	}
	public Book getBookByID(int bookID){
		return bookDao.getBookByID(bookID);
	}

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	public List<Book> findBookOnCondition(Book book){
		return bookDao.findBookOnCondition(book);
	}
	public void addBook(Book book, BookDetail bookDetail){
		book = bookDao.addBook(book);
		System.out.println(1);
		book.setBookDetail(bookDetail);
		System.out.println(1);
		bookDetail.setBook(book);
		System.out.println(1);
		bookDetail.setBookID(book.getBookID());
		System.out.println(1);
		bookDetailDao.addBookDetail(bookDetail);
		System.out.println(1);
		return;
	}
	public BookDetailDao getBookDetailDao() {
		return bookDetailDao;
	}
	public void setBookDetailDao(BookDetailDao bookDetailDao) {
		this.bookDetailDao = bookDetailDao;
	}
	public void updateBook(Book book){
		bookDao.updateBook(book);
		bookDetailDao.updateBookDetail(book.getBookDetail());
		return;
	}
	public void deleteBookByID(int bookID){
		bookDao.deleteBookByID(bookID);
		return;
	}
}
