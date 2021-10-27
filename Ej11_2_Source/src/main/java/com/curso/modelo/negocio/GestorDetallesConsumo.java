package com.curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.modelo.entidad.DetalleConsumo;
import com.curso.util.productor.ProductorConsumoStreamBridge;

@Service
public class GestorDetallesConsumo {

	@Autowired
	private ProductorConsumoStreamBridge productorConsumo;
	
	public void insertar(DetalleConsumo detalleConsumo) {
		System.out.println("Insertando detalle consumo...");
		System.out.println("Enviando mensaje...");
		productorConsumo.enviar(detalleConsumo);
	}
	
}
