package com.curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.modelo.entidad.Pedido;
import com.curso.productor.ProductorPedidos;

@Service
public class GestorPedidos {

	@Autowired
	private ProductorPedidos productorPedidos; //Supplier
	
	@Autowired
	private StreamBridge streamBridge;

	//ROLLBACK_FOR!!!!!!!!!!!!
	@Transactional(rollbackFor = Throwable.class)
	public void enviarPedidos() {
		
		System.out.println("GestorPedidos.enviarPedidos:"+Thread.currentThread().getName());
		
		/*
		Pedido p1 = new Pedido("CLIENTE-1","PRODUCTO-1",10);
		Pedido p2 = new Pedido("CLIENTE-2","PRODUCTO-2",20);
		Pedido p3 = new Pedido("CLIENTE-3","PRODUCTO-3",30);
		Pedido p4 = new Pedido("CLIENTE-4","PRODUCTO-4",40);
		Pedido p5 = new Pedido("CLIENTE-5","PRODUCTO-5",50);		
		
		//Cuidado porque aqui no estamos enviando el mensaje
		//El hilo que ejecuta el 'get' del supplier no es el mismo que está ejecutando el codigo de este método (emviarPedidos)
		//Los mensajes enviados por otros hilos no se verán afectados por la transacción asociada al hilo 'main'
		productorPedidos.enviarPedido(p1);
		productorPedidos.enviarPedido(p2);
		productorPedidos.enviarPedido(p3);
		productorPedidos.enviarPedido(p4);
		productorPedidos.enviarPedido(p5);
		*/
		
		Pedido p11 = new Pedido("CLIENTE-11","PRODUCTO-11",110);
		Pedido p22 = new Pedido("CLIENTE-22","PRODUCTO-22",220);
		Pedido p33 = new Pedido("CLIENTE-33","PRODUCTO-33",330);
		Pedido p44 = new Pedido("CLIENTE-44","PRODUCTO-44",440);
		Pedido p55 = new Pedido("CLIENTE-55","PRODUCTO-55",550);			
		
		//Con stream bridge podemos indicar el nombre del tipoc directamente
		//(con esto tenemos topics dinámicos)		
		//streamBridge.send("topic-pedidos-rollback", p11);
		//streamBridge.send("topic-pedidos-rollback", p12);
		//streamBridge.send("topic-pedidos-rollback", p13);
		//streamBridge.send("topic-pedidos-rollback", p14);
		//streamBridge.send("topic-pedidos-rollback", p15);
		
		//Tambien, si lo tenemos definido, podemos indicar un binding:		
		streamBridge.send("productorPedidos-out-0", p11);
		streamBridge.send("productorPedidos-out-0", p22);
		streamBridge.send("productorPedidos-out-0", p33);
		streamBridge.send("productorPedidos-out-0", p44);
		streamBridge.send("productorPedidos-out-0", p55);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Por defecto spring solo hará rollback si se ha lanzado una runtima exception
		throw new RuntimeException("ZASCA!");
	}
	
}
