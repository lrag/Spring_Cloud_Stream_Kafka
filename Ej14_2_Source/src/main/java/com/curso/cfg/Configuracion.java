package com.curso.cfg;

import java.util.Random;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.curso.modelo.entidad.DetalleConsumo;

@Configuration
public class Configuracion {

	//spring.cloud.stream.bindings.detalleConsumoSupplierFlux-out-0.destination=consumo
	@Bean
	Supplier<DetalleConsumo> detalleConsumoSupplier(){		

		return new Supplier<DetalleConsumo>() {
			private int contador;
			private String[] users = { "user10", "user20", "user30", "user40", "user50" };			
			
			public DetalleConsumo get() {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					//Nada
				}
				DetalleConsumo detalleConsumo = new DetalleConsumo();
				detalleConsumo.setUserId(this.users[new Random().nextInt(5)]);
				detalleConsumo.setDuration(++contador);
				detalleConsumo.setData(new Random().nextInt(700));
				System.out.println("Enviando detalleConsumo supplier: "+detalleConsumo);
				return detalleConsumo;
			}
		};

	}
	
}






