package com.curso.cfg;

import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.curso.modelo.entidad.EventoProducto;
import com.curso.modelo.entidad.Fabricante;
import com.curso.modelo.entidad.Producto;
import com.curso.modelo.entidad.TipoEventoProducto;

@Configuration
public class Configuracion {

	//spring.cloud.stream.bindings.detalleConsumoSupplier-out-0.destination=topic-consumo
	@Bean
	public Supplier<EventoProducto> eventoProductoSupplier(){		

		return new Supplier<EventoProducto>() {
			public EventoProducto get() {
				System.out.println("Creando evento");
				try {
					Thread.sleep(10_000);
				} catch (Exception e) {
					//Nada
				}

				Fabricante f = new Fabricante("FAB-4", "Omni Products", "C/Falsa, 123", "123 456 789");
				Producto p = new Producto("REF-999", "Fleje", "Bla bla bla",f);
				return new EventoProducto(TipoEventoProducto.PRODUCTO_CREADO, p);
			}
		};

	}
	
}






