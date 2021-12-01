package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.JDBCDAOFactory;
import ec.edu.ups.dao.MotorizadoDAO;
import ec.edu.ups.modelo.Moto;
import ec.edu.ups.modelo.Motorizado;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class CrearMotorizado
 */
@WebServlet("/CrearMotorizado")
public class CrearMotorizado extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MotorizadoDAO motorizadoDAO;
    private Motorizado motorizado;
    private Usuario usuario;
    private Moto moto;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearMotorizado() {
       motorizadoDAO = JDBCDAOFactory.getFactory().getMotorizadoDAO();
       motorizado = new Motorizado();
       usuario = new Usuario();
       moto = new Moto();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			motorizado.setNombre(request.getParameter("nombre"));
			motorizado.setApellido(request.getParameter("apellido"));		
			motorizado.setEdad(Integer.valueOf(request.getParameter("edad")));
			motorizado.setTelefono(request.getParameter("telefono"));
			motorizado.setCorreo((request.getParameter("correo")));
			
			usuario.setIdUsuario(Integer.valueOf(request.getParameter("idusuario")));
			motorizado.setUsuario(usuario);
			
			moto.setIdMoto(Integer.valueOf(request.getParameter("idMoto")));
			motorizado.setMoto(moto);
			
			motorizadoDAO.create(motorizado);			
			
			url = "/index.html";
		} catch (Exception e) {
			//url = "/JSPs/error.jsp";
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	
	}

}
