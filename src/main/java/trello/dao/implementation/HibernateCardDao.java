package trello.dao.implementation;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import trello.dao.CardDao;
import trello.model.Card;
import trello.utils.ConnectionUtil;

public class HibernateCardDao implements CardDao {
	
	
	
	
	@Override
	public Set<Card> getCards(Long listId){
		Set<Card> cards=null;
		EntityManager em=ConnectionUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			TypedQuery<Card> query= em.createQuery(" from CARD  where id_list=:id", Card.class);
			query.setParameter("id",  listId);
			
		 cards= new HashSet<Card>(query.getResultList());
			
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
		
		return cards;
	}
	
	
@Override
	public void saveCard(Card card) {
		EntityManager em=ConnectionUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(card);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

@Override
	public void deleteCard(Long cardId) {
		EntityManager em = ConnectionUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Card card = (Card) em.find(Card.class, cardId);
			em.remove(card);
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
	public void updateCard(Card card) {
		EntityManager em = ConnectionUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(card);
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


