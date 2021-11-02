package com.curso;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.curso.modelo.negocio.GestorPedidos;

@SpringBootApplication
@EnableTransactionManagement
public class Aplicacion implements CommandLineRunner, ApplicationContextAware{

	@Autowired
	private GestorPedidos gestorPedidos;
	
	@Autowired
	private ApplicationContext appCtx;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		
	}

	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Thread.sleep(2000);
		System.out.println("==============================");
		System.out.print("Inicializando");
		for(int a=0; a<5; a++){
			System.out.print(".");
			Thread.sleep(1000);
		}
		System.out.println();
		
		try {
			gestorPedidos.enviarPedidos();
		} catch (Exception e) {
			System.out.println("Error al emitir los pedidos:"+e.getMessage());
		}
		
		Thread.sleep(4000);
		SpringApplication.exit(appCtx, () -> 0);

	}


}
