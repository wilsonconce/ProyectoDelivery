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
 * Servlet implementation class EliminarEstablecimiento
 */
@WebServlet("/EliminarCategoria")
public class EliminarCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoriaDAO categoriaDAO;
	private Categoria categoria;  
	
    public EliminarCategoria() {
    	categoriaDAO = DAOFactory.getFactory().getCategoriaDAO();
    	categoria = new Categoria();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			categoria.setIdCategoria(Integer.valueOf(request.getParameter("id")));		
			categoriaDAO.delete(categoria);

			url = "/index.html";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
