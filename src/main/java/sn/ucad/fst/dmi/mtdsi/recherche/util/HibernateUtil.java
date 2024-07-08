package sn.ucad.fst.dmi.mtdsi.recherche.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static final ThreadLocal<Session> session = new ThreadLocal<>();
	public static Session currentSession() throws HibernateException {
		Session s = session.get();
		// Ouvre une nouvelle Session, si ce Thread n'en a aucune
		if (s == null) {
			s = sessionFactory.openSession();
			session.set(s);
		}
		return s;
	}
	public static void closeSession() throws HibernateException {
		Session s = session.get();
		session.set(null);
		if (s != null) {
			s.close();
		}
	}
}

