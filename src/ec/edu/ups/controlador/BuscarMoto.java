package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.JDBCDAOFactory;
import ec.edu.ups.dao.MotoDAO;
import ec.edu.ups.modelo.Moto;

/**
 * Servlet implementation class CrearMoto
 */
@WebServlet("/BuscarMoto")
public class BuscarMoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MotoDAO motoDAO;
    private Moto moto;
	
    public BuscarMoto() {
        motoDAO = JDBCDAOFactory.getFactory().getMotoDAO();
        moto = new Moto();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			int id = Integer.valueOf(request.getParameter("idMoto"));
			moto = motoDAO.read(id);
			request.setAttribute("moto", moto);
			url = "/JSPs/buscar_moto.jsp";
			
		} catch (Exception e) {
			//url = "/JSPs/error.jsp";
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	
	}

}
