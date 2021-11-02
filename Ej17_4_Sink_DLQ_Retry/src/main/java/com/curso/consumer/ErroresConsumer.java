package com.curso.consumer;

import java.util.function.Consumer;

import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.Pedido;

@Component
public class ErroresConsumer implements Consumer<Pedido>{

	private boolean fallo = true;
	
	@Override
	public void accept(Pedido pedido) {
		
		System.out.println("ERROR RECIBIDO DE PEDIDOS-DLQ");
		System.out.println(pedido);
		
	}

}
