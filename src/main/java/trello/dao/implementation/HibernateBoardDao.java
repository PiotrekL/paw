package trello.dao.implementation;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;


import trello.dao.BoardDao;
import trello.model.Board;
import trello.utils.ConnectionUtil;
public class HibernateBoardDao implements BoardDao{

	
	@Override
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
	
	@Override
	public Set<Board> getBoardsByUser(Long userId){
		Set<Board> boards=null;
		EntityManager em=ConnectionUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			TypedQuery<Board> query= em.createQuery(" from Board  where id_user=:id", Board.class);
			query.setParameter("id",  userId);
			
		 boards= new HashSet<Board>(query.getResultList());
			
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
		
		return boards;
	}
	
	

	@Override
	public Board getBoard(Long id){
		Board board=null;
		EntityManager em=ConnectionUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			TypedQuery<Board> query= em.createQuery(" from Board  where id=:id", Board.class);
			query.setParameter("id",  id);
			
		 board= query.getSingleResult();
			
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
	
	
	
	
	
	public void deleteBoard(Long boardId)  {
		EntityManager em = ConnectionUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Board board = (Board) em.find(Board.class, boardId);
			em.remove(board);
			em.getTransaction().commit();

		}

		catch (NullPointerException e) {
			em.getTransaction().rollback();
			
		} catch (PersistenceException e) {
			
			
		} finally {

			em.close();
		}
	}
	
	@Override
	public void updateBoard(Board board)  {
		EntityManager em = ConnectionUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(board);
			em.getTransaction().commit();

		}

		catch (NullPointerException e) {
			em.getTransaction().rollback();
			
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			
		} finally {

			em.close();
		}
	}
}
