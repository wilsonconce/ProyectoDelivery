package ec.edu.ups.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.MotorizadoDAO;
import ec.edu.ups.modelo.Motorizado;

public class JDBCMotorizado extends JDBCGenericDAO<Motorizado, Integer> implements MotorizadoDAO{

	@Override
	public void createTable() {
		conexion.update("DROP TABLE IF EXISTS Motorizado");
		conexion.update("CREATE TABLE Motorizado (" 
					  + "IDMOTORIZADO INT NOT NULL AUTO_INCREMENT, " 
				      + "NOMBRE VARCHAR(100), "
				      + "APELLIDO VARCHAR(100), "
					  + "EDAD INT NOT NULL, " 
				      + "TELEFONO VARCHAR(255), " 
					  + "CORREO VARCHAR(255), " 
					  + "IDUSUARIO INT NOT NULL, " 
					  + "IDMOTO INT NOT NULL, " 
					  + "PRIMARY KEY (IDMOTORIZADO),"
					  + "FOREIGN KEY (IDUSUARIO) REFERENCES USUARIO(IDUSUARIO),"
					  + "FOREIGN KEY (IDMOTO) REFERENCES MOTO(IDMOTO))");
		
	}

	@Override
	public void create(Motorizado motorizado) {
		conexion.update("INSERT Motorizado (NOMBRE, APELLIDO, EDAD, TELEFONO, CORREO, IDUSUARIO, IDMOTO) VALUES ('" 
				+ motorizado.getNombre() + "', '"
				+ motorizado.getApellido() + "', " 
				+ motorizado.getEdad() + ", '"
				+ motorizado.getTelefono() + "', '" 
				+ motorizado.getCorreo() + "',"
				+ motorizado.getUsuario().getIdUsuario() + ", "
				+ motorizado.getMoto().getIdMoto() + ")");
	}
		
	

	@Override
	public Motorizado read(Integer id) {
		Motorizado motorizado = null;
		ResultSet rs = conexion.query("SELECT * FROM Motorizado WHERE idMotorizado=" + id);
		try {
				if (rs != null && rs.next()) {
					motorizado = new Motorizado();
					motorizado.setIdMotorizado(rs.getInt("idMotorizado"));
					motorizado.setNombre(rs.getString("nombre"));
					motorizado.setApellido(rs.getString("apellido"));
					motorizado.setEdad(rs.getInt("edad"));
					motorizado.setTelefono(rs.getString("telefono"));
					motorizado.setCorreo(rs.getString("correo"));
					motorizado.getUsuario().setIdUsuario(rs.getInt("idusuario"));
					motorizado.getMoto().setIdMoto(rs.getInt("idMoto"));
				}
				rs.close();
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCEstablecimientoDAO:read): " + e.getMessage());
		}

		return motorizado;
	}

	@Override
	public void update(Motorizado motorizado) {
		conexion.update("UPDATE Motorizado SET "
				+ "nombre = '" + motorizado.getNombre() + "', "
				+ "apellido = '" + motorizado.getApellido() + "', "
				+ "edad = " + motorizado.getEdad() + ", "
				+ "telefono = '" + motorizado.getTelefono() + "', "
				+ "correo = '" + motorizado.getCorreo() + "', "
				+ "idusuario = " + motorizado.getUsuario().getIdUsuario() + ", "
				+ "idMoto = " + motorizado.getMoto().getIdMoto() 
				+ " WHERE nombre = '" + motorizado.getNombre() + "'");

		
	}

	@Override
	public void delete(Motorizado motorizado) {
		conexion.update("DELETE FROM Motorizado WHERE idMotorizado = " + motorizado.getIdMotorizado());
		
	}

	@Override
	public List<Motorizado> find() {
		List<Motorizado> list = new ArrayList<Motorizado>();
		ResultSet rs = conexion.query("SELECT * FROM Motorizado");
		try {
			while (rs.next()) {
				Motorizado motorizado = new Motorizado();
				motorizado = new Motorizado();
				motorizado.setIdMotorizado(rs.getInt("idMotorizado"));
				motorizado.setNombre(rs.getString("nombre"));
				motorizado.setApellido(rs.getString("apellido"));
				motorizado.setEdad(rs.getInt("edad"));
				motorizado.setTelefono(rs.getString("telefono"));
				motorizado.setCorreo(rs.getString("correo"));
				motorizado.getUsuario().setIdUsuario(rs.getInt("idusuario"));
				motorizado.getMoto().setIdMoto(rs.getInt("idMoto"));
				list.add(motorizado);
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCEstablecimientoDAO:find): " + e.getMessage());
		}
		return list;
	}

}
