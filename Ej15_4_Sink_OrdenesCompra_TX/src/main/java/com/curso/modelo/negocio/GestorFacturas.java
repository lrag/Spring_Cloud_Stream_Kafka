package com.curso.modelo.negocio;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.modelo.entidad.OrdenCompra;

@Service
public class GestorFacturas {

	@Transactional
	public void aceptarPedido(OrdenCompra ordenCompra) {
		System.out.println("Emitiendo factura a partir de la orden de compra:"+ordenCompra);
	}
	
}
