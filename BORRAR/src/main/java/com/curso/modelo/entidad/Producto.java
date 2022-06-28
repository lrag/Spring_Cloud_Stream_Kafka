package com.curso.modelo.entidad;

public class Producto {

	private String referencia;
	private String nombre;
	private String descripcion;
	private Fabricante fabricante;

	public Producto() {
		super();
	}

	public Producto(String referencia, String nombre, String descripcion, Fabricante fabricante) {
		super();
		this.referencia = referencia;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fabricante = fabricante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", referencia=" + referencia + ", descripcion="
				+ descripcion + ", fabricante=" + fabricante + "]";
	}

}
