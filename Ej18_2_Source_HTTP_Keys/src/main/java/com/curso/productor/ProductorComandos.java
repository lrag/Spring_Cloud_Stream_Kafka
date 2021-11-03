package com.curso.productor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.Comando;

@Component
public class ProductorComandos implements Supplier<Message<Comando>>{

	private BlockingQueue<Comando> cola = new LinkedBlockingQueue<>();
	
	public void enviarComando(Comando comando) {	
		System.out.println("Recibido el comando vía HTTP:"+comando);
		cola.offer(comando);
	}

	@Override
	public Message<Comando> get() {
		Comando comando = null;
		try {
			comando = cola.take();
		} catch (InterruptedException e) {
			System.out.println("==================================================");
			System.out.println("TAKE");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return MessageBuilder.withPayload(comando)
			//.setHeader(KafkaHeaders.MESSAGE_KEY, comando.getCliente().getCodigo())
			.build();
	}
	
}
