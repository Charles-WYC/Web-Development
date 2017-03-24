package service;

import entity.Book;
import entity.BookDetail;

import java.util.List;

public interface BookService {
	public List<Book> findAllBook();
	public Book getBookByID(int bookID);
	public List<Book> findBookOnCondition(Book book);
	public void addBook(Book book, BookDetail bookDetail);
	public void updateBook(Book book);
	public void deleteBookByID(int bookID);
}