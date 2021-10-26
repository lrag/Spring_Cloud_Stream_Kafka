package com.curso.consumidor;

import java.util.function.Consumer;

import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.DetalleConsumo;

//@Component
public class ConsumidorDetalleConsumo implements Consumer<DetalleConsumo>{

	@Override
	public void accept(DetalleConsumo t) {	
		System.out.println("DetalleConsumo recibido (ConsumidorDetalleConsumo): "+t.getUserId()+","+t.getDuration());		
	}
	
}
