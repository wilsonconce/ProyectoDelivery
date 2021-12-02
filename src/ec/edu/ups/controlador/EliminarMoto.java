package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.MotoDAO;
import ec.edu.ups.modelo.Moto;

/**
 * Servlet implementation class EliminarEstablecimiento
 */
@WebServlet("/EliminarMoto")
public class EliminarMoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MotoDAO motoDAO;
	private Moto moto;  
	
    public EliminarMoto() {
    	motoDAO = DAOFactory.getFactory().getMotoDAO();
    	moto = new Moto();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			moto.setIdMoto(Integer.valueOf(request.getParameter("id")));		
			motoDAO.delete(moto);

			url = "/index.html";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
