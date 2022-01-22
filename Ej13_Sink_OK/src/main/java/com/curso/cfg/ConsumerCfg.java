package com.curso.cfg;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.curso.modelo.entidad.Factura;

@Configuration
public class ConsumerCfg {
	
	@Bean
	//spring.cloud.stream.bindings.facturasConsumer-in-0.destination=clientesProcesados
	Consumer<Factura> facturasConsumer(){
		return f -> {
			System.out.println("Recibida la factura: "+f);
		};
	}	

}













