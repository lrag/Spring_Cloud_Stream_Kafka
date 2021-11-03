package com.curso.cfg;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.messaging.Message;

import com.curso.modelo.entidad.Comando;

@Configuration
public class Configuracion {

	@Bean
	Consumer<Message<Comando>> pedidosConsumer(Environment environment){	
		return m -> {
			System.out.println("==========================================================");
			System.out.println("Mensaje recibido: ("+environment.getProperty("local.server.port")+") ");
            System.out.println(m.getPayload());
            System.out.println(m.getHeaders().entrySet());
            System.out.println(m.getHeaders().get("kafka_receivedPartitionId"));
		};
	}
	
}

