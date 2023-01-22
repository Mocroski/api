package com.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.entities.Pessoa;


@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long>{
	
	List<Pessoa> findAll();
	
	List<Pessoa> findByName(String name);
}
