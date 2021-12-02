package ec.edu.ups.modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Categoria implements Serializable{

	private int idCategoria;
	
	private String nombre;
	private String descripcion;
	
	public Categoria() {

		// TODO Auto-generated constructor stub
	}

	public Categoria(int idCategoria, String nombre, String descripcion) {
		this.setIdCategoria(idCategoria);
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
