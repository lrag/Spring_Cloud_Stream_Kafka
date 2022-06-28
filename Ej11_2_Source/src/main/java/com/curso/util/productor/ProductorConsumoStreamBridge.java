package com.curso.util.productor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.DetalleConsumo;

@Component
public class ProductorConsumoStreamBridge {

	@Autowired
	private StreamBridge streamBridge;
	
	//Esto nos permite enviar mensajes del mismo modo que si estuvieramos usando las 'Templates'
	public void enviar(DetalleConsumo detalleConsumo) {
		System.out.println("Enviando ProductorDetalleConsumo: "+detalleConsumo);
		streamBridge.send("topic-consumo-1", detalleConsumo);
	}
	
}
