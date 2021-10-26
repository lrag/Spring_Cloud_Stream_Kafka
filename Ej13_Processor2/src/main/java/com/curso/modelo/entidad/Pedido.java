package com.curso.modelo.entidad;

public class Pedido {

	private String fecha;
	private String cliente;
	private String producto;
	private Integer cantidad;
	private Double precio;

	public Pedido() {
		super();
	}

	public Pedido(String fecha, String cliente, String producto, Integer cantidad, Double precio) {
		super();
		this.fecha = fecha;
		this.cliente = cliente;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Pedido [fecha=" + fecha + ", cliente=" + cliente + ", producto=" + producto + ", cantidad=" + cantidad
				+ ", precio=" + precio + "]";
	}

}
