package es.upm.dit.isst.user.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.users.User;

@Entity
public class AppUser implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String email;
	private int type;
	private String name;

	
	public AppUser(String id, String email, int type, String name) {
		this.id = id;
		this.email = email;
		this.type = type;
		this.name = name;
	}
	
	public String  getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void  setEmail (String email) {
		this.email = email;
	}
	
	public int getType() {
		return type;
	}

	public void  setType (int type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}

	public void  setName (String name) {
		this.name = name;
	}

} 