package com.squad5.connecto.controller;

import com.squad5.connecto.model.Portfolio;
import com.squad5.connecto.repository.PortfolioRepository;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolio")
@CrossOrigin("*")
public class PortfolioController {


    @Autowired
    private PortfolioRepository repository;
    
    @GetMapping
    public ResponseEntity<List<Portfolio>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Portfolio> getById(@PathVariable long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Portfolio> post(@RequestBody Portfolio portfolio) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(portfolio));
    }

    @PutMapping
    public ResponseEntity<Portfolio> put(@RequestBody Portfolio portfolio) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(portfolio));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }
}
