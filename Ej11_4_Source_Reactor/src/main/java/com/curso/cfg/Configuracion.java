package com.curso.cfg;

import java.time.Duration;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.curso.modelo.entidad.DetalleConsumo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;
import reactor.core.scheduler.Schedulers;

@Configuration
public class Configuracion {

	//spring.cloud.stream.bindings.detalleConsumoSupplierFlux-out-0.destination=consumo
	@Bean
	Supplier<Flux<DetalleConsumo>> detalleConsumoSupplier(){		

		Flux<DetalleConsumo> flujo = Flux.generate(new Consumer<SynchronousSink<DetalleConsumo>>() {
			private int contador;
			private String[] users = { "user10", "user20", "user30", "user40", "user50" };			

			public void accept(SynchronousSink<DetalleConsumo> sink) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					//Nada
				}
				DetalleConsumo detalleConsumo = new DetalleConsumo();
				detalleConsumo.setUserId(this.users[new Random().nextInt(5)]);
				detalleConsumo.setDuration(++contador);
				detalleConsumo.setData(new Random().nextInt(700));
				System.out.println("Enviando detalleConsumo supplier (Flux): "+detalleConsumo);				
				sink.next(detalleConsumo);
			}
		}).subscribeOn(Schedulers.boundedElastic()).share();		
		
		return new Supplier<Flux<DetalleConsumo>>() {
			public Flux<DetalleConsumo> get() {
				return flujo;
			}
		};

	}
	
}






