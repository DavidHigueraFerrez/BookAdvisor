package es.upm.dit.isst;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserServiceFactory;

import es.upm.dit.isst.books.dao.BookDAO;
import es.upm.dit.isst.books.dao.BookDAOImpl;
import es.upm.dit.isst.user.dao.UserDAO;
import es.upm.dit.isst.user.dao.UserDAOImpl;



public class RemoveUser extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private void alertHTML(PrintWriter out, String message) throws IOException {
		out.println("<script type=\"text/javascript\">");
		out.println("alert('" + message + "');");
		out.println("</script>");

	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		PrintWriter out = resp.getWriter();
		// /////COMPROBACION ADMIN///////////
		
			String id = req.getParameter("id");
			UserDAO dao = UserDAOImpl.getInstance();
			dao.remove(id);
			//alertHTML(out, "Reserva eliminada!!");
			req.getSession().setAttribute("dialogo", "Oferta Eliminada Correctamente!");

		
		out.println("<script>location='/mybooks';</script>");

		
	}
}
	

