package com.lopes.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lopes.curso.domain.Pedido;

//Objeto que faz comunicação com banco de dados
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
