package com.curso.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import com.curso.modelo.entidad.OrdenCompra;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Integer>{
}
