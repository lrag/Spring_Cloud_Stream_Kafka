package com.curso.productor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.Pedido;

@Component
public class ProductorPedidos implements Supplier<Pedido>{

	private BlockingQueue<Pedido> cola = new LinkedBlockingQueue<>();
	
	public synchronized void enviarPedido(Pedido pedido) {	
		cola.offer(pedido);
	}

	@Override
	public Pedido get() {
		Pedido pedido = null;
		try {
			pedido = cola.take();
			System.out.println("ProductorPedidos.get:"+Thread.currentThread().getName());
			System.out.println("Enviando pedido:"+pedido);
		} catch (InterruptedException e) {
			System.out.println("==================================================");
			System.out.println("TAKE");
			System.out.println(e.getMessage());
		}
		return pedido;
	}
	
}
