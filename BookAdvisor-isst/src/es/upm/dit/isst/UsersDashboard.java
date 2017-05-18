package es.upm.dit.isst;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import es.upm.dit.isst.user.dao.UserDAO;
import es.upm.dit.isst.user.dao.UserDAOImpl;
import es.upm.dit.isst.user.model.AppUser;

public class UsersDashboard extends HttpServlet{
	
	private static final Long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		
		UserDAO dao = UserDAOImpl.getInstance();
		List<AppUser> offers = new ArrayList<AppUser>();
		offers = dao.listUsers();
		req.getSession().setAttribute("users",
				new ArrayList<AppUser>(offers));
		 boolean admin = userService.isUserAdmin();
		if (admin){
			
			RequestDispatcher view = req.getRequestDispatcher("AllUsersDashboard.jsp");
	        view.forward(req, resp);
			
		}
		else{
			resp.sendRedirect("/"); //si no estoy logueado me devuelve al inicio
			
		} 
		
		
		
	}
}