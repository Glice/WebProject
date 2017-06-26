package br.com.ufrn.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.ufrn.dominio.ItemCardapio;

public class ItemCardapioDAO extends GenericDAO {

	public List<ItemCardapio> findAll () throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("Select o from ItemCardapio as o");
		
		return q.getResultList();
	}
}
