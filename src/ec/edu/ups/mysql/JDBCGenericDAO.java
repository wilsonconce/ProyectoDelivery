package ec.edu.ups.mysql;

import ec.edu.ups.dao.GenericDAO;

public abstract class JDBCGenericDAO<T, ID> implements GenericDAO<T, ID> {
	protected ContextJDBC conexion = ContextJDBC.getJDBC1();

}