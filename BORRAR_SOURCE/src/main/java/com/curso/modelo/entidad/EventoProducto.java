package com.curso.modelo.entidad;

public class EventoProducto {

	private TipoEventoProducto tipo;
	private Producto producto;

	public EventoProducto() {
		super();
	}

	public EventoProducto(TipoEventoProducto tipo, Producto producto) {
		super();
		this.tipo = tipo;
		this.producto = producto;
	}

	public TipoEventoProducto getTipo() {
		return tipo;
	}

	public void setTipo(TipoEventoProducto tipo) {
		this.tipo = tipo;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "EventoProducto [tipo=" + tipo + ", producto=" + producto + "]";
	}
	
}
