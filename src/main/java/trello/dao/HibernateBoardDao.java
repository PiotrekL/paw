package trello.dao;

import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;


import trello.model.Board;
import trello.model.List;
import trello.utils.ConnectionUtil;
public class HibernateBoardDao {

	
	
	public void saveBoard(Board board)
	{
		EntityManager em=ConnectionUtil.getEntityManagerFactory().createEntityManager();
		

		try {
			em.getTransaction().begin();
			em.persist(board);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	
	}
	
	
	public Board getBoard(Long id)
	{Board board=null;
		EntityManager em=ConnectionUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			TypedQuery<Board> query= em.createQuery(" from Board  where id=:id", Board.class);
			query.setParameter("id",  id);
			
		 board= query.getSingleResult();
		 
		 TypedQuery<List> query1= em.createQuery(" from List  where id_listy=:id", List.class);
			query1.setParameter("id",  id);
		 
		HashSet<List> ss= new HashSet<List>( query1.getResultList());
		board.setLists(ss);
			
		} 
		
		catch(NoResultException e){
			return null;
			
			
		}
		catch (PersistenceException e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		return board;
	}
}
