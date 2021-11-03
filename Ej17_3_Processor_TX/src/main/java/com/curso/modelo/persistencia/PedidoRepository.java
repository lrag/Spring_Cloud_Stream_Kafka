package com.curso.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.modelo.entidad.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
}
