package ec.edu.ups.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.modelo.Categoria;



public class JDBCCategoria extends JDBCGenericDAO<Categoria, Integer> implements CategoriaDAO {

	@Override
	public void createTable() {
		conexion.update("DROP TABLE IF EXISTS Categoria");
		conexion.update("CREATE TABLE Categoria (" 
					  + "IDCATEGORIA INT NOT NULL AUTO_INCREMENT, " 
				      + "NOMBRE VARCHAR(100), "
				      + "DESCRIPCION VARCHAR(255), "
				      + "PRIMARY KEY (IDCATEGORIA))");
	}

	@Override
	public void create(Categoria categoria) {
		conexion.update("INSERT Categoria (NOMBRE, DESCRIPCION) VALUES ('" 
					    + categoria.getNombre() + "', '" 
					    + categoria.getDescripcion() + "')");
	}

	@Override
	public Categoria read(Integer id) {
		Categoria categoria = null;
		ResultSet rs = conexion.query("SELECT * FROM Categoria WHERE idCategoria= " + id);
		try {
			if (rs != null && rs.next()) {
				categoria = new Categoria(rs.getInt("idCategoria"), rs.getString("nombre"), rs.getString("descripcion"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCCategoriaDAO:read): " + e.getMessage());
		}

		return categoria;
	}

	@Override
	public void update(Categoria categoria) {
		conexion.update("UPDATE Categoria SET "
					  + "nombre = '" + categoria.getNombre() 
					  + "', descripcion = '" + categoria.getDescripcion() 
					  + "' WHERE nombre = '" + categoria.getNombre() + "'");

	}

	@Override
	public void delete(Categoria categoria) {
		conexion.update("DELETE FROM Categoria WHERE idCategoria = " + categoria.getIdCategoria());

	}

	@Override
	public List<Categoria> find() {
		List<Categoria> list = new ArrayList<Categoria>();
		ResultSet rs = conexion.query("SELECT * FROM Categoria");
		try {
			while (rs.next()) {
				list.add(new Categoria(rs.getInt("idCategoria"), rs.getString("nombre"), rs.getString("descripcion")));
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCCategoriaDAO:find): " + e.getMessage());
		}
		return list;
	}
}
