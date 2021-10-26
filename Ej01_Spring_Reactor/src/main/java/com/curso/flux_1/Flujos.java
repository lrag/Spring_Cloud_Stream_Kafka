package com.curso.flux_1;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class Flujos {

	//Imperativo
	public List<String> listarPalabras(){
		List<String> palabras = Arrays.asList("HELLO", "DOCTOR", "NAME", "CONTINUE", "YESTERDAY", "TOMORROW");
		return palabras;
	}

	//Reactivo
	public Flux<String> listarPalabras_Reactivo() {
		//Un flujo para el cual ya tenemos los elementos
		Flux<String> stringFlux = Flux.just("HELLO", "DOCTOR", "NAME", "CONTINUE", "YESTERDAY", "TOMORROW");
		return stringFlux;
	}

}
