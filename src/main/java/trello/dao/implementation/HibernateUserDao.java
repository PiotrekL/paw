package trello.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import trello.dao.UserDao;
import trello.model.Board;
import trello.model.User;
import trello.utils.ConnectionUtil;
import trello.utils.SecureUtil;

public class HibernateUserDao implements UserDao {

	public long saveUser(User user) {
		EntityManager em = ConnectionUtil.getEntityManagerFactory().createEntityManager();

		try {
			user.setPassword(SecureUtil.getHash(user.getPassword()));
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return user.getId();
	}

	public User getUser(String login) {
		EntityManager em = ConnectionUtil.getEntityManagerFactory().createEntityManager();
		User user = null;

		try {
			em.getTransaction().begin();
			TypedQuery<User> query = em.createQuery(" from trello_user  where login=:login", User.class);
			query.setParameter("login", login);
			user = query.getSingleResult();
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

		return user;

	}

	public String checkUser(String login) {
		EntityManager em = ConnectionUtil.getEntityManagerFactory().createEntityManager();
		String pass = null;

		try {
			em.getTransaction().begin();
			TypedQuery<String> query = em.createQuery("SELECT password from trello_user  where login=:login",
					String.class);
			query.setParameter("login", login);
			pass = query.getSingleResult();
			em.getTransaction().commit();
		} catch (NoResultException nre) {

			return null;
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

		return pass;

	}

}
