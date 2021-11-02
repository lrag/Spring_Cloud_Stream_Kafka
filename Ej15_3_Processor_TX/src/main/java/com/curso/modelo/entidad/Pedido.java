package com.curso.modelo.entidad;

import java.time.LocalDateTime;

public class Pedido {

	private Long fecha;
	private String cliente;
	private String producto;
	private Integer cantidad;

	public Pedido() {
		super();
	}

	public Pedido(String cliente, String producto, Integer cantidad) {
		super();
		this.fecha = System.currentTimeMillis();
		this.cliente = cliente;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Long getFecha() {
		return fecha;
	}

	public void setFecha(Long fecha) {
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
	
	@Override
	public String toString() {
		return "Pedido [fecha=" + fecha + ", cliente=" + cliente + ", producto=" + producto + ", cantidad=" + cantidad
				+ "]";
	}

}
