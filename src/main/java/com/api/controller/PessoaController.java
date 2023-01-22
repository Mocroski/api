package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.entities.Pessoa;
import com.api.repository.PessoaRepository;

@RestController
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@PostMapping("/api")
	public Pessoa cadastrar(@RequestBody Pessoa pessoaObj) {
		return pessoaRepository.save(pessoaObj);
	}
	
	@GetMapping("/api")
	public List<Pessoa> selecionar() {
		return pessoaRepository.findAll();
	}
	
	/*
	 * @GetMapping("/api/{id}") public Optional<Pessoa> selecionaPorId(@PathVariable
	 * Long id) { return pessoaRepository.findById(id); }
	 */
	
	@GetMapping("/api/{name}")
	public List<Pessoa> selecionaPorNome(@PathVariable String name) {
		return pessoaRepository.findByName(name);
	}
	
	
}
