package com.curso.cfg;

import java.util.function.BiConsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.cloud.stream.config.ListenerContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.AbstractMessageListenerContainer;
import org.springframework.kafka.listener.DefaultAfterRollbackProcessor;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
public class Configuracion {
	
	@Bean
	public ListenerContainerCustomizer<AbstractMessageListenerContainer<byte[], byte[]>> customizer() {
		// Disable retry in the AfterRollbackProcessor
		
		/*
		ListenerContainerCustomizer<AbstractMessageListenerContainer<byte[], byte[]>> x = 
			new ListenerContainerCustomizer<AbstractMessageListenerContainer<byte[], byte[]>>() {
	
				@Override
				public void configure(AbstractMessageListenerContainer<byte[], byte[]> container, 
									  String destinationName,
									  String group) {
					
			
					
					BiConsumer<ConsumerRecord<byte[], byte[]>, Exception> bc = new BiConsumer<ConsumerRecord<byte[], byte[]>, Exception>() {
						@Override
						public void accept(ConsumerRecord<byte[], byte[]> record, Exception u) {
							System.out.println("Discarding failed record: " + record);
						}
					};
					
					DefaultAfterRollbackProcessor<byte[], byte[]> y = new DefaultAfterRollbackProcessor(bc,new FixedBackOff(0L, 0));
					container.setAfterRollbackProcessor(y);					
				}	
				
			};
		
		return x;
		*/
				
		
		return (container, destination, group) -> container.setAfterRollbackProcessor(
				new DefaultAfterRollbackProcessor<byte[], byte[]>(
						(record, exception) -> {							
							System.out.println("Discarding failed record: " + record);
						},
						new FixedBackOff(0L, 0))); //No queremos retry ni nada porque el rollback lo hemos hecho a posta y el mensaje se ha procesado						
		
	}

}

