package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.dao.ClienteDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EstablecimientoDAO;
import ec.edu.ups.dao.MotoDAO;
import ec.edu.ups.dao.MotorizadoDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.dao.UsuarioDAO;

/**
 * Servlet implementation class CrearTabla
 */
@WebServlet("/CrearTabla")
public class CrearTabla extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EstablecimientoDAO establecimientoDAO;  
    private CategoriaDAO categoriaDAO;
    private UsuarioDAO usuarioDAO;
    private ProductoDAO productoDAO;
    private MotoDAO motoDAO;
    private MotorizadoDAO motorizadoDAO;
    private ClienteDAO clienteDAO;
    
    
    public CrearTabla() {
        establecimientoDAO = DAOFactory.getFactory().getEstablecimientoDAO();
        categoriaDAO = DAOFactory.getFactory().getCategoriaDAO();
        usuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
        productoDAO = DAOFactory.getFactory().getProductoDAO();
        motoDAO = DAOFactory.getFactory().getMotoDAO();
        motorizadoDAO = DAOFactory.getFactory().getMotorizadoDAO();
        clienteDAO = DAOFactory.getFactory().getClienteDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;
		try {
			categoriaDAO.createTable();
			usuarioDAO.createTable();
			establecimientoDAO.createTable();
			productoDAO.createTable();
			motoDAO.createTable();
			motorizadoDAO.createTable();
			clienteDAO.createTable();
			url = "/index.html";
		} catch (Exception e) {
			//url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);

	}

}
