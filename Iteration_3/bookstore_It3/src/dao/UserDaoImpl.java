package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.User;
import support.HibernateUtils;

public class UserDaoImpl implements UserDao{
	

	public User FindUserByName(String username){
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
	
		String hql = "from User where username = ?";
		Query query = session.createQuery(hql);
		query.setString(0, username);
		
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		
		trans.commit();
		session.close();
		
		if(list.size() == 0)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	public void updateUser(User user){
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		
		session.update(user);
		
		trans.commit();
		session.close();
		
		return;
	}
	public User addUser(User user){

		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		
		int id =(int) session.save(user);
		user.setUserID(id);
		
		trans.commit();
		session.close();
		
		return user;
	}
	public List<User> findAllCustomer(){
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
	
		String hql = "from User where identity = ?";
		Query query = session.createQuery(hql);
		query.setString(0, "customer");
		List<User> users = query.list();
		
		trans.commit();
		session.close();
		
		return users;
	}
	public void deleteUserByID(int userID){
		
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		
		User user = (User) session.get(User.class, userID);
		session.delete(user);
		
		trans.commit();
		session.close();
		
		return;
	}
}
