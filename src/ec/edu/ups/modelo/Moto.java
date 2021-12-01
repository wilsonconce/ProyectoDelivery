package ec.edu.ups.modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Moto implements Serializable{

	private int idMoto;
	private String placa;
	private String modelo;
	private String marca;
	private String color;
	
	public Moto() {
		
	}

	public Moto(int idMoto, String placa, String modelo, String marca, String color) {
		this.setIdMoto(idMoto);
		this.setPlaca(placa);
		this.setModelo(modelo);
		this.setMarca(marca);
		this.setColor(color);
	}

	public int getIdMoto() {
		return idMoto;
	}

	public void setIdMoto(int idMoto) {
		this.idMoto = idMoto;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
