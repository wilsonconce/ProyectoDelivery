package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EstablecimientoDAO;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Establecimiento;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class ActualizarEstablecimiento
 */
@WebServlet("/ActualizarEstablecimiento")
public class ActualizarEstablecimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EstablecimientoDAO establecimientoDAO;
	private Establecimiento establecimiento;
    private Usuario usuario;	
    private Categoria categoria;
	
    public ActualizarEstablecimiento() {
    	establecimientoDAO = DAOFactory.getFactory().getEstablecimientoDAO();
    	establecimiento = new Establecimiento();
    	usuario = new Usuario();
    	categoria = new Categoria();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			
			establecimiento.setNombre(request.getParameter("nombre"));
			establecimiento.setDireccion(request.getParameter("direccion"));	
			establecimiento.setTelefono(request.getParameter("telefono"));	
			establecimiento.setHorario(request.getParameter("horario"));
			
			usuario.setIdUsuario(Integer.valueOf(request.getParameter("idusuario")));
			establecimiento.setUsuario(usuario);
			
			categoria.setIdCategoria(Integer.valueOf(request.getParameter("idcategoria")));
			establecimiento.setCategoria(categoria);
			
			establecimientoDAO.update(establecimiento);			
			
			url = "/index.html";
		} catch (Exception e) {
			//url = "/JSPs/error.jsp";
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	
	}

}
