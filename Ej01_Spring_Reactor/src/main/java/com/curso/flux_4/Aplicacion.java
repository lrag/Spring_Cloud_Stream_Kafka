package com.curso.flux_4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.modelo.entidad.Pelicula;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@SpringBootApplication
public class Aplicacion implements CommandLineRunner{

	@Autowired
	private Flujos flujos;
	
	@Autowired
	private PeliculaRepository peliculaRepo;

	@Autowired
	private PremioRepository premioRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		////////////
		// CONCAT //
		////////////
		/*
		System.out.println("======================================");
		Flux.concat(
				//Primero se subscriben a este flujo y lo consumen entero
				flujos.numerosPares().subscribeOn(Schedulers.boundedElastic()),
				//Luego se subscriben a este
				flujos.numerosImpares().subscribeOn(Schedulers.boundedElastic())
			)
			.subscribe( n -> System.out.println(n) );
		
		Thread.sleep(10_000);

		System.out.println("======================================");
		//Tambien podemos concatenar vários monos para obtener un flujo
		Flux.concat(
				peliculaRepo.findById(1), 
				peliculaRepo.findById(2), 
				peliculaRepo.findById(3)
			)
			.subscribe(p -> System.out.println(p));
		
		System.out.println("======================================");
		peliculaRepo
			.findAllById(Arrays.asList(1,2,3))
			.subscribe( p -> System.out.println( "peliculaRepo.findAllById:"+p));
		*/
		
		///////////
		// MERGE //
		///////////
		
		/*
		System.out.println("======================================");
		Flux.merge(
				flujos.numerosPares().subscribeOn(Schedulers.boundedElastic()), 
				flujos.numerosImpares().subscribeOn(Schedulers.boundedElastic())
			)
			.subscribe( n -> System.out.println(n));
		
		Thread.sleep(10_000);
		*/
		
		
		////////////
		// FILTER //
		////////////

		/*
		System.out.println("======================================");		
		peliculaRepo
			.findAll()
			.filter(p -> p.getGenero().equals("Ci-fi"))
			//Se pueden concatenar más filtros
			.filter(p -> p.getTitulo().length()>4)
			.subscribe(p -> System.out.println(p));	
		*/
		
		
		/////////
		// MAP //
		/////////
		/*
		System.out.println("======================================");
		flujos
			.flujoPalabras()
			.subscribe( palabra -> System.out.println(palabra));

		System.out.println("======================================");
		flujos
			.flujoPalabras()
			//Llega la palabra, sale su longitud...
			//.map( p -> p.length() )
			.map( p -> p.toUpperCase())
			.subscribe(palabra -> System.out.println(palabra));
		
		System.out.println("======================================");
		flujos
			.flujoPalabras()
			.map( palabra -> palabra.toUpperCase() )
			.map( palabra -> palabra.length()+"-"+palabra)
			.subscribe( palabra -> System.out.println(palabra));		
		
		System.out.println("======================================");
		//Lo mismo pero sin 'map'
		flujos
			.flujoPalabras()
			.subscribe( palabra -> System.out.println(palabra.length()+":"+palabra.toUpperCase()));		
		*/
		
		
		//////////////
		// FLAT MAP //
		//////////////
		
		System.out.println("======================================");
		//leer un fichero imagen
		//transformar el contendio en otro formato
		//crear un nuevo fichero con la imagen resultante
		
		//Con callback hell el código es un infierno
		//Además, como nos subscribimos a los flujos/monos no podemos devolvelos
		//Y probablemente tampoco podamos devolver el resultado si el código está en un método
		/*
		flujos
			.leerFichero("imagen.jpg")
			.subscribeOn(Schedulers.boundedElastic())
			.subscribe( contenido -> {
				System.out.println("Contenido:"+contenido);
				flujos
					.convertirImagen(contenido)
					.subscribeOn(Schedulers.boundedElastic())
					.subscribe(nuevoFormato -> {
						System.out.println("Nuevo formato:"+nuevoFormato);
						flujos.escribirFichero(nuevoFormato, contenido)
							.subscribeOn(Schedulers.boundedElastic())
							.subscribe( c -> {
								System.out.println("Nueva imagen creada.");
							});
					});
			});
		*/
		
		flujos
			.leerFichero("imagen.jgp") //De aqui sale un mono
			.subscribeOn(Schedulers.boundedElastic())
			.flatMap( contenido -> {
				System.out.println("Contenido:"+contenido);
				return flujos
					.convertirImagen(contenido)
					.subscribeOn(Schedulers.boundedElastic()); //Esto devuelve un Mono<String> 
			})
			.flatMap( nuevoFormato -> {
				System.out.println("Nuevo formato:"+nuevoFormato);
				return flujos
					.escribirFichero("", "")
					.subscribeOn(Schedulers.boundedElastic());
			})
			.doOnSuccess( x-> System.out.println("IMAGEN CONVERTIDA") )
			.subscribe();

		///////////////////
		// FLAT MAP MANY //
		///////////////////			
		
		System.out.println("======================================");		
		peliculaRepo
			.findById(3) //De aqui sale un Mono en patines
			.flatMapMany( p -> { //Aqui llega la pelicula
				return premioRepo.findAllByIdPelicula(p.getId()); //De aqui sale un FLUX!
			})
			.subscribe(premio -> System.out.println(premio));			
		
		Thread.sleep(10_000);
		System.exit(0);
		
		
		/////////////
		// COLLECT //
		/////////////
		
		System.out.println("======================================");		
		flujos
			.flujoPalabras()
			.collect(Collectors.toList())
			.subscribe(lista -> System.out.println(lista));
		
		peliculaRepo
			.findAll()
			.collect(Collectors.groupingBy( pelicula -> pelicula.getGenero()))
			.subscribe( mapa -> {
				mapa.forEach( (clave,valor) -> System.out.println(clave+":"+valor) );
			});
		
		/*
		.defaultIfEmpty(valor por defecto);
		.switchIfEmpty(Mono.error(new Exception("EL AÑO NO PUEDE SER NEGATIVO!")));
		*/
		
	}
	
}


