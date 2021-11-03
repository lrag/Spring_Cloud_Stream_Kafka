package com.curso.modelo.entidad;


public class OrdenCompra {

	private Long fecha;
	private String cliente;
	private String producto;
	private Integer cantidad;
	private String datosBancarios;
	private Integer total;

	public OrdenCompra() {
		super();
	}

	public OrdenCompra(Long fecha, String cliente, String producto, Integer cantidad, String datosBancarios,
			Integer total) {
		super();
		this.fecha = fecha;
		this.cliente = cliente;
		this.producto = producto;
		this.cantidad = cantidad;
		this.datosBancarios = datosBancarios;
		this.total = total;
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

	public String getDatosBancarios() {
		return datosBancarios;
	}

	public void setDatosBancarios(String datosBancarios) {
		this.datosBancarios = datosBancarios;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "OrdenCompra [fecha=" + fecha + ", cliente=" + cliente + ", producto=" + producto + ", cantidad="
				+ cantidad + ", datosBancarios=" + datosBancarios + ", total=" + total + "]";
	}

}
