package ec.edu.ups.dao;

import ec.edu.ups.mysql.JDBCCategoria;
import ec.edu.ups.mysql.JDBCCliente;
import ec.edu.ups.mysql.JDBCEstablecimiento;
import ec.edu.ups.mysql.JDBCMoto;
import ec.edu.ups.mysql.JDBCMotorizado;
import ec.edu.ups.mysql.JDBCProducto;
import ec.edu.ups.mysql.JDBCUsuario;

public class JDBCDAOFactory extends DAOFactory {

	@Override
	public void createTables() {
		this.getCategoriaDAO().createTable();
		this.getUsuarioDAO().createTable();
		this.getEstablecimientoDAO().createTable();
		this.getProductoDAO().createTable();
		this.getMotoDAO().createTable();
		this.getMotorizadoDAO().createTable();
		this.getClienteDAO().createTable();
		
	}

	
	@Override
	public CategoriaDAO getCategoriaDAO() {
		// TODO Auto-generated method stub
		return new JDBCCategoria();
	}	

	@Override
	public EstablecimientoDAO getEstablecimientoDAO() {
		// TODO Auto-generated method stub
		return new JDBCEstablecimiento();
	}


	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new JDBCUsuario();
	}


	@Override
	public MotoDAO getMotoDAO() {
		// TODO Auto-generated method stub
		return new JDBCMoto();
	}


	@Override
	public MotorizadoDAO getMotorizadoDAO() {
		// TODO Auto-generated method stub
		return new JDBCMotorizado();
	}


	@Override
	public ProductoDAO getProductoDAO() {
		// TODO Auto-generated method stub
		return new JDBCProducto();
	}


	@Override
	public ClienteDAO getClienteDAO() {
		// TODO Auto-generated method stub
		return new JDBCCliente();
	}

}

