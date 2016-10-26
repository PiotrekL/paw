package trello.utils;

import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionUtil {
	private static final EntityManagerFactory entityManagerFactory;

	static {
		EntityManagerFactory tempEMF;
		try {
			tempEMF = Persistence.createEntityManagerFactory("manager");

		} catch (Throwable ex) {

			new ExceptionInInitializerError(ex);
			System.out.println(ex);
			tempEMF = null;
			System.exit(0);
		}
		entityManagerFactory = tempEMF;

	}

	public static EntityManagerFactory getEntityManagerFactory() {

		return entityManagerFactory;
	}
}
