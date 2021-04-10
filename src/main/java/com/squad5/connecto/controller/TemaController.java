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

import com.squad5.connecto.model.Tema;
import com.squad5.connecto.repository.TemaRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tema")
@CrossOrigin("*")
public class TemaController {

	@Autowired
	private TemaRepository repository;
	
	@ApiOperation("retorna todas os temas")
	@GetMapping
	public ResponseEntity<List<Tema>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@ApiOperation("retorna uma postagem")
	@GetMapping("/{id}")
	public ResponseEntity<Tema> getById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@ApiOperation("retorna uma busca por categoria")
	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<Tema>> getByCategoria(@PathVariable String categoria) {
		return ResponseEntity.ok(repository.findAllByCategoriaContainingIgnoreCase(categoria));
	}
	
	@ApiOperation("Publica um tema")
	@PostMapping
	public ResponseEntity<Tema> post(@RequestBody Tema tema) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
		
	@ApiOperation("Altera um tema")
	@PutMapping
	public ResponseEntity<Tema> put(@RequestBody Tema tema) {
		return ResponseEntity.ok(repository.save(tema));

	}
	@ApiOperation("Deleta um tema")
	@DeleteMapping("/{id}") 
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
