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

public class AddUser extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// //////////CREATE RESOURCE///////////////////////
		UserService userService = UserServiceFactory.getUserService();
		String userId = checkNull(req.getParameter("userId"));
		String nickname = checkNull(req.getParameter("nickname"));
		String email = checkNull(req.getParameter("mail"));
		String type = req.getParameter("type");
		UserDAO dao = UserDAOImpl.getInstance();
		System.out.println(userId+nickname+email+type);
		dao.add(userId, email, Integer.parseInt(type), nickname);
		PrintWriter out = resp.getWriter();
		req.getSession().setAttribute("dialogo", "Oferta creada Correctamente!");

		//resp.sendRedirect("/mandamail?title=" + title + "&description="
		//		+ Description + "&price=" + price + "&service=" + service);

		resp.sendRedirect("/");
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
			
		} else{
			RequestDispatcher view = req.getRequestDispatcher("setup.jsp");
	        view.forward(req, resp);
		}
		
		
		
	}

}