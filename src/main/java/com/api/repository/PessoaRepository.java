package com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.entities.Pessoa;


@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long>{
	
	List<Pessoa> findAll();
	
	List<Pessoa> findByName(String name);
	
	List<Pessoa> findByOrderByName();
	
	/* List<Pessoa> findByNameOrderByParametro(TipoParametro parametro); */
	
	List<Pessoa> findByNameContaining(String termo);
	
	List<Pessoa> findByNameStartsWith(String termo);
	
	List<Pessoa> findByNameEndsWith(String termo);
	
	/*
	 * @Query(value = "SELET SUM(parametro) FROM pessoas", nativeQuery = true) int
	 * somaId();
	 */
	
	
	@Query(value = "SELECT * FROM pessoas WHERE parametro >= :parametro", nativeQuery = true)
	List<Pessoa> parametroMaiorIgual(int parametro);
}
