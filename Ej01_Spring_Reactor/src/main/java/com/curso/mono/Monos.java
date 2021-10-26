package com.curso.mono;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class Monos {

	public String saludo() {
		return "Hola que tal";
	}
	
	public Mono<String> saludoMono(){
		return Mono.just("Hola que tal, no tendrás un platano, no?");
	}
	
}
