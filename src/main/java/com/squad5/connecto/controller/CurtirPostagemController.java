package com.squad5.connecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.squad5.connecto.model.CurtirPostagem;
import com.squad5.connecto.repository.CurtirPostagemRepository;

@RestController
@RequestMapping("/curtir")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CurtirPostagemController {
	@Autowired
	private CurtirPostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<CurtirPostagem>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CurtirPostagem> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<CurtirPostagem> post(@RequestBody CurtirPostagem curtir){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(curtir));
	}
	
	@PutMapping
	public ResponseEntity<CurtirPostagem> put(@RequestBody CurtirPostagem curtir){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(curtir));
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
