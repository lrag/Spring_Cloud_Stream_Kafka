package com.curso.cfg;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.GestorClientes;

@Configuration
public class ConsumerCfg {
	
	@Bean
	//spring.cloud.stream.bindings.clienteConsumer-in-0.destination=clientesProcesados
	Consumer<Cliente> clienteConsumer(GestorClientes gestorClientes){
	
		/*
		return new Consumer<Cliente>() {
			@Override
			public void accept(Cliente t) {
				gestorClientes.insertarCliente(c);
			}
		};
		*/		
		
		return c -> {
			System.out.println("Recibido el cliente: "+c.getNombre());
			gestorClientes.insertarCliente(c);
		};

	}	

}


/*
//consumidorClientes
class ConsumidorClientes implements Consumer<Cliente> {
	private GestorClientes gestorClientes;
	
	@Override
	public void accept(Cliente t) {
		gestorClientes.insertarCliente(c);
	}
}

//consumidorPedidos
class ConsumidorPedidos implements Consumer<Pedido> {
	private GestorClientes gestorClientes;
	
	@Override
	public void accept(Pedido t) {
		gestorPedidos.insertarXXX(c);
	}
}


consumidorClientes-in-0

consumidorPedidos-in-0
*/




///////////////////////////////////////////////////////////////////
























