package com.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.entities.Message;
import com.api.entities.Pessoa;
import com.api.repository.PessoaRepository;

@Service
public class ServiceApi {

	@Autowired
	private Message message;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	//metodo para cadastrar pessoas
	public ResponseEntity<?> cadastrar(Pessoa obj){
		
		if(obj.getName().equals("")) {
			message.setMessage("O nome precisa ser oreebcgido");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(pessoaRepository.save(obj), HttpStatus.CREATED);
		
	}
	
	
	//metodo para selececioar pessoas
	
	@Autowired
	public ResponseEntity<?> selecionar() {
		return new ResponseEntity<>(pessoaRepository.findAll(), HttpStatus.OK);
	}
	
	/*
	 * //metodo para editar dados public ResponseEntity<?> editar(Pessoa obj) {
	 * 
	 * if(pessoaRepository.countById(obj.getId()) ==0) {
	 * message.setMessage("Id inexistente"); return new ResponseEntity<>(message,
	 * HttpStatus.NOT_FOUND); }else if(obj.getName().equals("")) {
	 * message.setMessage("é necessario inorma um nome"); return new
	 * ResponseEntity<>(message, HttpStatus.BAD_REQUEST); }else { return new
	 * ResponseEntity<>(pessoaRepository.save(obj), HttpStatus.OK); } }
	 */
	
	/*
	 * //metodo para remover public ResponseEntity<?> excluir(Long id) {
	 * 
	 * if(pessoaRepository.countById(id) == 0) {
	 * message.setMessage("Id inexistente"); return new
	 * ResponseEntity<>(message,HttpStatus.NOT_FOUND); }else {
	 * 
	 * Pessoa obj = pessoaRepository.findById(id); pessoaRepository.delete(obj);
	 * 
	 * message.setMessage("Removido com sucesso"); return new
	 * ResponseEntity<>(message, HttpStatus.OK); }
	 * 
	 * }
	 */
}
