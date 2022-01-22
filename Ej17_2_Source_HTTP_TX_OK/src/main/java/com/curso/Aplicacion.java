package com.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.curso.productor.ProductorPedidos;

@SpringBootApplication
@EnableTransactionManagement
public class Aplicacion implements CommandLineRunner{

	@Autowired
	private ProductorPedidos productorPedidos;

	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		int contador = 0;
		while(true) {
			System.out.println("=================================================");
			Pedido p = new Pedido("Cliente "+contador++,"Producto 1",1);
			productorPedidos.enviarPedido(p);
			Thread.sleep(5000);
		}
		*/

	}

}
