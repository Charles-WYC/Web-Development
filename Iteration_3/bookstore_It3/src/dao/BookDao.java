package dao;

import java.util.List;

import entity.Book;

public interface BookDao {
	public List<Book> findAllBook();
	public Book getBookByID(int bookID);
	public void updateBook(Book book);
	public List<Book> findBookOnCondition(Book book);
	public Book addBook(Book book);
	public void deleteBookByID(int bookID);
}
