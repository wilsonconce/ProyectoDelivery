package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.JDBCDAOFactory;
import ec.edu.ups.dao.MotorizadoDAO;
import ec.edu.ups.modelo.Motorizado;

/**
 * Servlet implementation class CrearMotorizado
 */
@WebServlet("/BuscarMotorizado")
public class BuscarMotorizado extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MotorizadoDAO motorizadoDAO;
    private Motorizado motorizado;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarMotorizado() {
       motorizadoDAO = JDBCDAOFactory.getFactory().getMotorizadoDAO();
       motorizado = new Motorizado();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			int id = Integer.valueOf(request.getParameter("idMotorizado"));
			motorizado = motorizadoDAO.read(id);
			request.setAttribute("motorizado", motorizado);
			
			url = "/JSPs/buscar_motorizado.jps";
		} catch (Exception e) {
			//url = "/JSPs/error.jsp";
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	
	}

}
