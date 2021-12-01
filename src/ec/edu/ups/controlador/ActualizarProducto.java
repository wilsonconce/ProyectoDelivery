package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Establecimiento;
import ec.edu.ups.modelo.Producto;


@WebServlet("/ActualizarProducto")
public class ActualizarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDAO;
	private Producto producto;
	private Establecimiento establecimiento;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarProducto() {
    	productoDAO = DAOFactory.getFactory().getProductoDAO();
    	producto = new Producto();
    	establecimiento = new Establecimiento();
    	
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			producto.setNombre(request.getParameter("nombre"));
			producto.setCosto(Double.valueOf(request.getParameter("costo")));	
			producto.setDescripcion(request.getParameter("descripcion"));	
			
			establecimiento.setIdEstablecimiento(Integer.valueOf(request.getParameter("idestablecimiento")));
			producto.setEstablecimiento(establecimiento);
			
			productoDAO.update(producto);			
			
			url = "/index.html";
		} catch (Exception e) {
			//url = "/JSPs/error.jsp";
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	
	}

}
