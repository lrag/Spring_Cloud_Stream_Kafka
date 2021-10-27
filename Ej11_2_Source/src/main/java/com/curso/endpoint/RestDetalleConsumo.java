package com.curso.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.modelo.entidad.DetalleConsumo;
import com.curso.modelo.negocio.GestorDetallesConsumo;

@RestController
public class RestDetalleConsumo {

	@Autowired
	private GestorDetallesConsumo gestorDetallesConsumo;
	
	@PostMapping(path="/consumos")
	public ResponseEntity<Void> insertar(@RequestBody DetalleConsumo detalleConsumo){
		gestorDetallesConsumo.insertar(detalleConsumo);
		return new ResponseEntity<Void>(HttpStatus.CREATED);		
	}
	
}
