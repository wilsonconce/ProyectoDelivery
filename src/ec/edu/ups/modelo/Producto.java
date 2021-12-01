package ec.edu.ups.modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Producto implements Serializable{

	private int id;
	private String nombre;
	private Double costo;
	private String descripcion;
	private Establecimiento establecimiento;
	
	public Producto() {
		
		// TODO Auto-generated constructor stub
	}

	public Producto(int id, String nombre, Double costo, String descripcion, Establecimiento establecimiento) {
		
		this.setId(id);
		this.setNombre(nombre);
		this.setCosto(costo);
		this.setDescripcion(descripcion);
		this.setEstablecimiento(establecimiento);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Establecimiento getEstablecimiento() {
		return establecimiento;
	}

	public void setEstablecimiento(Establecimiento establecimiento) {
		this.establecimiento = establecimiento;
	}
	
	
}
