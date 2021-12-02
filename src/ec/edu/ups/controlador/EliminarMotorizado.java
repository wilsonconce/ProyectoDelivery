package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.MotorizadoDAO;
import ec.edu.ups.modelo.Motorizado;

/**
 * Servlet implementation class EliminarEstablecimiento
 */
@WebServlet("/EliminarMotorizado")
public class EliminarMotorizado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MotorizadoDAO motorizadoDAO;
	private Motorizado motorizado;  
	
    public EliminarMotorizado() {
    	motorizadoDAO = DAOFactory.getFactory().getMotorizadoDAO();
    	motorizado = new Motorizado();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			motorizado.setIdMotorizado(Integer.valueOf(request.getParameter("id")));		
			motorizadoDAO.delete(motorizado);

			url = "/index.html";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
