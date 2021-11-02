package com.curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.transaction.KafkaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import com.curso.modelo.entidad.OrdenCompra;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.persistencia.OrdenCompraRepository;

@Service
public class GestorPedidos {

	@Autowired
	private OrdenCompraRepository ordenCompraRepo;
	
	@Transactional
	public OrdenCompra aceptarPedido(Pedido pedido) {

		OrdenCompra oc = new OrdenCompra(pedido);
		oc.setDatosBancarios("datosBancarios"+System.currentTimeMillis());
		oc.setTotal((int) Math.round((Math.random()*25))*10);
		ordenCompraRepo.save(oc);
		System.out.println("Orden de compra creada:"+oc);
		
		if(pedido.getCliente()==null) {
			System.out.println("///FALLO/////////////////////////////////");
			throw new RuntimeException("ZASCA!");
		}
		
		return oc;
	}
	
}
