package com.curso;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PruebasQueue {

	public static void main(String[] args) {
		
		System.out.println("===============================");
		Queue<String> cola = new LinkedList<>();
		String txt = cola.poll();
		System.out.println(txt);

		System.out.println("===============================");
		BlockingQueue<String> colaBloqueante = new LinkedBlockingQueue<>();
		String txt2 = colaBloqueante.poll();
		System.out.println(txt2);
		try {
			String txt3 = colaBloqueante.take();
			System.out.println(txt3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("FIN");		
		
	}
	
}
