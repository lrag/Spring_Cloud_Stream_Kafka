package com.curso;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.curso.modelo.entidad.Cliente;

@SpringBootApplication
public class Aplicacion {

	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}
	
	//@Bean
	//spring.cloud.stream.bindings.mayusculasFunction-in-0.destination=topic-clientes
	//spring.cloud.stream.bindings.mayusculasFunction-out-0.destination=topic-clientesProcesados
	public Function<Cliente, Cliente> mayusculasFunction(){
		
		return c -> {
			System.out.println("Procesando cliente: "+c.getNombre());
			c.setNombre(c.getNombre().toUpperCase());
			c.setDireccion(c.getDireccion().toUpperCase());
			c.setTelefono(c.getTelefono().toUpperCase());
			return c;
		};
		
	}

}


