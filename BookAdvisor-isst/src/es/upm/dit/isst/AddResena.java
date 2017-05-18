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
import es.upm.dit.isst.resena.dao.ResenaDAO;
import es.upm.dit.isst.resena.dao.ResenaDAOImpl;
import es.upm.dit.isst.resena.model.Resena;

public class AddResena extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// //////////CREATE RESOURCE///////////////////////
		UserService userService = UserServiceFactory.getUserService();
		User autor = userService.getCurrentUser();
		String title = checkNull(req.getParameter("title"));
		String Description = checkNull(req.getParameter("description"));
		String nota = req.getParameter("nota");
		String book = req.getParameter("book");
		ResenaDAO dao = ResenaDAOImpl.getInstance();
		dao.add(title, Description, Integer.parseInt(nota), Long.parseLong(book), autor);
		System.out.println("añadido resena con titulo y descrip:"+title+" "+Description+" y USer:" +nota+" "+book+" "+autor);
		PrintWriter out = resp.getWriter();
		req.getSession().setAttribute("dialogo", "Resena creada Correctamente!");

		//resp.sendRedirect("/mandamail?title=" + title + "&description="
		//		+ Description + "&price=" + price + "&service=" + service);

		resp.sendRedirect("/detallelibro?id="+book);
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
		String id = req.getParameter("id");
		req.getSession().setAttribute("id", id);
	
		if (user == null){
			resp.sendRedirect("/"); //si no estoy logueado me devuelve al inicio
			
		} else{
			RequestDispatcher view = req.getRequestDispatcher("AddResena.jsp");
	        view.forward(req, resp);
		}
		
		
		
	}

}