package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.UserDetail;
import support.HibernateUtils;

public class UserDetailDaoImpl implements UserDetailDao{

	public void updateUserDetail(UserDetail userDetail){

		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		
		session.update(userDetail);
		
		trans.commit();
		session.close();
		
		return;
	}
	public void addUserDetail(UserDetail userDetail){

		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		
		session.save(userDetail);
		
		trans.commit();
		session.close();
		
		return;
	}
}
