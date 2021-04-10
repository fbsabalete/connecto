package com.squad5.connecto.controller;

import com.squad5.connecto.model.ComentarioPostagem;
import com.squad5.connecto.repository.ComentarioPostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ComentarioPostagemController {
    @Autowired
    private ComentarioPostagemRepository repository;

    @GetMapping
    public ResponseEntity<List<ComentarioPostagem>> GetAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComentarioPostagem> GetById(@PathVariable long id){
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ComentarioPostagem> post(@RequestBody ComentarioPostagem comentario){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(comentario));
    }

    @PutMapping
    public ResponseEntity<ComentarioPostagem> put(@RequestBody ComentarioPostagem comentario){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(comentario));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }
}
