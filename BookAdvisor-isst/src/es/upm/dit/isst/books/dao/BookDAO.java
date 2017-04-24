package es.upm.dit.isst.books.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.appengine.api.images.Image;
import com.google.appengine.api.users.User;

import es.upm.dit.isst.books.model.Book;
import es.upm.dit.isst.books.model.Resena;

public interface BookDAO {

	public void remove(long id);

	List<Book> listOffersByUser(User user);
	
	List<Book> listAllBooks();

	public void add (String title, String description, User editorial, String autor, String fecha, String portada, String categoria, String isbn);

	public void update(long id, String title, String description, User user, int price, String service);

	Book getBook(long offerId);
	
}