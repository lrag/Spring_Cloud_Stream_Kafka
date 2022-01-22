package com.curso;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.negocio.EmisorPedidos;

@SpringBootApplication
public class Aplicacion implements CommandLineRunner{

	@Autowired
	private EmisorPedidos emisorPedidos;
	
	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Pedido> pedidos = new ArrayList<>();
		pedidos.add(new Pedido("fecha1", "Cliente1", "Producto-1", 5,  10d));
		pedidos.add(new Pedido("fecha1", "Cliente1", "Producto-2", 15, 10d));
		pedidos.add(new Pedido("fecha1", "Cliente2", "Producto-3", 25, 10d));
		pedidos.add(new Pedido("fecha2", "Cliente1", "Producto-4", 5,  10d));
		pedidos.add(new Pedido("fecha2", "Cliente2", "Producto-5", 15, 10d));
		pedidos.add(new Pedido("fecha2", "Cliente3", "Producto-1", 25, 10d));
		pedidos.add(new Pedido("fecha3", "Cliente1", "Producto-2", 5 , 10d));
		pedidos.add(new Pedido("fecha3", "Cliente2", "Producto-3", 15, 10d));
		pedidos.add(new Pedido("fecha3", "Cliente3", "Producto-4", 25, 10d));
		pedidos.add(new Pedido("fecha3", "Cliente4", "Producto-5", 5,  10d));
		
		for(int a=0; a<3; a++) {
			for(Pedido p:pedidos) {
				emisorPedidos.enviarPedido(p);
				Thread.sleep(1000);
			}
		}
		
	}

}
