package com.curso;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.modelo.entidad.DetalleConsumo;
import com.curso.productor.ProductorConsumoStreamBridge;

@SpringBootApplication
public class Aplicacion implements CommandLineRunner{

	@Autowired
	private ProductorConsumoStreamBridge productorConsumo;
	
	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
		
		/*
		
		//
		// Supplier: objeto que entrega algo al que lo pide
		//
		Supplier<String> productor_1 = new Supplier<String>() {
			@Override
			public String get() {
				return "Hola "+LocalDateTime.now();
			}
		};
		
		Supplier<String> productor_2 = () -> "Hola "+LocalDateTime.now();
		
		System.out.println(productor_1.get());
		System.out.println(productor_1.get());
		System.out.println(productor_1.get());
		System.out.println(productor_2.get());
		System.out.println(productor_2.get());
		System.out.println(productor_2.get());
		
		//
		//Consumer: objeto al que se envía algo
		//
		Consumer<String> consumidor_1 = new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}		
		};
		
		Consumer<String> consumidor_2 = (s)-> System.out.println(s);
		
		consumidor_1.accept("HOLA");
		consumidor_1.accept("QUE");
		consumidor_1.accept("TAL");
		consumidor_2.accept("MUY");
		consumidor_2.accept("BIEN");
		consumidor_2.accept("CON OKAL");
		
		//
		//Function: objeto al que se se envía algo para obtener otra cosa a cambio
		//No tiene por que ser otra cosa de un tipo distinto
		//
		Function<String, Integer> cuentaLetras_1 = new Function<String, Integer>() {
			@Override
			public Integer apply(String t) {
				return t.length();
			}
		};
		
		Function<String, Integer> cuentaLetras_2 = texto -> texto.length();
		
		System.out.println(cuentaLetras_1.apply("Siete caballos vienen de Bonanza"));
		System.out.println(cuentaLetras_2.apply("Siete caballos vienen de Bonanza"));
		*/
	
	}

	@Override
	public void run(String... args) throws Exception {
		
		DetalleConsumo dc1 = new DetalleConsumo("CLI-1",100,100);
		DetalleConsumo dc2 = new DetalleConsumo("CLI-2",200,200);
		DetalleConsumo dc3 = new DetalleConsumo("CLI-3",300,300);
		DetalleConsumo dc4 = new DetalleConsumo("CLI-4",400,400);
		DetalleConsumo dc5 = new DetalleConsumo("CLI-5",500,500);
		
		productorConsumo.enviar(dc1);
		productorConsumo.enviar(dc2);
		productorConsumo.enviar(dc3);
		productorConsumo.enviar(dc4);
		productorConsumo.enviar(dc5);
		
	}

}


