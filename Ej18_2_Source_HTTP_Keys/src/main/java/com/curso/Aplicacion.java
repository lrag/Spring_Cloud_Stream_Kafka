package com.curso;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.Comando;
import com.curso.productor.ProductorComandos;

@SpringBootApplication
@EnableTransactionManagement
public class Aplicacion implements CommandLineRunner{

	@Autowired
	private ApplicationContext appCtx;
	
	@Autowired
	private ProductorComandos productoComandos;
	
	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Cliente c1 = new Cliente("CLI-GM-1","Groucho Marx","C/Tal", "123");
		Cliente c2 = new Cliente("CLI-HC-2","Harry Callahan","C/Pascual", "321");
		Cliente c3 = new Cliente("CLI-JM-3","Jules Maigret","C/Tal y pascual", "456");
		Cliente c4 = new Cliente("AAAAAAAAAAAAAAAAAAAA","Isaac Asimov","C/Tal y pascual", "456");
		Cliente c5 = new Cliente("123456789","Chiquito de la calzada","C/Tal y pascual", "456");
		
		Comando[] arrayComandos = {
			new Comando(System.currentTimeMillis(), "INSERTAR",  c5),
			new Comando(System.currentTimeMillis(), "MODIFICAR", c5),
			new Comando(System.currentTimeMillis(), "BORRAR",    c5),
			new Comando(System.currentTimeMillis(), "INSERTAR",  c1),
			new Comando(System.currentTimeMillis(), "INSERTAR",  c2),
			new Comando(System.currentTimeMillis(), "INSERTAR",  c3),
			new Comando(System.currentTimeMillis(), "INSERTAR",  c4),
			new Comando(System.currentTimeMillis(), "MODIFICAR", c1),
			new Comando(System.currentTimeMillis(), "MODIFICAR", c2),
			new Comando(System.currentTimeMillis(), "MODIFICAR", c3),
			new Comando(System.currentTimeMillis(), "MODIFICAR", c4),
			new Comando(System.currentTimeMillis(), "BORRAR",    c1),
			new Comando(System.currentTimeMillis(), "BORRAR",    c2),
			new Comando(System.currentTimeMillis(), "BORRAR",    c3),
			new Comando(System.currentTimeMillis(), "BORRAR",    c4),
		};
		
		List<Comando> comandos = Arrays.asList(arrayComandos);
		comandos.forEach( cmd -> productoComandos.enviarComando(cmd));
		
		Thread.sleep(30000);
		SpringApplication.exit(appCtx, () -> 0);	
	}
	

}
