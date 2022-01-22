package com.curso;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.curso.modelo.entidad.Pedido;

@SpringBootApplication
public class Aplicacion {

	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}
	
	@Bean
	//Topics a los que queremos que spring cloud stream se conecte
	//spring.cloud.stream.bindings.input.destination=clientes
	//spring.cloud.stream.bindings.output.destination=clientesProcesados
	//Asignacion de topics a la funcion
	//spring.cloud.stream.bindings.mayusculasFunction-in-0.destination=clientes
	//spring.cloud.stream.bindings.mayusculasFunction-out-0.destination=clientesProcesados
	public Function<Pedido, Pedido> mayusculasFunction(){
		
		return p -> {
			System.out.println("Procesando pedido: "+p);

			return p;
		};
		
	}	
	
}
