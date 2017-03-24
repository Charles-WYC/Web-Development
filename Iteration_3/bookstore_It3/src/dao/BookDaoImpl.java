package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Book;
import support.HibernateUtils;

public class BookDaoImpl implements BookDao{
	
	public List<Book> findAllBook(){
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		
		String hql = "from Book";
		Query query = session.createQuery(hql);
		List<Book> books = query.list();

		trans.commit();
		session.close();
		
		return books;
	}
	public Book addBook(Book book){

		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		
		int id = (int) session.save(book);
		book.setBookID(id);
		
		trans.commit();
		session.close();
		System.out.println(1);
		return book;
	}
	
	public Book getBookByID(int bookID){
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		
		Book book=(Book) session.get(Book.class, bookID);

		trans.commit();
		session.close();
		
		return book;
	}
	public void deleteBookByID(int bookID){

		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		
		Book book=(Book) session.get(Book.class, bookID);
		session.delete(book);
		
		trans.commit();
		session.close();
		
		return;
	}
	public void updateBook(Book book){

		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		
		session.update(book);

		trans.commit();
		session.close();
		
		return;
	}
	public List<Book> findBookOnCondition(Book book){

		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		
		String hql = "from Book where 1 = 1 ";
		if(book.getBookID() != 0){
			hql = hql +"and bookID = ?";
		}
		if(!book.getBook_name().equals("")){
			hql = hql +"and book_name = ?";
		}
		if(book.getPrice() != 0){
			hql = hql +"and price = ?";
		}
		if(!book.getCategory().equals("")){
			hql = hql +"and category = ?";
		}
		Query query = session.createQuery(hql);
		System.out.println(hql);
		int i =0;
		if(book.getBookID() != 0){
			query.setInteger(i, book.getBookID());
			i++;
		}
		if(!book.getBook_name().equals("")){
			query.setString(i, book.getBook_name());
			i++;
		}
		if(book.getPrice() != 0){
			query.setFloat(i, book.getPrice());
			i++;
		}
		if(!book.getCategory().equals("")){
			query.setString(i, book.getCategory());
		}
		
		List<Book> books = query.list();

		trans.commit();
		session.close();
		
		return books;
	}

}
