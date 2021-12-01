package ec.edu.ups.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.ClienteDAO;
import ec.edu.ups.modelo.Cliente;

public class JDBCCliente extends JDBCGenericDAO<Cliente, Integer> implements ClienteDAO{

	@Override
	public void createTable() {
		conexion.update("DROP TABLE IF EXISTS Cliente");
		conexion.update("CREATE TABLE Cliente (" 
					  + "IDCLIENTE INT NOT NULL AUTO_INCREMENT, " 
				      + "NOMBRE VARCHAR(100), "
				      + "APELLIDO VARCHAR(100), "
				      + "CEDULA VARCHAR(100), "
					  + "EDAD INT NOT NULL, " 
				      + "TELEFONO VARCHAR(255), " 
					  + "CORREO VARCHAR(255), " 
					  + "DIRECCION VARCHAR(255), "
					  + "IDUSUARIO INT NOT NULL, " 
					  + "PRIMARY KEY (IDCLIENTE), "
					  + "FOREIGN KEY (IDUSUARIO) REFERENCES USUARIO(IDUSUARIO))");
		
	}

	@Override
	public void create(Cliente cliente) {
		conexion.update("INSERT Cliente (NOMBRE, APELLIDO, CEDULA, EDAD, TELEFONO, CORREO, DIRECCION, IDUSUARIO) VALUES ('" 
				+ cliente.getNombre() + "', '"
				+ cliente.getApellido() + "', '" 
				+ cliente.getCedula() + "', "
				+ cliente.getEdad() + ", '"
				+ cliente.getTelefono() + "', '" 
				+ cliente.getCorreo() + "', '"
				+ cliente.getDireccion() + "', "
				+ cliente.getUsuario().getIdUsuario() + ")");
	}
		
	

	@Override
	public Cliente read(Integer id) {
		Cliente cliente = null;
		ResultSet rs = conexion.query("SELECT * FROM Cliente WHERE idCliente=" + id);
		try {
				if (rs != null && rs.next()) {
					cliente = new Cliente();
					cliente.setIdCliente(rs.getInt("idMotorizado"));
					cliente.setNombre(rs.getString("nombre"));
					cliente.setApellido(rs.getString("apellido"));
					cliente.setCedula(rs.getString("cedula"));
					cliente.setEdad(rs.getInt("edad"));
					cliente.setTelefono(rs.getString("telefono"));
					cliente.setCorreo(rs.getString("correo"));
					cliente.setDireccion(rs.getString("direccion"));
					cliente.getUsuario().setIdUsuario(rs.getInt("idusuario"));
				}
				rs.close();
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCEstablecimientoDAO:read): " + e.getMessage());
		}

		return cliente;
	}

	@Override
	public void update(Cliente cliente) {
		conexion.update("UPDATE Cliente SET "
				+ "nombre = '" + cliente.getNombre() + "', "
				+ "apellido = '" + cliente.getApellido() + "', "
				+ "edad = '" + cliente.getEdad() + ", '"
				+ "telefono = '" + cliente.getTelefono() + "', '"
				+ "correo = " + cliente.getCorreo() + "', '"
				+ "direccion = " + cliente.getDireccion() + "', "
				+ "idusuario = " + cliente.getUsuario().getIdUsuario() 
				+ "WHERE idCliente = " + cliente.getIdCliente());
	}

	@Override
	public void delete(Cliente cliente) {
		conexion.update("DELETE FROM Cliente WHERE idCliente = " + cliente.getIdCliente());
		
	}

	@Override
	public List<Cliente> find() {
		List<Cliente> list = new ArrayList<Cliente>();
		ResultSet rs = conexion.query("SELECT * FROM Cliente");
		try {
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(rs.getInt("idMotorizado"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellido(rs.getString("apellido"));
				cliente.setCedula(rs.getString("cedula"));
				cliente.setEdad(rs.getInt("edad"));
				cliente.setTelefono(rs.getString("telefono"));
				cliente.setCorreo(rs.getString("correo"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.getUsuario().setIdUsuario(rs.getInt("idusuario"));
				list.add(cliente);
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCEstablecimientoDAO:find): " + e.getMessage());
		}
		return list;
	}

}
