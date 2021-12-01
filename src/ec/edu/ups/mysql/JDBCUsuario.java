package ec.edu.ups.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;

public class JDBCUsuario extends JDBCGenericDAO<Usuario, Integer> implements UsuarioDAO {

	@Override
	public void createTable() {
		conexion.update("DROP TABLE IF EXISTS Usuario");
		conexion.update("CREATE TABLE Usuario (" 
					  + "IDUSUARIO INT NOT NULL AUTO_INCREMENT, " 
					  + "USERNAME VARCHAR(100), "
					  + "PASSWORD VARCHAR(100), " 
					  + "ROL VARCHAR(50), "
					  + "PRIMARY KEY (IDUSUARIO))");
	}

	@Override
	public void create(Usuario usuario ) {
		conexion.update("INSERT Usuario (USERNAME, PASSWORD, ROL) VALUES ('" 
					    + usuario.getUserName() + "', '"
					    + usuario.getPassword() + "', '" 
					    + usuario.getRol() +"')");
	}

	@Override
	public Usuario read(Integer id) {
		Usuario usuario = null;
		ResultSet rs = conexion.query("SELECT * FROM Usuario WHERE idUsuario=" + id);
		try {
			if (rs != null && rs.next()) {
				usuario = new Usuario(rs.getInt("idUsuario"), rs.getString("username"), rs.getString("password"), rs.getString("rol"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUsuariooDAO:read): " + e.getMessage());
		}

		return usuario;
	}

	@Override
	public void update(Usuario usuario) {
		conexion.update("UPDATE Usuario SET "
					  + "username = '" + usuario.getUserName() 
					  + "', password = '" + usuario.getPassword() 
					  + "', rol = '" + usuario.getRol() 
					  + "' WHERE idUsuario = " + usuario.getIdUsuario());

	}

	@Override
	public void delete(Usuario usuario) {
		conexion.update("DELETE FROM Usuario WHERE idUsuario = " + usuario.getIdUsuario());

	}

	@Override
	public List<Usuario> find() {
		List<Usuario> list = new ArrayList<Usuario>();
		ResultSet rs = conexion.query("SELECT * FROM Usuario");
		try {
			while (rs.next()) {
				list.add(new Usuario(rs.getInt("idUsurio"), rs.getString("username"), rs.getString("password"),  rs.getString("rol")));
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCProductoDAO:find): " + e.getMessage());
		}
		return list;
	}
}
