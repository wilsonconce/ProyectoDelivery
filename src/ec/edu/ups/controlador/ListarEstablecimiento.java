package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EstablecimientoDAO;
import ec.edu.ups.modelo.Establecimiento;

/**
 * Servlet implementation class ListarEstablecimiento
 */
@WebServlet("/ListarEstablecimiento")
public class ListarEstablecimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EstablecimientoDAO establecimientoDAO;
	private List<Establecimiento> listaEstablecimiento;
       
  
    public ListarEstablecimiento() {
    	establecimientoDAO = DAOFactory.getFactory().getEstablecimientoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			listaEstablecimiento = establecimientoDAO.find();
			request.setAttribute("establecimiento", listaEstablecimiento);
			url = "/JSPs/listar_establecimiento.jsp";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	

	
}
