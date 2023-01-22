package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	 
	@GetMapping("/api/{name}")
	public List<Pessoa> selecionaPorNome(@PathVariable String name) {
		return pessoaRepository.findByName(name);
	}
	
	@PutMapping("/api/")
	public Pessoa editar(@RequestBody Pessoa pessoaObj) {
		return pessoaRepository.save(pessoaObj);
		
	}
	
	@DeleteMapping("/api/{id}")
	public void deletar(@PathVariable Long id) {
		pessoaRepository.deleteById(id);
	}
	
	@GetMapping("/api/contador")
	public Long contador() {
		return pessoaRepository.count();
	}
	
	@GetMapping("/api/ordenarNomes")
	public List<Pessoa> ordenarNomes(){
		return pessoaRepository.findByOrderByName();
	}
	
	@GetMapping("/api/nomeContain")
	public List<Pessoa> nomeContain(){
		return pessoaRepository.findByNameContaining("t");
	}
	
	
}
