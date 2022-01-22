package com.curso.modelo.negocio;

import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Function;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.curso.modelo.entidad.Pedido;

public class ProcessorTotalPedidos implements Function<Pedido, Pedido>, InitializingBean, DisposableBean{

	private Double total;
	private FileWriter fw;
	
	@Override
	public Pedido apply(Pedido p) {
		total += p.getCantidad()*p.getPrecio();
		try {
			fw.write(total+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		fw = new FileWriter("d:/totalPedidos.txt");
	}

	@Override
	public void destroy() throws Exception {
		fw.close();
	}

}
