package es.upm.dit.isst.books.dao;

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


public class BookDAOImpl implements BookDAO {

	private static BookDAOImpl instance;

	private BookDAOImpl() {
	}

	public static BookDAOImpl getInstance() {
		if (instance == null)
			instance = new BookDAOImpl();
		return instance;
	}

	@Override
	public List<Book> listOffersByUser(User user) {
		EntityManager em = EMFService.get().createEntityManager();
		// read the existing entries
		Query q = em.createQuery("select t from Book t where t.editorial =:user");
		q.setParameter("user", user);
		List<Book> offers = q.getResultList();
		return offers;
	}

	@Override
	public void add(String title, String description, User editorial, String autor, String fecha, String portada, String categoria, String isbn, boolean promoted,  boolean available, String url, String price, String ubicacion) {
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			Book offer = new Book(title, description, editorial, autor, fecha, portada, categoria, isbn, promoted, available,  url,  price,  ubicacion);
			em.persist(offer);
			em.close();
		}

	}

	@Override
	public void remove(long id) {
		EntityManager em = EMFService.get().createEntityManager();
		try {
			Book offer = em.find(Book.class, id);
			em.remove(offer);
		} finally {
			em.close();
		}
	}

	

	@Override
	public Book getBook(long offerId) {
		EntityManager em = EMFService.get().createEntityManager();
		try {
			Book offer = em.find(Book.class, offerId);
			return offer;
		} finally {
			em.close();
		}
	}

	@Override
	public void update(long offerId, String title, String description, User user, int price, String service) {
		EntityManager em = EMFService.get().createEntityManager();
		try {
			Book offer = em.find(Book.class, offerId);
			offer.setTitle(title);
			offer.setDescription(description);
			offer.setService(service);
			em.merge(offer);
		} finally {
			em.close();
		}
	}

	@Override
	public List<Book> listAllBooks() {
		EntityManager em = EMFService.get().createEntityManager();
		// read the existing entries
		Query q = em.createQuery("select t from Book t");
		List<Book> offers = q.getResultList();
		return offers;
	}
	

}
