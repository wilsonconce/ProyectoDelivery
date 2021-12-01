package ec.edu.ups.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.EstablecimientoDAO;
import ec.edu.ups.modelo.Establecimiento;

public class JDBCEstablecimiento extends JDBCGenericDAO<Establecimiento, Integer> implements EstablecimientoDAO{
	
	@Override
	public void createTable() {
		conexion.update("DROP TABLE IF EXISTS Establecimiento");
		conexion.update("CREATE TABLE Establecimiento (" 
					  + "IDESTABLECIMIENTO INT NOT NULL AUTO_INCREMENT, " 
				      + "NOMBRE VARCHAR(100), "
					  + "DIRECCION VARCHAR(255), " 
				      + "TELEFONO VARCHAR(255), " 
					  + "HORARIO VARCHAR(255), " 
					  + "IDUSUARIO INT NOT NULL, " 
					  + "IDCATEGORIA INT NOT NULL, " 
					  + "PRIMARY KEY (IDESTABLECIMIENTO),"
					  + "FOREIGN KEY (IDUSUARIO) REFERENCES USUARIO(IDUSUARIO),"
					  + "FOREIGN KEY (IDCATEGORIA) REFERENCES CATEGORIA(IDCATEGORIA))");
	}

	@Override
	public void create(Establecimiento establecimiento) {
		conexion.update("INSERT Establecimiento (NOMBRE, DIRECCION, TELEFONO, HORARIO, IDUSUARIO, IDCATEGORIA) VALUES ('" 
						+ establecimiento.getNombre() + "', '"
						+ establecimiento.getDireccion() + "', '" 
						+ establecimiento.getTelefono() + "', '" 
						+ establecimiento.getHorario() + "',"
						+ establecimiento.getUsuario().getIdUsuario() + ","
						+ establecimiento.getCategoria().getIdCategori() + ")");
	}

	@Override
	public Establecimiento read(Integer id) {
		Establecimiento establecimiento = null;
		ResultSet rs = conexion.query("SELECT * FROM Establecimiento WHERE idEstablecimiento=" + id);
		try {
				if (rs != null && rs.next()) {
					establecimiento = new Establecimiento();
					establecimiento.setIdEstablecimiento(rs.getInt("idEstablecimiento"));
					establecimiento.setNombre(rs.getString("nombre"));
					establecimiento.setDireccion(rs.getString("direccion"));
					establecimiento.setTelefono(rs.getString("telefono"));
					establecimiento.setHorario(rs.getString("horario"));
					establecimiento.getUsuario().setIdUsuario(rs.getInt("idusuario"));
					establecimiento.getCategoria().setIdCategoria(rs.getInt("idCategoria"));
				}
				rs.close();
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCEstablecimientoDAO:read): " + e.getMessage());
		}

		return establecimiento;
	}

	@Override
	public void update(Establecimiento establecimiento) {
		conexion.update("UPDATE Establecimiento SET "
						+ "nombre = '" + establecimiento.getNombre() + "', "
						+ "direccion = '" + establecimiento.getDireccion() + "', "
						+ "telefono = '" + establecimiento.getTelefono() + "', "
						+ "horario = '" + establecimiento.getHorario() + "',"
						+ "idusuario = " + establecimiento.getUsuario().getIdUsuario() + ", "
						+ "idcategoria = " + establecimiento.getCategoria().getIdCategori() + ", "
						+ "WHERE idEstablecimiento = " + establecimiento.getIdEstablecimiento());

	}

	@Override
	public void delete(Establecimiento establecimiento) {
		conexion.update("DELETE FROM Establecimiento WHERE idEstablecimiento = " + establecimiento.getIdEstablecimiento());

	}

	@Override
	public List<Establecimiento> find() {
		List<Establecimiento> list = new ArrayList<Establecimiento>();
		ResultSet rs = conexion.query("SELECT * FROM Establecimiento");
		try {
			while (rs.next()) {
				Establecimiento establecimiento = new Establecimiento();
				establecimiento.setIdEstablecimiento(rs.getInt("idEstablecimiento"));
				establecimiento.setNombre(rs.getString("nombre"));
				establecimiento.setDireccion(rs.getString("direccion"));
				establecimiento.setTelefono(rs.getString("telefono"));
				establecimiento.setHorario(rs.getString("horario"));
				establecimiento.getUsuario().setIdUsuario(rs.getInt("idusuario"));
				establecimiento.getCategoria().setIdCategoria(rs.getInt("idCategoria"));
				list.add(establecimiento);
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCEstablecimientoDAO:find): " + e.getMessage());
		}
		return list;
	}

}
