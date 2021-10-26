package com.curso.flux_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.Pelicula;

import reactor.core.publisher.Flux;

@Component
public class PeliculaRepository {

	@Autowired
	private DataSource dataSource;
	
	public List<Pelicula> findAll(){	
		List<Pelicula> peliculas = new ArrayList<>();
		try (Connection cx = dataSource.getConnection()) {
			PreparedStatement pst = cx.prepareStatement("select * from pelicula");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Pelicula p = new Pelicula(
						rs.getInt("ID"),
						rs.getString("TITULO"),
						rs.getString("DIRECTOR"),
						rs.getString("GENERO"),
						rs.getInt("YEAR")
					);
				peliculas.add(p);	
				Thread.sleep(500);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		return peliculas;
	}
	
	public Flux<Pelicula> findAll_Reactivo(){		
		return Flux.generate(
				//State supplier
				() -> {
					Connection cx = dataSource.getConnection();
					PreparedStatement pst = cx.prepareStatement("select * from pelicula");
					pst.setFetchSize(25);
					ResultSet rs = pst.executeQuery();
					return rs;					
				},
				//Generator
				(rs, sink) -> {
					try {
						if(rs.next()) {
							Pelicula p = new Pelicula(
									rs.getInt("ID"),
									rs.getString("TITULO"),
									rs.getString("DIRECTOR"),
									rs.getString("GENERO"),
									rs.getInt("YEAR")
								);
							Thread.sleep(500);
							sink.next(p);
						} else {
							sink.complete();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					return rs; 
				},
				//State consumer
				//Se invoca a modo de 'finaly', después de que el generator haya incovado 'complete'
				rs -> {
					System.out.println("Cerrando la conexión");
					try {
						rs.getStatement().getConnection().close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}			
			);		
	}
	
}
