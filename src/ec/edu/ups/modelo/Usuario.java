package ec.edu.ups.modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Usuario implements Serializable{

	private int idUsuario;
	private String userName;
	private String password;
	private String rol;
	
	public Usuario() {
		
	}

	public Usuario(int idUsuario, String userName, String password, String rol) {
		super();
		this.setIdUsuario(idUsuario);
		this.setUserName(userName);
		this.setPassword(password);
		this.setRol(rol);
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
}
