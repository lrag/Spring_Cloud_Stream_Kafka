package com.curso;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.curso.modelo.entidad.Factura;
import com.curso.modelo.entidad.Pedido;

@SpringBootApplication
public class Aplicacion {

	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}
	
	@Bean
	//Asignacion de topics a la funcion
	//spring.cloud.stream.bindings.crearFacturaFunction-in-0.destination=pedidos
	//spring.cloud.stream.bindings.crearFacturaFunction-out-0.destination=facturas
	public Function<Pedido, Factura> crearFacturaFunction(){
		
		return p -> {
			System.out.println("Procesando pedido: "+p);

			String codigo = "FRA-"+Math.round(Math.random()*10000);
			return new Factura(codigo, p.getFecha(), p.getCliente(), p.getProducto(), p.getCantidad(), p.getPrecio());
		};
		
	}	
	
}
