package es.upm.dit.isst.resena.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.google.appengine.api.users.User;

@Entity
public class Resena implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private double nota;
	private long book;
	private User autor;
	
	public Resena(String title, String description, double nota, long book, User autor){
		this.title = title;
		this.description = description;
		this.nota = nota;
		this.book = book;
		this.autor = autor;
	}
	
	public User getAutor() {
		return autor;
	}

	public void setAutor(User autor) {
		this.autor = autor;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	public long getBook() {
		return book;
	}

	public void setBook(long book) {
		this.book = book;
	}

}
