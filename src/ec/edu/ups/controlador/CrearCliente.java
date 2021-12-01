package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.ClienteDAO;
import ec.edu.ups.dao.JDBCDAOFactory;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class CrearMotorizado
 */
@WebServlet("/CrearCliente")
public class CrearCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ClienteDAO clienteDAO;
    private Cliente cliente;
    private Usuario usuario;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearCliente() {
       clienteDAO = JDBCDAOFactory.getFactory().getClienteDAO();
       cliente = new Cliente();
       usuario = new Usuario();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			cliente.setNombre(request.getParameter("nombre"));
			cliente.setApellido(request.getParameter("apellido"));
			cliente.setCedula(request.getParameter("cedula"));
			cliente.setEdad(Integer.valueOf(request.getParameter("edad")));
			cliente.setTelefono(request.getParameter("telefono"));
			cliente.setCorreo(request.getParameter("correo"));
			cliente.setDireccion(request.getParameter("direccion"));
			
			usuario.setIdUsuario(Integer.valueOf(request.getParameter("idusuario")));
			cliente.setUsuario(usuario);
			
			clienteDAO.create(cliente);			
			
			url = "/index.html";
		} catch (Exception e) {
			//url = "/JSPs/error.jsp";
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	
	}

}
