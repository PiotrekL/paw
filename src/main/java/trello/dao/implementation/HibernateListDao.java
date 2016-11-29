package trello.dao.implementation;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import trello.dao.ListDao;
import trello.model.Board;
import trello.model.List;
import trello.utils.ConnectionUtil;

public class HibernateListDao implements ListDao {
	
	@Override
	public Set<List> getLists(Long boardId){
	
			Set<List> lists=null;
			EntityManager em=ConnectionUtil.getEntityManagerFactory().createEntityManager();
			
			try {
				em.getTransaction().begin();
				
				TypedQuery<List> query= em.createQuery(" from List  where id_board=:id", List.class);
				query.setParameter("id",  boardId);
				
			 lists= new HashSet<List>(query.getResultList());
				
			} 
			

			catch (PersistenceException e) {
				em.getTransaction().rollback();
				e.printStackTrace();
			} finally {
				em.close();
			}
			
	return lists;
	}

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


@Override
	public void deleteList(Long listId) {
		EntityManager em = ConnectionUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			List list = (List) em.find(List.class, listId);
			em.remove(list);
			em.getTransaction().commit();

		}

 catch (PersistenceException e) {
			em.getTransaction().rollback();
			
		} finally {

			em.close();
		}
	}
@Override
	public void updateList(List list) {
		EntityManager em = ConnectionUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(list);
			em.getTransaction().commit();

		}

	 catch (PersistenceException e) {
			em.getTransaction().rollback();
			
		} finally {

			em.close();
		}
	}
	}


