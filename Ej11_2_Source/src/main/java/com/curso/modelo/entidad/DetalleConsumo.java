package com.curso.modelo.entidad;

public class DetalleConsumo {

	private String userId;
	private long duration;
	private long data;

	public DetalleConsumo() { }
	
	public DetalleConsumo(String userId, long duration, long data) {
		super();
		this.userId = userId;
		this.duration = duration;
		this.data = data;
	}

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

	@Override
	public String toString() {
		return "DetalleConsumo [userId=" + userId + ", duration=" + duration + ", data=" + data + "]";
	}
	
}