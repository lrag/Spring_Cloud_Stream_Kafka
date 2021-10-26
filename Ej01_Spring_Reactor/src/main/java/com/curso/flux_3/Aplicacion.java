package com.curso.flux_3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@SpringBootApplication
public class Aplicacion implements CommandLineRunner{

	@Autowired
	private Flujos flujos;
	
	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Flux<Long> flujoInfinito = flujos.fluxNumerosAleatoriosInfinito();
		
		//Si nos subscribimos a un flujoInfinito y no tenemos cuidad con cuál hilo
		//ejecutara el código del consumer nos quedaremos bloqueados procesando
		//los elementos del flujo
		//
		//System.out.println("=====================================");
		//System.out.println(Thread.currentThread().getName()+"-Antes de subscribirse");
		//flujoInfinito.subscribe(numero -> System.out.println(Thread.currentThread().getName()+"-"+numero));
		//System.out.println("Aqui ya no llega :(");

		//System.out.println("=====================================");
		//System.out.println(Thread.currentThread().getName()+"-Antes de subscribirse");
		//flujoInfinito
		//	.subscribeOn(Schedulers.boundedElastic())
		//	.subscribe( numero -> System.out.println(Thread.currentThread().getName()+"-"+numero));
		//System.out.println(Thread.currentThread().getName()+"-Despues de subscribirse");
		
		//
		//Sin este thread.sleep la aplicación finaliza. El hilo que se queda procesando los elementos del flujo
		//no tiene peso suficiente para mantenerla viva
		//Thread.sleep(20_000);
		
		////////////////
		// DISPOSABLE //
		////////////////
		
		/*System.out.println("=====================================");
		//Cancelando una subscripcion a un flujo
		System.out.println(Thread.currentThread().getName());
		Disposable d = 
			flujoInfinito
			.subscribeOn(Schedulers.boundedElastic())
			.subscribe(l -> {
				System.out.println(Thread.currentThread().getName()+":"+l);
			});		
		
		Thread.sleep(4_000);
		System.out.println("Cancelando la subscripción");
		d.dispose();
		Thread.sleep(2_000);*/
		
		/*
		System.out.println("=====================================");
		//El flujo entrega un elemento cada segundo, pero el consumidor que proporciona el subscriptor
		//tarda dos en procesarlo.
		//Vemos que no se pierde ningún elemento
		Disposable d2 = flujos
			.fluxInterval()
			//.subscribeOn(Schedulers.boundedElastic())
			.subscribe( numero -> {
				System.out.println(numero);
				long fin = System.currentTimeMillis()+2000;
				while(System.currentTimeMillis()<fin) {
					//Procesando...
				}
			});	

		Thread.sleep(5_000);
		
		System.out.println("=====================================");
		System.out.println("Ficheros (y procesando el flujo anterior en paralelo)");
		Flux<List<String>> eventosDirectorio = flujos.monitorizarDirectorio();
		Disposable d3 = eventosDirectorio
			.subscribeOn(Schedulers.boundedElastic())
			.subscribe(mensaje -> System.out.println(mensaje));
		
		Thread.sleep(30_000);

		d3.dispose();		
		d2.dispose();
		*/
		
		//////////////
		// PARALLEL //
		//////////////
		
		//
		//Si necesitamos que los elementos del flujo se procesen en paralelo:
		//
		/*
		System.out.println("=====================================");
		System.out.println("Parallel flux");
		flujos.flujoPalabras()
			.parallel()
			.runOn(Schedulers.parallel())
			.subscribe(str -> {
				System.out.println(Thread.currentThread().getName()+" Inicio:"+str);
				long inicio = System.currentTimeMillis();
				while(System.currentTimeMillis()<inicio+4000) {
					//Estoy haciendo cosas
				}
				System.out.println(Thread.currentThread().getName()+"    Fin:"+str);
			});		
		
		Thread.sleep(10_000);
		*/
		
		System.out.println("=====================================");
		//En este ejemplo es el flujo el que indica que el consumidor debe ser ejecutado por otro hilo distinto al que se subscribe
		System.out.println("Antes de subscribirse a flujoPublishOn");
		flujos.flujoPublishOn()
			.subscribe(s -> System.out.println(Thread.currentThread().getName()+":"+s));
		System.out.println("Después de subscribirse a flujoPublishOn");
		
		Thread.sleep(5000);	
		
		System.out.println("FIN del hilo main");		
		
	}

}
