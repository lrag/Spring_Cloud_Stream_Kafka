package com.curso.modelo.entidad;

public class Comando {

	private Long timestamp;
	private String comando;
	private Cliente Cliente;

	public Comando() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comando(Long timestamp, String comando, com.curso.modelo.entidad.Cliente cliente) {
		super();
		this.timestamp = timestamp;
		this.comando = comando;
		Cliente = cliente;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getComando() {
		return comando;
	}

	public void setComando(String comando) {
		this.comando = comando;
	}

	public Cliente getCliente() {
		return Cliente;
	}

	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}

	@Override
	public String toString() {
		return "Mensaje [timestamp=" + timestamp + ", comando=" + comando + ", Cliente=" + Cliente + "]";
	}

}
