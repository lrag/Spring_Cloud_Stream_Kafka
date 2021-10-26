package com.curso.cfg;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.curso.modelo.entidad.DetalleConsumo;

import reactor.core.publisher.Flux;

@Configuration
public class Configuracion {

	//spring.cloud.stream.bindings.detalleConsumoConsumer-in-0.destination=consumo
	@Bean
	Consumer<Flux<DetalleConsumo>> detalleConsumoConsumer(){		
		Consumer<DetalleConsumo> consumidor = detalle -> System.out.println("DetalleConsumo recibido (Flux): "+detalle.getUserId()+","+detalle.getDuration());
		return flujo -> flujo.subscribe(consumidor);
	}
	
}
