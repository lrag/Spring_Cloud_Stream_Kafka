package com.curso.funcion;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.Cliente;

@Component
//spring.cloud.stream.bindings.procesadorClienteMayusculas-in-0.destination=topic-clientes
//spring.cloud.stream.bindings.psrocesadorClienteMayusculas-out-0.destination=topic-clientesProcesados
public class ProcesadorClienteMayusculas implements Function<Cliente,Cliente>{

	@Override
	public Cliente apply(Cliente c) {
		System.out.println("Procesando cliente: "+c.getNombre());
		c.setNombre(c.getNombre().toUpperCase());
		c.setDireccion(c.getDireccion().toUpperCase());
		c.setTelefono(c.getTelefono().toUpperCase());
		
		return c;
	}

}
