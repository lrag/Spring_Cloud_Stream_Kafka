package com.curso.cfg;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.messaging.Message;

import com.curso.modelo.entidad.OrdenCompra;
import com.curso.modelo.negocio.GestorFacturas;

@Configuration
public class Configuracion {

	@Autowired
	private GestorFacturas gestorFacturas;

	/*
	@Bean
	Consumer<Message<OrdenCompra>> pedidosConsumer(Environment environment){	
		Message<OrdenCompra> x = null;
		return m -> {
			System.out.println("Pedido recibido: ("+environment.getProperty("local.server.port")+") "+m.getPayload());
			gestorFacturas.aceptarPedido(m.getPayload());
		};
	}
	*/

	@Bean
	Consumer<OrdenCompra> pedidosConsumer_(Environment environment){	
		return oc -> {
			System.out.println("Pedido recibido: ("+environment.getProperty("local.server.port")+") "+oc);
			gestorFacturas.aceptarPedido(oc);
		};
	}
	
}

