package com.curso.cfg;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.cloud.stream.config.ListenerContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.AbstractMessageListenerContainer;
import org.springframework.kafka.listener.ErrorHandler;

@Configuration
public class Configuracion {
	
	
	@Bean
	public ListenerContainerCustomizer<AbstractMessageListenerContainer<byte[], byte[]>> customizer() {
	

		AbstractMessageListenerContainer<byte[], byte[]> c;

		//Sustituimos el error handler que hay por defecto por uno nuestro
		//SeekToCurrentErrorHandler: 
		// * An error handler that seeks to the current offset for each topic in the remaining
		// * records. Used to rewind partitions after a message failure so that it can be
		// * replayed.
		// *
		// * Construct an instance with the default recoverer which simply logs the record after
		// * {@value SeekUtils#DEFAULT_MAX_FAILURES} (maxFailures) have occurred for a
		// * topic/partition/offset, with the default back off (9 retries, no delay).
		//
		//https://stackoverflow.com/questions/68269486/spring-cloud-stream-kafka-retries-10-times-the-maxattempts
		return (container, destination, group) -> { 
			
			container.setErrorHandler(new ErrorHandler() {
				@Override
				public void handle(Exception thrownException, ConsumerRecord<?, ?> data) {
					System.out.println("====================================================");
					System.out.println("Nuestro error handler que no hace nada");					
				}
			});			
		
		};
		
	}
	


}

