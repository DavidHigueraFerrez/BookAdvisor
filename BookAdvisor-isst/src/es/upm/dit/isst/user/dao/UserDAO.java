package es.upm.dit.isst.user.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.appengine.api.images.Image;
import com.google.appengine.api.users.User;

import es.upm.dit.isst.books.model.Book;
import es.upm.dit.isst.resena.model.Resena;
import es.upm.dit.isst.user.model.AppUser;

public interface UserDAO {

	public List<AppUser> listUsers();
	
	public void remove(String id);
	//Type = 1 common
	//Type = 2 biblioteca
	//Type = 3 libreria
	//Type = 4 editorial
	public void add (String id, String email, int type, String name);
	
	public void update (String id, int priority, String name);
	
	public AppUser getUser(String id);
		
	public void removeAll ();
	
}