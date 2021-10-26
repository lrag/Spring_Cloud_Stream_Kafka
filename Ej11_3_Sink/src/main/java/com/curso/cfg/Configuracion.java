package com.curso.cfg;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.curso.modelo.entidad.DetalleConsumo;

@Configuration
public class Configuracion {

	//spring.cloud.stream.bindings.detalleConsumoConsumer-in-0.destination=topic-consumo
	@Bean
	Consumer<DetalleConsumo> detalleConsumoConsumer(){
		return t -> System.out.println("DetalleConsumo recibido: "+t.getUserId()+","+t.getDuration());
	}
	
}
