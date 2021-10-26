package com.curso.flux_1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class Aplicacion implements CommandLineRunner{

	@Autowired
	private Consumidor consumidor;
	
	@Autowired
	private Flujos flujos;

	@Autowired
	private Monos monos;	
	
	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("=====================================");
		List<String> palabras = flujos.listarPalabras();	
		palabras.forEach( p -> System.out.println(p));
		
		System.out.println("=====================================");
		
		//Flujo y Mono heredan de Publisher
		
		//Un flujo no se 'recorre' como si fuera una colección
		//Nos subscribimos a un flujo para recibir los elementos
		//Se proporciona un consumidor, que recibirá los elementos que componen el flujo
		//Es tarea del consumidor controlar el ritmo con el que procesan los elementos
		//Es tarea del flujo controlar el ritmo con el que se entregan los elementos
		
		//
		//Proporcionando un consumidor definido en el momento de la subscripción:
		//En este caso el mismo hilo que se subscribe ejecuta el código del consumidor
		//
		Flux<String> flujoPalabras = flujos.listarPalabras_Reactivo();
		System.out.println(Thread.currentThread().getName()+"-Antes de subscribirse");
		flujoPalabras
			.subscribe( new Consumer<String>() {
				public void accept(String s) {
					System.out.println(Thread.currentThread().getName()+"-"+s);
				}
			});
		System.out.println(Thread.currentThread().getName()+"-Despues de subscribirse");
		
		System.out.println("=====================================");
		//Ídem con expresión lambda
		//Vemos que podemos volver a subscribirnos a un flujo		
		flujoPalabras.subscribe( s -> System.out.println(Thread.currentThread().getName()+"-Lambda-"+s));
		//AQUI NO TENEMOS LAS PALABRAS
		
		System.out.println("=====================================");		
		//Utilizando un consumidor definido como una bean de spring
		flujoPalabras.subscribe(consumidor);

		///////////
		// MONOS //
		///////////
		
		System.out.println("=====================================");
		String saludo_1 = monos.saludar();
		System.out.println(saludo_1);
		
		monos
			.saludar_reactivo()
			.subscribe(saludo -> System.out.println(saludo));
		//Aqui no tenemos el saludo
		
		System.exit(0);

		System.out.println("=====================================");			
		//Podemos utilizar block en monos y nos devuelven el elemento emitido
		//Usar solo en caso de extrema necesidad
		
		String saludo_2 = monos.saludar_reactivo().block();
		System.out.println("Despues del block: "+saludo_2);

		System.out.println("FIN del hilo main");
	}

}

