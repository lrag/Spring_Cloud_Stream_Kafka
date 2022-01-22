package com.curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.curso.modelo.entidad.OrdenCompra;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.persistencia.OrdenCompraRepository;
import com.curso.modelo.persistencia.PedidoRepository;
import com.curso.productor.ProductorMensaje;

@Service
public class GestorPedidos {

	@Autowired
	private GestorPedidos proxy;
	
	@Autowired
	private ProductorMensaje productorMensaje;
	
	@Autowired private OrdenCompraRepository ordenCompraRepo;
	@Autowired private PedidoRepository pedidoRepo;
	
	@Transactional
	public OrdenCompra aceptarPedido(Pedido pedido) {

		OrdenCompra oc = new OrdenCompra(pedido);
		//Esto sería una llamada a un api RESt síncrona que estaría publicando un tal 'ServicioClientes'
		oc.setDatosBancarios("datosBancarios"+System.currentTimeMillis());
		oc.setTotal((int) Math.round((Math.random()*25))*10);
		ordenCompraRepo.save(oc);
		System.out.println("Orden de compra creada:"+oc);
		pedido.setEstado("ACEPTADO");
		
		productorMensaje.emitirMensaje("Parece que fue bien la cosa");
		productorMensaje.emitirMensaje("Vamos, creo yo");
		productorMensaje.emitirMensaje("Que podría ser que no");
		
		if(pedido.getCliente()==null) {
			System.out.println("///FALLO/////////////////////////////////");
			pedido.setEstado("RECHAZADO");
			proxy.guardarPedido(pedido);
			throw new RuntimeException("ZASCA!");
		}
		this.guardarPedido(pedido);
		
		return oc;
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void guardarPedido(Pedido pedido) {
		pedidoRepo.save(pedido);
	}
	
}
