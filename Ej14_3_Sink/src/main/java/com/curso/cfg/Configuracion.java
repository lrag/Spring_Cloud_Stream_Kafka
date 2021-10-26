package com.curso.cfg;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.curso.modelo.entidad.DetalleConsumo;

@Configuration
public class Configuracion {

	//spring.cloud.stream.bindings.detalleConsumoConsumer-in-0.destination=consumo
	@Bean
	Consumer<DetalleConsumo> detalleConsumoConsumer(Environment environment){	
		return t -> System.out.println("DetalleConsumo recibido: ("+environment.getProperty("local.server.port")+") "+t.getUserId()+","+t.getDuration());
	}
	
}
