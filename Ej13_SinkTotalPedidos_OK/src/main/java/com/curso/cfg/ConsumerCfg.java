package com.curso.cfg;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.curso.modelo.entidad.Pedido;

@Configuration
public class ConsumerCfg {
	
	private static Double total = 0d;
	
	@Bean
	//spring.cloud.stream.bindings.totalPedidosConsumer-in-0.destination=pedidos
	Consumer<Pedido> totalPedidosConsumer(){
		return p -> {
			System.out.println("Recibido el pedido: "+p);
			
			total += p.getCantidad()*p.getPrecio();
			System.out.println("Total: "+total);
		};
	}	

}













