package com.curso.flux_2;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;

@Component
public class Flujos {

	
	public Flux<Long> fluxNumerosAleatoriosFinito(){

		AtomicInteger contador = new AtomicInteger(0);
		Flux<Long> flujo = Flux.generate( 
				//Generator
				sink -> {
					System.out.println(Thread.currentThread().getName()+"-Generando numero aleatorio...");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}	
					
					sink.next(Math.round(Math.random()*10_000));
					if(contador.incrementAndGet() == 10) {
						//Indicamos al subscriptor que hemos terminado
						sink.complete();
					}
				});

		return flujo;
	}
		
	public Flux<String> flujoConEstado(){
		Flux<String> flux = Flux.generate(
			//State supplier
			() -> 1,
			//Generator
			(state, sink) -> {

				sink.next("Mensaje nº:"+state);
				state++;
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(state == 11) {
					sink.complete();
				}
				
				return state;
			}
		);		
		return flux;
	}
	
}





