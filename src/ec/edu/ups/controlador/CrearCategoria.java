package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.modelo.Categoria;

/**
 * Servlet implementation class CrearCategoria
 */
@WebServlet("/CrearCategoria")
public class CrearCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoriaDAO categoriaDAO;
    private Categoria categoria;
    
    public CrearCategoria() {
    	categoriaDAO = DAOFactory.getFactory().getCategoriaDAO();
    	categoria = new Categoria();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			
			categoria.setNombre(request.getParameter("nombre"));
			categoria.setDescripcion(request.getParameter("descripcion"));	
			categoriaDAO.create(categoria);			
			
			url = "/index.html";
		} catch (Exception e) {
			//url = "/JSPs/error.jsp";
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
