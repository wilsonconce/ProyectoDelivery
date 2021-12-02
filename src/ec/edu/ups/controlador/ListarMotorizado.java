package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.MotorizadoDAO;
import ec.edu.ups.modelo.Motorizado;

/**
 * Servlet implementation class ListarEstablecimiento
 */
@WebServlet("/ListarMotorizado")
public class ListarMotorizado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MotorizadoDAO motorizadoDAO;
	private List<Motorizado> listaMotorizado;
       
  
    public ListarMotorizado() {
    	motorizadoDAO = DAOFactory.getFactory().getMotorizadoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			listaMotorizado = motorizadoDAO.find();
			request.setAttribute("motorizado", listaMotorizado);
			url = "/JSPs/listar_motorizado.jsp";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	

	
}
