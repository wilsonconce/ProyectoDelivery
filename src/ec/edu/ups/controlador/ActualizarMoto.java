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
@WebServlet("/ActualizarMoto")
public class ActualizarMoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MotoDAO motoDAO;
    private Moto moto;
	
    public ActualizarMoto() {
        motoDAO = JDBCDAOFactory.getFactory().getMotoDAO();
        moto = new Moto();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			moto.setPlaca(request.getParameter("placa"));
			moto.setModelo(request.getParameter("modelo"));		
			moto.setMarca(request.getParameter("marca"));
			moto.setColor(request.getParameter("color"));
			
			motoDAO.update(moto);			
			
			url = "/index.html";
		} catch (Exception e) {
			//url = "/JSPs/error.jsp";
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	
	}

}
