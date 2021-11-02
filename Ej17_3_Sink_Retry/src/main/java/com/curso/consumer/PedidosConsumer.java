package com.curso.consumer;

import java.util.function.Consumer;

import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.Pedido;

@Component
public class PedidosConsumer implements Consumer<Pedido>{

	private boolean fallo = true;
	
	@Override
	public void accept(Pedido pedido) {
		
		/*
		fallo = !fallo;
		if(fallo) {
			System.out.println("FALLO!!!");
			throw new RuntimeException("Fallo al procesar el pedido");
		}
		System.out.println("Pedido recibido: "+pedido);
		*/

		System.out.println("FALLO!!! ("+pedido+")");
		throw new RuntimeException("Fallo al procesar el pedido");
		
	}

}
