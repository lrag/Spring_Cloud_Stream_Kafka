package com.curso.productor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
public class ProductorMensaje {

	@Autowired
	private StreamBridge streamBridge;
	
	public void emitirMensaje(String texto) {
		streamBridge.send("topic-mensajes-tx", texto);
	}	
	
}
