package ec.edu.ups.modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Establecimiento implements Serializable{

	private int idEstablecimiento;
	private String nombre;
	private String direccion;
	private String telefono;
	private String horario;
	private Usuario usuario;
	private Categoria categoria;
	
	public Establecimiento() {
		
		// TODO Auto-generated constructor stub
	}

	public Establecimiento(int idEstablecimiento, String nombre, String direccion, String telefono, String horario, Usuario usuario, Categoria categoria) {
		
		this.setIdEstablecimiento(idEstablecimiento);
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setTelefono(telefono);
		this.setHorario(horario);
		this.setUsuario(usuario);
		this.setCategoria(categoria);
	}

	public int getIdEstablecimiento() {
		return idEstablecimiento;
	}

	public void setIdEstablecimiento(int idEstablecimiento) {
		this.idEstablecimiento = idEstablecimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
