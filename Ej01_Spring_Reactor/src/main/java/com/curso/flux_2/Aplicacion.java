package com.curso.flux_2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.modelo.entidad.Pelicula;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class Aplicacion implements CommandLineRunner{

	@Autowired
	private PeliculaRepository peliculaRepo;
	
	@Autowired
	private Flujos flujos;
	
	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		System.out.println("=====================================");
		Flux<Long> flujoFinito = flujos.fluxNumerosAleatoriosFinito();
		flujoFinito.subscribe(numero -> {
			System.out.println(Thread.currentThread().getName()+"-Consumidor:"+numero);
		});
		
		System.out.println("=====================================");
		Flux<String> flujoEstado = flujos.flujoConEstado();
		flujoEstado.subscribe(mensaje -> System.out.println(mensaje));
		
		 */
		System.out.println("=============================================");
		List<Pelicula> peliculas = peliculaRepo.findAll();
		for(Pelicula p: peliculas) {
			System.out.println(p);
		}
		
		Thread.sleep(1000);

		System.out.println("=============================================");
		peliculaRepo.findAll_Reactivo().subscribe( p -> System.out.println(p));	
		
		System.out.println("FIN del hilo main");
	}

}
