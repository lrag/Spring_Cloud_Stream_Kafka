package com.curso.flux_4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.Pelicula;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Component
public class Flujos {
	
	public Flux<Integer> numerosPares(){
		return Flux.generate(
				//State supplier
				() -> 0,
				//Generator
				(state,sink) -> {					
					sink.next(state);					
					long fin = System.currentTimeMillis()+1000;
					while(System.currentTimeMillis()<fin) {
					}
					state +=2;
					if(state > 12) {
						sink.complete();
					}					
					return state;
				}				
			);
	}

	public Flux<Integer> numerosImpares(){
		return Flux.generate(
				//State supplier
				() -> 1,
				//Generator
				(state,sink) -> {					
					sink.next(state);					
					long fin = System.currentTimeMillis()+1000;
					while(System.currentTimeMillis()<fin) {
					}
					state +=2;
					if(state > 13) {
						sink.complete();
					}					
					return state;
				}				
			);
	}	
	
	public Flux<String> flujoPalabras() {		
		String[] palabras = {"Dice","que…","la","parte","contratante","de","la","primera","parte","será","considerada","como","la","parte","contratante","de","la","primera","parte."};		
		return Flux.generate(
				//State supplier
				() -> 0,
				//Generator
				(state,sink) -> {					
					sink.next(palabras[state]);					
					try {
						Thread.sleep(palabras[state].length()*30);
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}					
					state++;
					if(state == palabras.length) {
						sink.complete();
					}					
					return state;
				}				
			);
	}	
	
	public Mono<String> leerFichero(String fichero){
		Mono<String> mono = Mono.create( 
				sink -> {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					sink.success("contenido del fichero");
				}
			);
		return mono;
	}
	
	public Mono<String> escribirFichero(String fichero, String contenido){
		Mono<String> mono = Mono.create( 
				sink -> {
					System.out.println("Escribiendo el fichero...");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Fichero escrito");
					sink.success();
				}
			);
		return mono;
	}	
	
	public Mono<String> convertirImagen(String imagen){
		Mono<String> mono = Mono.create( 
				sink -> {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					sink.success(imagen.toUpperCase());
				}
			);
		return mono;
	}
		
}
