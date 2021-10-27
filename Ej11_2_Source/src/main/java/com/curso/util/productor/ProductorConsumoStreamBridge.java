package com.curso.util.productor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.DetalleConsumo;

@Component
public class ProductorConsumoStreamBridge {

	@Autowired
	private StreamBridge streamBridge;
	
	public void enviar(DetalleConsumo detalleConsumo) {
		System.out.println("Enviando ProductorDetalleConsumo: "+detalleConsumo);
		streamBridge.send("topic-consumo-1", detalleConsumo);
	}
	
}
