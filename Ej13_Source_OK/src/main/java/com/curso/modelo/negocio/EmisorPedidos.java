package com.curso.modelo.negocio;

import java.util.function.Supplier;
import org.springframework.stereotype.Component;
import com.curso.modelo.entidad.Pedido;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Component
public class EmisorPedidos implements Supplier<Flux<Pedido>>{

	private Sinks.Many<Pedido> sink = Sinks.many().multicast().onBackpressureBuffer();
	
	public void enviarPedido(Pedido pedido) {
    	System.out.println("===============================================================");
    	System.out.println("Emitiendo utilizando un sink");
		sink.tryEmitNext(pedido);
	}

	@Override
	public Flux<Pedido> get() {		
		return sink.asFlux();
	}	    
    
}