package es.upm.dit.isst.user.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.appengine.api.images.Image;
import com.google.appengine.api.users.User;

import es.upm.dit.isst.books.dao.BookDAO;
import es.upm.dit.isst.books.dao.EMFService;
import es.upm.dit.isst.books.model.Book;
import es.upm.dit.isst.resena.model.Resena;
import es.upm.dit.isst.user.model.AppUser;


public class UserDAOImpl implements UserDAO {

	private static UserDAOImpl instance;

	private UserDAOImpl() {
	}

	public static UserDAOImpl getInstance() {
		if (instance == null)
			instance = new UserDAOImpl();
		return instance;
	}

	
	@Override
	public void add(String id, String email, int type, String name) {
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			AppUser offer = new AppUser(id, email, type, name);
			em.persist(offer);
			em.close();
		}
		
	}

	@Override
	public void update(String id, int priority, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AppUser getUser(String id) {
		// TODO Auto-generated method stub
		EntityManager em = EMFService.get().createEntityManager();
		AppUser user = em.find(AppUser.class, id);
		return user;
	}

	@Override
	public void remove(String id) {
		EntityManager em = EMFService.get().createEntityManager();
		try {
			AppUser user = em.find(AppUser.class, id);
			em.remove(user);
		} finally {
			em.close();
		}
	}
	@Override
	public void removeAll() {
		EntityManager em = EMFService.get().createEntityManager();
		em.createQuery("DELETE FROM " + AppUser.class.getName() + " m").executeUpdate(); 	    
	    em.close();
	}

	@Override
	public List<AppUser> listUsers() {
		// TODO Auto-generated method stub
		EntityManager em = EMFService.get().createEntityManager();
		// read the existing entries
		Query q = em.createQuery("select m from AppUser m");
		List<AppUser> users = q.getResultList();
		return users;
	}
	

}
