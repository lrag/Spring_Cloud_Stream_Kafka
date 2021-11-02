package com.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.curso.modelo.entidad.Pedido;
import com.curso.productor.ProductorPedidos;

@SpringBootApplication
@EnableTransactionManagement
public class Aplicacion implements CommandLineRunner{
	
	@Autowired
	private ApplicationContext appCtx;
	
	@Autowired
	private ProductorPedidos productorPedidos;

	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Thread.sleep(2000);
		System.out.println("==============================");
		System.out.print("Inicializando");
		for(int a=0; a<7; a++){
			System.out.print(".");
			Thread.sleep(1000);
		}
		System.out.println();
		
		Pedido p1 = new Pedido("CLIENTE-1-Retry","PRODUCTO-1",10);
		productorPedidos.enviarPedido(p1);
		Thread.sleep(5000);
		Pedido p2 = new Pedido("CLIENTE-2-Retry","PRODUCTO-2",20);
		productorPedidos.enviarPedido(p2);
		Thread.sleep(5000);
		Pedido p3 = new Pedido("CLIENTE-3-Retry","PRODUCTO-3",30);
		productorPedidos.enviarPedido(p3);
		Thread.sleep(5000);

		Thread.sleep(20_000);
		SpringApplication.exit(appCtx, () -> 0);

	}


}
