package com.curso.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.modelo.entidad.Pedido;
import com.curso.productor.ProductorPedidos;

@RestController
public class PedidosRest {

	@Autowired
	private ProductorPedidos productorPedidos;
	
	@PostMapping(path="/pedidos")
	public ResponseEntity<Void> insertar(@RequestBody Pedido pedido){
		productorPedidos.enviarPedido(pedido);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);		
	}
	
}
