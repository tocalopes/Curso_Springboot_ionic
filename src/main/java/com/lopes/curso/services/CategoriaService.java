package com.lopes.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lopes.curso.domain.Categoria;
import com.lopes.curso.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria find(Integer id) {
		Optional<Categoria> categoria = repository.findById(id);
		return categoria.orElse(null);
	}
	
	
}
