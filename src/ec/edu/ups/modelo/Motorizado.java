package ec.edu.ups.modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Motorizado implements Serializable{
	
	private int idMotorizado;
	private String nombre;
	private String apellido;
	private int edad;
	private String telefono;
	private String correo;
	private Usuario usuario;
	private Moto moto;
	
	public Motorizado() {
		
	}

	public Motorizado(int idMotorizado, String nombre, String apellido, int edad, String telefono, String correo, Usuario usuario, Moto moto) {
		this.setIdMotorizado(idMotorizado);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setEdad(edad);
		this.setTelefono(telefono);
		this.setCorreo(correo);
		this.setUsuario(usuario);
		this.setMoto(moto);
	}

	public int getIdMotorizado() {
		return idMotorizado;
	}

	public void setIdMotorizado(int idMotorizado) {
		this.idMotorizado = idMotorizado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Moto getMoto() {
		return moto;
	}

	public void setMoto(Moto moto) {
		this.moto = moto;
	} 
	
	
}
