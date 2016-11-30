package trello.dao.implementation;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import trello.dao.LabelDao;
import trello.model.Label;
import trello.model.List;
import trello.utils.ConnectionUtil;

public class HibernateLabelDao implements LabelDao {

	@Override
	public Set<Label> getLabel(Long boardId) {
		Set<Label> labels = null;
		EntityManager em = ConnectionUtil.getEntityManagerFactory().createEntityManager();

		try {
			em.getTransaction().begin();

			TypedQuery<Label> query = em.createQuery(" from Label  where id_board=:id", Label.class);
			query.setParameter("id", boardId);

			labels = new HashSet<Label>(query.getResultList());

		}

		catch (PersistenceException e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

		return labels;
	}

	@Override
	public long saveLabel(Label label) {
		EntityManager em = ConnectionUtil.getEntityManagerFactory().createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(label);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return label.getId();
	}

	@Override
	public void deleteLabel(Long labelId) {
		EntityManager em = ConnectionUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Label label = (Label) em.find(Label.class, labelId);
			em.remove(label);
			em.getTransaction().commit();

		}

		catch (PersistenceException e) {
			em.getTransaction().rollback();

		} finally {

			em.close();
		}

	}

}
