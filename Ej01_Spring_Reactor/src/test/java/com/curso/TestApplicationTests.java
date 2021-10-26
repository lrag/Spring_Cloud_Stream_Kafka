package com.curso;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest( classes = com.curso.flux_2.Flujos.class )
class TestApplicationTests {

	@Autowired
	//Este es el objeto real que queremos probar
	com.curso.flux_2.Flujos flujos2;

	@Test
	void testFlujo() {

		//Cuando 
		Flux<String> f = flujos2.flujoConEstado();
		
		//Entonces
		StepVerifier
			.create(f)
			.expectNext("Mensaje nº:1")
			.expectNextMatches(mensaje -> mensaje.endsWith(":2"))
			.expectNext("Mensaje nº:3","Mensaje nº:4")
			.expectNext("Mensaje nº:5")
			.expectNext("Mensaje nº:6")
			.expectNext("Mensaje nº:7")
			.expectNext("Mensaje nº:8")
			.expectNext("Mensaje nº:9")
			.expectNext("Mensaje nº:10")
			.verifyComplete();
		
	}

}