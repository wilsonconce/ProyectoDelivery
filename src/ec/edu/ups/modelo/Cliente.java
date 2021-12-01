package ec.edu.ups.modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Cliente implements Serializable{

	private int idCliente;
	private String nombre;
	private String apellido;
	private String cedula;
	private int edad;
	private String telefono;
	private String correo;
	private String direccion;
	private Usuario usuario;
	
	public Cliente() {
		
	}

	public Cliente(int idCliente, String nombre, String apellido, String cedula, int edad, String telefono,
			String correo, String direccion, Usuario usuario) {
		this.setIdCliente(idCliente);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCedula(cedula);
		this.setEdad(edad);
		this.setTelefono(telefono);
		this.setCorreo(correo);
		this.setDireccion(direccion);
		this.setUsuario(usuario);
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
