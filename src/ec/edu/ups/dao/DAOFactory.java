package ec.edu.ups.dao;

public abstract class DAOFactory {
	protected static DAOFactory factory = new JDBCDAOFactory();

	public static DAOFactory getFactory() {
		return factory;
	}

	public abstract void createTables();
	public abstract CategoriaDAO getCategoriaDAO();
	public abstract UsuarioDAO getUsuarioDAO();
	public abstract EstablecimientoDAO getEstablecimientoDAO();
	public abstract ProductoDAO getProductoDAO();
	public abstract MotoDAO getMotoDAO();
	public abstract MotorizadoDAO getMotorizadoDAO();
	public abstract ClienteDAO getClienteDAO();

}
