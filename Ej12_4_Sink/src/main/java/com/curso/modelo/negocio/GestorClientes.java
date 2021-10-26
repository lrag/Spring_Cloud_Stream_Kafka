package com.curso.modelo.negocio;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.curso.modelo.entidad.Cliente;

@Service
public class GestorClientes {

    Logger logger = LoggerFactory.getLogger(GestorClientes.class);

	public void insertarCliente(Cliente cliente) {
		logger.info("Insertando cliente:"+cliente.getNombre());
		System.out.println("Insertando cliente:"+cliente.getNombre());
		
	}
	
}
