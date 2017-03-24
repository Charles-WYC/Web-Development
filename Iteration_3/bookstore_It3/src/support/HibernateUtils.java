package support;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private HibernateUtils(){
		
	}
	
	private static SessionFactory sessionFactory;
	
	public static Session getSession(){
		return getSessionFactory().openSession();
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
