package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.BookDetail;
import support.HibernateUtils;

public class BookDetailDaoImpl implements BookDetailDao{

	public void addBookDetail(BookDetail bookDetail){

		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		
		session.save(bookDetail);
		
		trans.commit();
		session.close();
		
		return;
	}
	public void updateBookDetail(BookDetail bookDetail){

		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		
		session.update(bookDetail);
		
		trans.commit();
		session.close();
		
		return;
		
	}
}
