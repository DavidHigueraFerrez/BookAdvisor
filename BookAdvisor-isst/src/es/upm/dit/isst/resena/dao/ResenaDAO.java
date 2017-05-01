package es.upm.dit.isst.resena.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.appengine.api.images.Image;
import com.google.appengine.api.users.User;

import es.upm.dit.isst.books.model.Book;
import es.upm.dit.isst.resena.model.Resena;

public interface ResenaDAO {

	public void remove(long id);

	List<Resena> listResenaByBook(long idbook);
	
	public void add (String title, String description, double nota, long book, User autor);

	public void update(long id, String title, String description, double nota);

	
}