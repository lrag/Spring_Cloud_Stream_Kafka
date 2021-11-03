package com.curso.productor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.Pedido;

@Component
public class ProductorPedidos implements Supplier<Pedido>{

	private BlockingQueue<Pedido> cola = new LinkedBlockingQueue<>();
	
	public void enviarPedido(Pedido pedido) {	
		System.out.println("Recibido el pedido vía HTTP:"+pedido);
		cola.offer(pedido);
	}

	@Override
	public Pedido get() {
		Pedido pedido = null;
		try {
			pedido = cola.take();
		} catch (InterruptedException e) {
			System.out.println("==================================================");
			System.out.println("TAKE");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return pedido;
	}
	
}
