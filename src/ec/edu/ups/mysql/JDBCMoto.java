package ec.edu.ups.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.MotoDAO;
import ec.edu.ups.modelo.Moto;

public class JDBCMoto extends JDBCGenericDAO<Moto, Integer> implements MotoDAO{

	@Override
	public void createTable() {
		conexion.update("DROP TABLE IF EXISTS Moto");
		conexion.update("CREATE TABLE Moto (" 
					  + "IDMOTO INT NOT NULL AUTO_INCREMENT, " 
				      + "PLACA VARCHAR(100), "
				      + "MODELO VARCHAR(100), "
					  + "MARCA VARCHAR(100), " 
				      + "COLOR VARCHAR(255), " 
					  + "PRIMARY KEY (IDMOTO))");
		
	}

	@Override
	public void create(Moto moto) {
		conexion.update("INSERT Moto (PLACA, MODELO, MARCA, COLOR) VALUES ('" 
				+ moto.getPlaca() + "', '"
				+ moto.getModelo() + "', '" 
				+ moto.getMarca() + "', '"
				+ moto.getColor() + "')");
		
	}

	@Override
	public Moto read(Integer id) {
		Moto moto = null;
		ResultSet rs = conexion.query("SELECT * FROM Motorizado WHERE idMoto=" + id);
		try {
				if (rs != null && rs.next()) {
					moto = new Moto();
					moto.setPlaca(rs.getString("placa"));
					moto.setModelo(rs.getString("modelo"));
					moto.setMarca(rs.getString("marca"));
					moto.setColor(rs.getString("color"));
				}
				rs.close();
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCMotoDAO:read): " + e.getMessage());
		}

		return moto;
	}

	@Override
	public void update(Moto moto) {
		conexion.update("UPDATE Moto SET "
				+ "placa = '" + moto.getPlaca() + "', "
				+ "modelo = '" + moto.getModelo() + "', "
				+ "marca = '" + moto.getMarca() + "', "
				+ "color = '" + moto.getColor() + "'"
				+ " WHERE placa = '" + moto.getPlaca() + "'" );
		
	}

	@Override
	public void delete(Moto moto) {
		conexion.update("DELETE FROM Moto WHERE idMoto = " + moto.getIdMoto());
		
	}

	@Override
	public List<Moto> find() {
		List<Moto> list = new ArrayList<Moto>();
		ResultSet rs = conexion.query("SELECT * FROM Moto");
		try {
			while (rs.next()) {
				Moto moto = new Moto();
				moto.setPlaca(rs.getString("placa"));
				moto.setModelo(rs.getString("modelo"));
				moto.setMarca(rs.getString("marca"));
				moto.setColor(rs.getString("color"));
				list.add(moto);
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCMotoDAO:find): " + e.getMessage());
		}
		return list;
	}

}
