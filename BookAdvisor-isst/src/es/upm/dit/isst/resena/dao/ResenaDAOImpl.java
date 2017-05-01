package es.upm.dit.isst.resena.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.appengine.api.images.Image;
import com.google.appengine.api.users.User;

import es.upm.dit.isst.books.dao.EMFService;
import es.upm.dit.isst.books.model.Book;
import es.upm.dit.isst.resena.model.Resena;


public class ResenaDAOImpl implements ResenaDAO {

	private static ResenaDAOImpl instance;

	private ResenaDAOImpl() {
	}

	public static ResenaDAOImpl getInstance() {
		if (instance == null)
			instance = new ResenaDAOImpl();
		return instance;
	}

	@Override
	public List<Resena> listResenaByBook(long id) {
		EntityManager em = EMFService.get().createEntityManager();
		// read the existing entries
		Query q = em.createQuery("select t from Resena t where t.book =:id");
		q.setParameter("id", id);
		List<Resena> offers = q.getResultList();
		return offers;
	}

	@Override
	public void add(String title, String description, double nota, long book, User autor) {
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			Resena offer = new Resena(title, description, nota, book, autor);
			em.persist(offer);
			em.close();
		}

	}

	@Override
	public void remove(long id) {
		EntityManager em = EMFService.get().createEntityManager();
		try {
			Resena offer = em.find(Resena.class, id);
			em.remove(offer);
		} finally {
			em.close();
		}
	}

	
	@Override
	public void update(long id, String title, String description, double nota) {
		EntityManager em = EMFService.get().createEntityManager();
		try {
			Resena offer = em.find(Resena.class, id);
			offer.setTitle(title);
			offer.setDescription(description);
			offer.setNota(nota);
			em.merge(offer);
		} finally {
			em.close();
		}
	}

	

}
