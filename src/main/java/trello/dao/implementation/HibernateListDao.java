package trello.dao.implementation;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import trello.dao.ListDao;
import trello.model.List;
import trello.utils.ConnectionUtil;

public class HibernateListDao implements ListDao {

	public void saveList(List list) {
		EntityManager em=ConnectionUtil.getEntityManagerFactory().createEntityManager();
	
		try {
			em.getTransaction().begin();
			em.persist(list);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

	}



	public void deleteList(Long listId) {
		// TODO Auto-generated method stub

	}

	public void updateList(List list) {
		// TODO Auto-generated method stub

	}

}
