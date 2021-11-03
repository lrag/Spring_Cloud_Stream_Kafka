package com.curso.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.modelo.entidad.Comando;
import com.curso.productor.ProductorComandos;

@RestController
public class ComandosRest {

	@Autowired
	private ProductorComandos productorComandos;
	
	@PostMapping(path="/pedidos")
	public ResponseEntity<Void> insertar(@RequestBody Comando comando){
		productorComandos.enviarComando(comando);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);		
	}
	
}
