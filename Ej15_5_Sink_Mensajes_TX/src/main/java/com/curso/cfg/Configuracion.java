package com.curso.cfg;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class Configuracion {

	@Bean
	Consumer<String> pedidosConsumer(Environment environment){	
		return m -> {
			System.out.println("Mensaje recibido: ("+environment.getProperty("local.server.port")+") "+m);
		};
	}
	
}

