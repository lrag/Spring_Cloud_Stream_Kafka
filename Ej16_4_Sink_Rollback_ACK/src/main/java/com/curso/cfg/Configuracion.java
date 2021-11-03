package com.curso.cfg;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.messaging.Message;

import com.curso.modelo.entidad.Pedido;

@Configuration
public class Configuracion {

	@Bean
	Consumer<Message<Pedido>> pedidosConsumer(Environment environment){	
		return m -> {
			System.out.println("Pedido recibido: ("+environment.getProperty("local.server.port")+") "+m.getPayload());
		};
	}
	
}

