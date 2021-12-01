package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EstablecimientoDAO;
import ec.edu.ups.modelo.Establecimiento;

/**
 * Servlet implementation class EliminarEstablecimiento
 */
@WebServlet("/EliminarEstablecimiento")
public class EliminarEstablecimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EstablecimientoDAO establecimientoDAO;
	private Establecimiento establecimiento;  
	
    public EliminarEstablecimiento() {
    	establecimientoDAO = DAOFactory.getFactory().getEstablecimientoDAO();
    	establecimiento = new Establecimiento();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			establecimiento.setIdEstablecimiento(Integer.valueOf(request.getParameter("id")));		
			establecimientoDAO.delete(establecimiento);

			url = "/index.html";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
