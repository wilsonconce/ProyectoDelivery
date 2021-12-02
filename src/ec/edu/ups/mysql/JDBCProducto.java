package ec.edu.ups.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Producto;

public class JDBCProducto extends JDBCGenericDAO<Producto, Integer> implements ProductoDAO {

	@Override
	public void createTable() {
		conexion.update("DROP TABLE IF EXISTS Producto");
		conexion.update("CREATE TABLE Producto (" 
					  + "ID INT NOT NULL AUTO_INCREMENT, " 
					  + "NOMBRE VARCHAR(100), "
					  + "COSTO DOUBLE, " 
					  + "DESCRIPCION VARCHAR(100), "
					  + "IDESTABLECIMIENTO INT NOT NULL, "
					  + "PRIMARY KEY (ID), "
					  + "FOREIGN KEY (IDESTABLECIMIENTO) REFERENCES ESTABLECIMIENTO(IDESTABLECIMIENTO))");
	}

	@Override
	public void create(Producto producto ) {
		conexion.update("INSERT Producto (NOMBRE, COSTO, DESCRIPCION, IDESTABLECIMIENTO) VALUES ('" 
							+ producto.getNombre() + "', "
							+ producto.getCosto() + ", '" 
							+ producto.getDescripcion() +"',"
							+ producto.getEstablecimiento().getIdEstablecimiento() + ")");
	}

	@Override
	public Producto read(Integer id) {
		Producto producto = null;
		ResultSet rs = conexion.query("SELECT * FROM Producto WHERE id=" + id);
		try {
			if (rs != null && rs.next()) {
				producto = new Producto();
				producto.setId(rs.getInt("id"));
				producto.setNombre(rs.getString("nombre"));
				producto.setCosto(rs.getDouble("costo"));
				producto.setDescripcion(rs.getString("descripcion"));
				producto.getEstablecimiento().setIdEstablecimiento(rs.getInt("idestablecimiento"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCProductoDAO:read): " + e.getMessage());
		}

		return producto;
	}

	@Override
	public void update(Producto producto) {
		conexion.update("UPDATE Producto SET "
					  + "nombre = '" + producto.getNombre() 
					  + "', costo = " + producto.getCosto() 
					  + ", descripcion = '" + producto.getDescripcion() 
					  + "', idestablecimiento= " + producto.getEstablecimiento().getIdEstablecimiento()
					  + " WHERE nombre = '" + producto.getNombre() + "'");

	}

	@Override
	public void delete(Producto producto) {
		conexion.update("DELETE FROM Producto WHERE id = " + producto.getId());

	}

	@Override
	public List<Producto> find() {
		List<Producto> list = new ArrayList<Producto>();
		ResultSet rs = conexion.query("SELECT * FROM Producto");
		try {
			while (rs.next()) {
				Producto producto = new Producto();
				producto.setId(rs.getInt("id"));
				producto.setNombre(rs.getString("nombre"));
				producto.setCosto(rs.getDouble("costo"));
				producto.setDescripcion(rs.getString("descripcion"));
				producto.getEstablecimiento().setIdEstablecimiento(rs.getInt("idestablecimiento"));
				list.add(producto);
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCProductoDAO:find): " + e.getMessage());
		}
		return list;
	}
}
