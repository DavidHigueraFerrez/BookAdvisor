package es.upm.dit.isst.books.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.users.User;

@Entity
public class Book implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private User editorial;
	private String portada;
	private String service;
	private String autor;
	private String fecha;
	private String isbn;
	private String categoria;
	private boolean promoted;
	private boolean available;
	private String urlparam;
	private String price;
	private String ubicacion;
	
	public Book(String title, String description, User editorial, String autor, String fecha, String portada, String categoria, String isbn, boolean promoted, boolean available, String url, String price, String ubicacion) {
		this.title = title;
		this.autor = autor;
		this.editorial = editorial;
		this.fecha = fecha;
		this.isbn = isbn;
		this.portada = portada;
		this.categoria = categoria;
		this.description = description;
		this.promoted = promoted;
		this.available = available;
		this.ubicacion = ubicacion;
		this.urlparam = url;
		this.price = price;
	}
	
	public String getUbicacion() {
		return ubicacion;
	}

	public void seUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public String getPrice() {
		return price;
	}

	public void sePrice(String price) {
		this.price = price;
	}
	
	public String getUrl() {
		return urlparam;
	}

	public void setUrl(String url) {
		this.urlparam = url;
	}
	
	public boolean getAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean getPromoted() {
		return promoted;
	}

	public void setPromoted(boolean promoted) {
		this.promoted = promoted;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getPortada() {
		return portada;
	}

	public void setPortada(String portada) {
		this.portada = portada;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public User getEditorial() {
		return editorial;
	}

	public void setEditorial(User editorial) {
		this.editorial = editorial;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}


} 