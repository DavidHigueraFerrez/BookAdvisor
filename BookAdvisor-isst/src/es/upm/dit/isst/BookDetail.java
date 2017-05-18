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
import es.upm.dit.isst.resena.dao.ResenaDAO;
import es.upm.dit.isst.resena.dao.ResenaDAOImpl;
import es.upm.dit.isst.resena.model.Resena;

public class BookDetail extends HttpServlet{
	
	private static final Long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		String id = req.getParameter("id");
		BookDAO dao = BookDAOImpl.getInstance();
		Book books = dao.getBook(Long.parseLong(id));
		System.out.println(books.getDescription());
		req.getSession().setAttribute("books",books);
		ResenaDAO daoresena = ResenaDAOImpl.getInstance();
		List<Resena> resenas = new ArrayList<Resena>();
		resenas = daoresena.listResenaByBook(Long.parseLong(id));
		req.getSession().setAttribute("resenas", new ArrayList<Resena>(resenas));
		double notamedia = 0;
		double notaacumulada = 0;
		for (int i=0; i< resenas.size() ; i++){
			notaacumulada += resenas.get(i).getNota();
			double denominador = i+1;
			notamedia = notaacumulada/denominador;
		}
		System.out.println("Nota acumulada: "+notaacumulada);
		System.out.println("Nota media: "+notamedia);
		req.getSession().setAttribute("nota",notamedia);
				
	
		if (user == null){
			resp.sendRedirect("/"); //si no estoy logueado me devuelve al inicio
			
		} else{
			
			RequestDispatcher view = req.getRequestDispatcher("BookDetail.jsp");
	        view.forward(req, resp);
			
		}
		
		
		
	}

}
