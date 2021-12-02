package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.modelo.Categoria;

/**
 * Servlet implementation class ListarEstablecimiento
 */
@WebServlet("/ListarCategoria")
public class ListarCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoriaDAO categoriaDAO;
	private List<Categoria> listaCategoria;
       
  
    public ListarCategoria() {
    	categoriaDAO = DAOFactory.getFactory().getCategoriaDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			listaCategoria = categoriaDAO.find();
			request.setAttribute("categoria", listaCategoria);
			url = "/JSPs/listar_categoria.jsp";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	

	
}
