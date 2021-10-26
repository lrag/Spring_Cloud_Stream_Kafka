package com.curso.productor;

import java.util.Random;
import java.util.function.Supplier;

import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.DetalleConsumo;

@Component
public class ProductorDetalleConsumo implements Supplier<DetalleConsumo>{

	private int contador;
	private String[] users = { "user60", "user70", "user80", "user90", "user100" };			
	
	@Override
	public DetalleConsumo get() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			//Nada
		}
		DetalleConsumo detalleConsumo = new DetalleConsumo();
		detalleConsumo.setUserId(this.users[new Random().nextInt(5)]);
		detalleConsumo.setDuration(++contador);
		detalleConsumo.setData(new Random().nextInt(700));
		System.out.println("Enviando ProductorDetalleConsumo: "+detalleConsumo);
		return detalleConsumo;
	}

}
