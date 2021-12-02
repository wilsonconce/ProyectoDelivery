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

/**
 * Servlet implementation class CrearMotorizado
 */
@WebServlet("/BuscarCliente")
public class BuscarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ClienteDAO clienteDAO;
    private Cliente cliente;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarCliente() {
       clienteDAO = JDBCDAOFactory.getFactory().getClienteDAO();
       cliente = new Cliente();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			int id = Integer.valueOf(request.getParameter("idCliente"));
			cliente = clienteDAO.read(id);
			request.setAttribute("cliente", cliente);
			url = "/JSPs/buscar_cliente.jsp";
		} catch (Exception e) {
			//url = "/JSPs/error.jsp";
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	
	}

}
