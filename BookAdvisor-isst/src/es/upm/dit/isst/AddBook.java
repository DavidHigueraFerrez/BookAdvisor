package es.upm.dit.isst;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.upm.dit.isst.books.dao.BookDAO;
import es.upm.dit.isst.books.dao.BookDAOImpl;
import es.upm.dit.isst.books.model.Book;
import es.upm.dit.isst.resena.model.Resena;
import es.upm.dit.isst.user.dao.UserDAO;
import es.upm.dit.isst.user.dao.UserDAOImpl;
import es.upm.dit.isst.user.model.AppUser;

public class AddBook extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// //////////CREATE RESOURCE///////////////////////
		UserService userService = UserServiceFactory.getUserService();
		User editorial = userService.getCurrentUser();
		String title = checkNull(req.getParameter("title"));
		String Description = checkNull(req.getParameter("description"));
		String availablenum = req.getParameter("available");
		String autor = checkNull(req.getParameter("autor"));
		String portada = req.getParameter("image");
		String isbn = checkNull(req.getParameter("isbn"));
		String category = req.getParameter("category");
		String urlparam = req.getParameter("urlparam");
		String price = req.getParameter("price");
		String ubicacion = req.getParameter("direccion");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		String fecha = dateFormat.format(date);
		BookDAO dao = BookDAOImpl.getInstance();
		UserDAO daouser = UserDAOImpl.getInstance();
		AppUser usuarioon = daouser.getUser(editorial.getUserId());
		boolean promoted;
		if(usuarioon.getType() > 2){
			promoted = true;
		}			
		else {promoted = false;}
		boolean available = false;
		System.out.println(availablenum);
		if (availablenum != null){
			int available1 = Integer.parseInt(availablenum);
			if (available1 == 1){
				available = true;
			}
			if(available1 == 0) {
				available = false;
			}	
		}
		dao.add(title, Description, editorial, autor, fecha, portada, category, isbn, promoted, available, urlparam, price, "Ubicaci�n: "+ubicacion);
		System.out.println("a�adido libro con titulo y descrip:"+title+" "+Description+" y USer:"+editorial+ autor+ fecha+ portada+ category+ isbn+promoted+available+ urlparam+ price+ubicacion);
		PrintWriter out = resp.getWriter();
		req.getSession().setAttribute("dialogo", "Oferta creada Correctamente!");

		//resp.sendRedirect("/mandamail?title=" + title + "&description="
		//		+ Description + "&price=" + price + "&service=" + service);

		resp.sendRedirect("/books");
	}
	
	private String checkNull(String s) {
		if (s == null) {
			return "";
		}
		return s;
	}
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
	
		if (user == null){
			resp.sendRedirect("/"); //si no estoy logueado me devuelve al inicio
			
		} if(user != null){
			UserDAO appUserDAO = UserDAOImpl.getInstance();
		    AppUser appUser = appUserDAO.getUser(user.getUserId());
		    int type = appUser.getType();
		    //Type = 1 common
			//Type = 2 biblioteca
			//Type = 3 libreria
			//Type = 4 editorial
		    if (type == 3 || type == 4){
		    	RequestDispatcher view = req.getRequestDispatcher("AddBookPago.jsp");
		        view.forward(req, resp);
		    }
		    if (type == 2){
		    	RequestDispatcher view = req.getRequestDispatcher("AddBookBiblio.jsp");
		        view.forward(req, resp);
		    }
		    if(type == 1){
		    	RequestDispatcher view = req.getRequestDispatcher("AddBook.jsp");
		        view.forward(req, resp);
		    }

		}
		
		
		
	}

}