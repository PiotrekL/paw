package trello.dao.implementation;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import trello.dao.ColorsDao;
import trello.model.Card;
import trello.model.Color;
import trello.utils.ConnectionUtil;

public class HibernateColorsDao implements ColorsDao {

	@Override
	public Set<Color> getColors() {
		
		Set<Color> colors=null;
		EntityManager em=ConnectionUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			TypedQuery<Color> query= em.createQuery(" from Colors" , Color.class);
			
		 colors= new HashSet<Color>(query.getResultList());
			
		} 
		
		catch (PersistenceException e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		return colors;
		

	}

}
