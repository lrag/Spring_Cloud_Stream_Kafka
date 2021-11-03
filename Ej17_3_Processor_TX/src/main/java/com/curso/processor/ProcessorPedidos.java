package com.curso.processor;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.curso.modelo.entidad.OrdenCompra;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.negocio.GestorPedidos;

//@Component
public class ProcessorPedidos implements Function<Pedido, OrdenCompra>{

	@Autowired
	private GestorPedidos gestorPedidos;
	
	@Override
	//Este transactional, aqui, lograría el mismo efecto que el que está en GestorPedidos.aceptarPedido
	//PERO en el fondo en un supplier/function/consumer hay lógica de control y aqui está prohibida esta anotación
	//@Transactional
	public OrdenCompra apply(Pedido pedido) {
		System.out.println("Procesando el pedido:"+pedido);
		return gestorPedidos.aceptarPedido(pedido);
	}
	
}
