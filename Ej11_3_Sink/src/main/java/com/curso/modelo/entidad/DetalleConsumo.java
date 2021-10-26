package com.curso.modelo.entidad;

public class DetalleConsumo {

	private String userId;
	private long duration;
	private long data;

	public DetalleConsumo() { }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public long getData() {
		return data;
	}

	public void setData(long data) {
		this.data = data;
	}

}