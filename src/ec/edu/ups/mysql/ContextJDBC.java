package ec.edu.ups.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContextJDBC {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/deliveryDB";
	private static final String USER = "root";
	private static final String PASS = "root";
	private static ContextJDBC jdbc = null;	
	private Statement statement = null;

	public ContextJDBC() {
		this.connect();
	}

	public void connect() {
		try {
			Class.forName(DRIVER);
			Connection connection = DriverManager.getConnection(URL, USER, PASS);
			this.statement = connection.createStatement();
			System.out.println("CONEXION CORRECTA ");
		} catch (ClassNotFoundException e) {
			System.out.println("Existe problemas con el DRIVER \n" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Existe problemas con la Base de Datos \n" + e.getMessage());
		}
	}

	public ResultSet query(String sql) {
		try {
			return this.statement.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("Error de sentencia " + sql + "---" + e);
		}
		return null;
	}

	public boolean update(String sql) {
		try {
			this.statement.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			System.out.println("Error al actualizar los datos de la base" + sql + "---" + e);
			return false;
		}
	}
	
	protected static ContextJDBC getJDBC1() {
		if (jdbc == null) {
			jdbc = new ContextJDBC();
		}
		return jdbc;

	}

}
